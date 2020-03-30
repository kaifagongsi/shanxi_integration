package com.kfgs.mapper;

import com.kfgs.domain.TbClassification;
import com.kfgs.domain.TbClassificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbClassificationMapper {
    int countByExample(TbClassificationExample example);

    int deleteByExample(TbClassificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbClassification record);

    int insertSelective(TbClassification record);

    List<TbClassification> selectByExample(TbClassificationExample example);

    TbClassification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbClassification record, @Param("example") TbClassificationExample example);

    int updateByExample(@Param("record") TbClassification record, @Param("example") TbClassificationExample example);

    int updateByPrimaryKeySelective(TbClassification record);

    int updateByPrimaryKey(TbClassification record);
}