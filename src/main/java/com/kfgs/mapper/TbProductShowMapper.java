package com.kfgs.mapper;

import com.kfgs.domain.TbProductShow;
import com.kfgs.domain.TbProductShowExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbProductShowMapper {
    int countByExample(TbProductShowExample example);

    int deleteByExample(TbProductShowExample example);

    int insert(TbProductShow record);

    int insertSelective(TbProductShow record);

    List<TbProductShow> selectByExampleWithBLOBs(TbProductShowExample example);

    List<TbProductShow> selectByExample(TbProductShowExample example);

    int updateByExampleSelective(@Param("record") TbProductShow record, @Param("example") TbProductShowExample example);

    int updateByExampleWithBLOBs(@Param("record") TbProductShow record, @Param("example") TbProductShowExample example);

    int updateByExample(@Param("record") TbProductShow record, @Param("example") TbProductShowExample example);
}