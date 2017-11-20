package com.busi.mapper;

import com.busi.domain.Demission;
import com.busi.domain.DemissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

//@LZ_TAG_ID: IMPORT BEGIN 

//@LZ_TAG_ID: IMPORT END

public interface DemissionMapper {

    int countByExample(DemissionExample example);

    int deleteByExample(DemissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Demission record);

    int insertSelective(Demission record);

    List<Demission> selectByExample(DemissionExample example);

    Demission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Demission record, @Param("example") DemissionExample example);

    int updateByExample(@Param("record") Demission record, @Param("example") DemissionExample example);

    int updateByPrimaryKeySelective(Demission record);

    int updateByPrimaryKey(Demission record);

    //@LZ_TAG_ID: METHOD BEGIN

    //@LZ_TAG_ID: METHOD END
}