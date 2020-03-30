package com.kfgs.mapper;

import com.kfgs.domain.TbComplaintsAboutRightsProtection;
import com.kfgs.domain.TbComplaintsAboutRightsProtectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbComplaintsAboutRightsProtectionMapper {
    int countByExample(TbComplaintsAboutRightsProtectionExample example);

    int deleteByExample(TbComplaintsAboutRightsProtectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbComplaintsAboutRightsProtection record);

    int insertComplain(TbComplaintsAboutRightsProtection record);

    int insertSelective(TbComplaintsAboutRightsProtection record);

    List<TbComplaintsAboutRightsProtection> selectByExample(TbComplaintsAboutRightsProtectionExample example);

    TbComplaintsAboutRightsProtection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbComplaintsAboutRightsProtection record, @Param("example") TbComplaintsAboutRightsProtectionExample example);

    int updateByExample(@Param("record") TbComplaintsAboutRightsProtection record, @Param("example") TbComplaintsAboutRightsProtectionExample example);

    int updateByPrimaryKeySelective(TbComplaintsAboutRightsProtection record);

    int updateByPrimaryKey(TbComplaintsAboutRightsProtection record);
}