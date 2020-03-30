package com.kfgs.mapper;

import com.kfgs.domain.TbClassficationCountry;
import com.kfgs.domain.TbClassficationCountryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbClassficationCountryMapper {
    int countByExample(TbClassficationCountryExample example);

    int deleteByExample(TbClassficationCountryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbClassficationCountry record);

    int insertSelective(TbClassficationCountry record);

    List<TbClassficationCountry> selectByExample(TbClassficationCountryExample example);

    TbClassficationCountry selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbClassficationCountry record, @Param("example") TbClassficationCountryExample example);

    int updateByExample(@Param("record") TbClassficationCountry record, @Param("example") TbClassficationCountryExample example);

    int updateByPrimaryKeySelective(TbClassficationCountry record);

    int updateByPrimaryKey(TbClassficationCountry record);
}