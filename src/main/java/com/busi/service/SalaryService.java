package com.busi.service;

import com.busi.controller.ReturnData;
import com.busi.domain.Salary;
import com.busi.domain.SalaryExample;
import com.busi.domain.SalaryExample.Criteria;
import com.busi.domain.User;
import com.busi.exception.BusinessException;
import com.busi.mapper.SalaryMapper;
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
@Service("salaryService")
public class SalaryService {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SalaryMapper salaryMapper;
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
    public void addSalary(Salary salary, ReturnData returnData) {
        try{
            int result = salaryMapper.insert(salary);
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
     * 修改工资信息
     * @param user
     * @param returnData
     */
    public void editSalary(Salary salary, ReturnData returnData) {
    	try{
    		int result = salaryMapper.updateByPrimaryKey(salary);
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
	public List<Salary> querySalarys() {
		return salaryMapper.selectByExample(null);
	}
	
	//根据ID查询用工单位
	public Salary querySalary(long id) {
		return salaryMapper.selectByPrimaryKey(id);
	}

	/**
	 * 检测用工单位名是否可用
	 * @param name
	 * @return true：代表当前用工单位名可用   fasle：不可用
	 */
	public boolean checkSalaryName(String name) {
		SalaryExample example = new SalaryExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		long count = salaryMapper.countByExample(example);
		return count == 0;
	}

	/**
	 * 检测用工单位类型是否可用
	 * @param name
	 * @return true：代表当前用工单位名可用   fasle：不可用
	 */
	public boolean checkSalaryType(String type) {
		SalaryExample example = new SalaryExample();
		Criteria criteria = example.createCriteria();
//		criteria.andTypeEqualTo(type);
		long count = salaryMapper.countByExample(example);
		return count == 0;
	}

}
