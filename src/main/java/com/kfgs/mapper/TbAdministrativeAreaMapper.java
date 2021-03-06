package com.kfgs.mapper;

import com.kfgs.domain.TbAdministrativeArea;
import com.kfgs.domain.TbAdministrativeAreaExample;
import com.kfgs.domain.TbAdministrativeAreaKey;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    String selectCityIdByCityName(String name);

    /**
     *  Name 为key
     *  CityId 为value
     */
    List<HashMap<String,String>> selectCityIdAndNameReturnMap();

    /**
     *  CityId 为key
     *  Name 为value
     */
    List<HashMap<String,String>> selectNameAndCityIdReturnMap();
}