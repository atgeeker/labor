package com.busi.service;

import com.busi.domain.User;
import com.busi.exception.BusinessException;
import com.busi.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zzy on 2017/8/18.
 */
@Service("userCoreService")
public class UserCoreService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = BusinessException.class)
    public void addUser() {
        try{
            for(int i=0;i<5;i++){
                User user = new User();
                user.setId(Long.parseLong(i+200+""));
                user.setIpaddress("127.0.0.1");
                user.setUsername("王五");
                user.setSalt("456");
                user.setPassword("91029283738");
                user.setStatus("1");
                userMapper.insert(user);
                if(i == 2){
                    throw new BusinessException("故意失败2");
                }
            }
        }catch (Exception e){
            log.error("插入失败2",e);
            throw new BusinessException("故意失败2---");
        }
    }
}
