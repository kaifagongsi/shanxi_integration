package com.kfgs.mapper;

import com.kfgs.domain.TbAdministrativeArea;
import com.kfgs.domain.TbAdministrativeAreaExample;
import com.kfgs.domain.TbAdministrativeAreaKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbAdministrativeAreaMapper {
    int countByExample(TbAdministrativeAreaExample example);

    int deleteByExample(TbAdministrativeAreaExample example);

    int deleteByPrimaryKey(TbAdministrativeAreaKey key);

    int insert(TbAdministrativeArea record);

    int insertSelective(TbAdministrativeArea record);

    List<TbAdministrativeArea> selectByExample(TbAdministrativeAreaExample example);

    TbAdministrativeArea selectByPrimaryKey(TbAdministrativeAreaKey key);

    int updateByExampleSelective(@Param("record") TbAdministrativeArea record, @Param("example") TbAdministrativeAreaExample example);

    int updateByExample(@Param("record") TbAdministrativeArea record, @Param("example") TbAdministrativeAreaExample example);

    int updateByPrimaryKeySelective(TbAdministrativeArea record);

    int updateByPrimaryKey(TbAdministrativeArea record);
}