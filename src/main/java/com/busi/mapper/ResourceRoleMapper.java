package com.busi.mapper;

import com.busi.domain.ResourceRoleExample;
import com.busi.domain.ResourceRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

//@LZ_TAG_ID: IMPORT BEGIN 

//@LZ_TAG_ID: IMPORT END

public interface ResourceRoleMapper {

    int countByExample(ResourceRoleExample example);

    int deleteByExample(ResourceRoleExample example);

    int deleteByPrimaryKey(ResourceRoleKey key);

    int insert(ResourceRoleKey record);

    int insertSelective(ResourceRoleKey record);

    List<ResourceRoleKey> selectByExample(ResourceRoleExample example);

    int updateByExampleSelective(@Param("record") ResourceRoleKey record, @Param("example") ResourceRoleExample example);

    int updateByExample(@Param("record") ResourceRoleKey record, @Param("example") ResourceRoleExample example);

    //@LZ_TAG_ID: METHOD BEGIN

    //@LZ_TAG_ID: METHOD END
}