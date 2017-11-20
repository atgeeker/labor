package com.busi.mapper;

import com.busi.domain.Social_security;
import com.busi.domain.Social_securityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

//@LZ_TAG_ID: IMPORT BEGIN 

//@LZ_TAG_ID: IMPORT END

public interface Social_securityMapper {

    int countByExample(Social_securityExample example);

    int deleteByExample(Social_securityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Social_security record);

    int insertSelective(Social_security record);

    List<Social_security> selectByExample(Social_securityExample example);

    Social_security selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Social_security record, @Param("example") Social_securityExample example);

    int updateByExample(@Param("record") Social_security record, @Param("example") Social_securityExample example);

    int updateByPrimaryKeySelective(Social_security record);

    int updateByPrimaryKey(Social_security record);

    //@LZ_TAG_ID: METHOD BEGIN

    //@LZ_TAG_ID: METHOD END
}