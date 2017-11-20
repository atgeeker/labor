package com.busi.service;

import com.busi.controller.ReturnData;
import com.busi.domain.Employee;
import com.busi.domain.Employee;
import com.busi.domain.User;
import com.busi.exception.BusinessException;
import com.busi.mapper.EmployeeMapper;
import com.busi.mapper.UserMapper;
import com.busi.util.Constants;
import com.core.shiro.util.CreatePasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by zzy on 2017/8/17.
 */
@Service("employeeService")
public class EmployeeService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmployeeMapper employeeMapper;


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
     * 添加员工
     * @param user
     * @param returnData
     */
    public void addEmployee(Employee employee, ReturnData returnData) {
        try{
            int result = employeeMapper.insertSelective(employee);
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
     * 修改员工信息
     * @param user
     * @param returnData
     */
    public void editEmployee(Employee employee, ReturnData returnData) {
    	try{
    		int result = employeeMapper.updateByPrimaryKey(employee);
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


	/**
	 * 根据ID查询员工信息
	 * @param id
	 * @return
	 */
	public Employee queryEmployee(Long id) {
		return employeeMapper.selectByPrimaryKey(id);
	}

}
