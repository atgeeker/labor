package com.busi.mapper;

import com.busi.domain.Organization;
import com.busi.domain.OrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

//@LZ_TAG_ID: IMPORT BEGIN 

//@LZ_TAG_ID: IMPORT END

public interface OrganizationMapper {

    int countByExample(OrganizationExample example);

    int deleteByExample(OrganizationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(Organization record);

    List<Organization> selectByExample(OrganizationExample example);

    Organization selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationExample example);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    //@LZ_TAG_ID: METHOD BEGIN

    //@LZ_TAG_ID: METHOD END
}