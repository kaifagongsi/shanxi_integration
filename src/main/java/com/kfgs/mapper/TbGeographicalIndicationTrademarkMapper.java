package com.kfgs.mapper;

import com.kfgs.domain.TbGeographicalIndicationTrademark;
import com.kfgs.domain.TbGeographicalIndicationTrademarkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbGeographicalIndicationTrademarkMapper {
    int countByExample(TbGeographicalIndicationTrademarkExample example);

    int deleteByExample(TbGeographicalIndicationTrademarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbGeographicalIndicationTrademark record);

    int insertSelective(TbGeographicalIndicationTrademark record);

    List<TbGeographicalIndicationTrademark> selectByExample(TbGeographicalIndicationTrademarkExample example);

    TbGeographicalIndicationTrademark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbGeographicalIndicationTrademark record, @Param("example") TbGeographicalIndicationTrademarkExample example);

    int updateByExample(@Param("record") TbGeographicalIndicationTrademark record, @Param("example") TbGeographicalIndicationTrademarkExample example);

    int updateByPrimaryKeySelective(TbGeographicalIndicationTrademark record);

    int updateByPrimaryKey(TbGeographicalIndicationTrademark record);

    int insertList(List<TbGeographicalIndicationTrademark> trademarkList);
}