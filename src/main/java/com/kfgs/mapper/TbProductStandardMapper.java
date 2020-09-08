package com.kfgs.mapper;

import com.kfgs.domain.TbStandard;
import com.kfgs.domain.TbStandardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbProductStandardMapper {

    List<TbStandard> selectByExample(TbStandardExample tbStandardExample);

    int insert(TbStandard record);

    int insertSelective(TbStandard record);

    int insertList(List<TbStandard> tbStandardList);

    int updateByPrimaryKeySelective(TbStandard record);

    int deleteByPrimaryKey(Integer id);

    int updateByExample(@Param("record") TbStandard record, @Param("example") TbStandardExample example);
}
