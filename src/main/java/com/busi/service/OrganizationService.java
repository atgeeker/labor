package com.busi.service;

import com.busi.controller.ReturnData;
import com.busi.domain.Organization;
import com.busi.domain.OrganizationExample;
import com.busi.domain.OrganizationExample.Criteria;
import com.busi.domain.User;
import com.busi.exception.BusinessException;
import com.busi.mapper.OrganizationMapper;
import com.busi.mapper.UserMapper;
import com.busi.util.Constants;
import com.core.shiro.util.CreatePasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * Created by zzy on 2017/8/17.
 */
@Service("orgService")
public class OrganizationService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrganizationMapper orgMapper;
//    @Autowired
//    private UserCoreService userCoreService;
    @Autowired
    private CreatePasswordUtil createPasswordUtil;


    /**
     * 事务处理测试
     * 会处在同一个事物中
     */
   /* @Transactional(rollbackFor = BusinessException.class)
    public void addOrg() {
        try{
            for(int i=0;i<10;i++){
                User user = new User();
                user.setId(Long.parseLong(i+100+""));
                user.setIpaddress("127.0.0.1");
                user.setUsername("zhangsan");
                user.setSalt("123");
                user.setPassword("1292019289292929");
                user.setStatus("1");
                userMapper.insert(user);
                if(i == 3){
                    throw new BusinessException("故意失败,事务回滚");
                }
            }

            userCoreService.addUser();

        }catch (Exception e){
            log.error("插入失败",e);
            throw new BusinessException("故意失败---");
        }
    }*/

    /**
     * 添加用工单位
     * @param user
     * @param returnData
     */
    public void addOrg(Organization org, ReturnData returnData) {
        try{
            int result = orgMapper.insert(org);
            log.info("插入结果："+result);
            if(result  > 0){
                returnData.setErrorMsg("添加成功");
                returnData.setErrorCode(Constants.SUCCESS);
            }else{
                returnData.setErrorMsg("添加失败");
                returnData.setErrorCode(Constants.FAIL);
            }

        }catch (Exception e){
            log.error("插入失败",e);
            throw new BusinessException("数据库操作失败");
        }
    }
    
    /**
     * 修改用工单位
     * @param user
     * @param returnData
     */
    public void editOrg(Organization org, ReturnData returnData) {
    	try{
    		int result = orgMapper.updateByPrimaryKey(org);
    		log.info("修改结果："+result);
    		if(result  > 0){
    			returnData.setErrorMsg("修改成功");
    			returnData.setErrorCode(Constants.SUCCESS);
    		}else{
    			returnData.setErrorMsg("修改失败");
    			returnData.setErrorCode(Constants.FAIL);
    		}
    		
    	}catch (Exception e){
    		log.error("修改失败",e);
    		throw new BusinessException("数据库操作失败");
    	}
    }


    //查询用工单位列表
	public List<Organization> queryOrgs() {
		return orgMapper.selectByExample(null);
	}
	
	//根据ID查询用工单位
	public Organization queryOrg(long id) {
		return orgMapper.selectByPrimaryKey(id);
	}

	/**
	 * 检测用工单位名是否可用
	 * @param name
	 * @return true：代表当前用工单位名可用   fasle：不可用
	 */
	public boolean checkOrgName(String name) {
		OrganizationExample example = new OrganizationExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		long count = orgMapper.countByExample(example);
		return count == 0;
	}

	/**
	 * 检测用工单位类型是否可用
	 * @param name
	 * @return true：代表当前用工单位名可用   fasle：不可用
	 */
	public boolean checkOrgType(String type) {
		OrganizationExample example = new OrganizationExample();
		Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type);
		long count = orgMapper.countByExample(example);
		return count == 0;
	}

}
