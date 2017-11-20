package com.busi.mapper;

import com.busi.domain.Resource;
import com.busi.domain.ResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

//@LZ_TAG_ID: IMPORT BEGIN 

//@LZ_TAG_ID: IMPORT END

public interface ResourceMapper {

    int countByExample(ResourceExample example);

    int deleteByExample(ResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    List<Resource> selectByExample(ResourceExample example);

    Resource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);

    //@LZ_TAG_ID: METHOD BEGIN

    //@LZ_TAG_ID: METHOD END
}