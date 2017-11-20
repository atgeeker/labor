package com.core.shiro.filter;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.busi.domain.User;

/**
 * 控制同一用户只能在一处进行登录
 *
 * @author zzy
 */
public class KickoutSessionFilter extends AccessControlFilter {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 踢出后重定向的地址
     */
    private String kickoutUrl;

    /**
     * 踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
     */
    private boolean kickoutAfter = false;

    /**
     * 同一个帐号最大会话数 默认1
     */
    private int maxSession = 1;

    /**
     * 会话管理器
     */
    private SessionManager sessionManager;

    private Cache<String, Deque<Serializable>> cache;

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("shiro-kickout-session");
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        //获取用户
        Subject subject = getSubject(request, response);

        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            // 如果没有登录，直接进行之后的流程
            return true;
        }

        //获取session
        Session session = subject.getSession();
        User user = (User) subject.getPrincipal();
        String username = user.getUsername();

        //获取sessionId
        Serializable sessionId = session.getId();

        // TODO 同步控制
        Deque<Serializable> deque = cache.get(username);

        if (deque == null) {
            deque = new LinkedList<Serializable>();
            cache.put(username, deque);
        }

        // 如果队列里没有此sessionId，且用户没有被踢出；放入队列
        if (!deque.contains(sessionId) && session.getAttribute("kickout") == null) {
            deque.push(sessionId);
        }

        // 如果队列里的sessionId数超出最大会话数，开始踢人
        while (deque.size() > maxSession) {
            Serializable kickoutSessionId = null;

            if (kickoutAfter) { // 如果踢出后者
                kickoutSessionId = deque.removeFirst();
            } else { // 否则踢出前者
                kickoutSessionId = deque.removeLast();
            }

            try {

                Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));

                if (kickoutSession != null) {
                    // 设置会话的kickout属性表示踢出了
                    kickoutSession.setAttribute("kickout", true);
                }
            } catch (Exception e) {// ignore exception
                if (log.isDebugEnabled()) {
                    log.debug("异常-->", e);
                }
            }
        }

        // 如果被踢出了，直接退出，重定向到踢出后的地址
        if (session.getAttribute("kickout") != null) {
            // 会话被踢出了
            try {
                subject.logout();
            } catch (Exception e) { // ignore
                log.error("登出异常-->", e);
            }

            saveRequest(request);
            //重定向
            WebUtils.issueRedirect(request, response, kickoutUrl);

            return false;
        }
        return true;
    }
}
