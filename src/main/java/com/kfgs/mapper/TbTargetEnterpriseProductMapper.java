package com.kfgs.mapper;

import com.kfgs.domain.TbTargetEnterpriseProduct;
import com.kfgs.domain.TbTargetEnterpriseProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbTargetEnterpriseProductMapper {
    int countByExample(TbTargetEnterpriseProductExample example);

    int deleteByExample(TbTargetEnterpriseProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbTargetEnterpriseProduct record);

    int insertSelective(TbTargetEnterpriseProduct record);

    List<TbTargetEnterpriseProduct> selectByExample(TbTargetEnterpriseProductExample example);

    TbTargetEnterpriseProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbTargetEnterpriseProduct record, @Param("example") TbTargetEnterpriseProductExample example);

    int updateByExample(@Param("record") TbTargetEnterpriseProduct record, @Param("example") TbTargetEnterpriseProductExample example);

    int updateByPrimaryKeySelective(TbTargetEnterpriseProduct record);

    int updateByPrimaryKey(TbTargetEnterpriseProduct record);
}