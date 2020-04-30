package com.kfgs.mapper;

import com.kfgs.domain.TbClassification;
import com.kfgs.domain.TbClassificationExample;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface TbClassificationMapper {

    List<String> selectParentId();

    int deleteByClassificationId(String id);

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

    List<TbClassification> selectProductIdAndAllTbClassification();

    TbClassification selectMaxClassificationIdMaxLevelAndParentIdByName(String name);

    int insertList(List<TbClassification> tbClassificationList);

    List<HashMap<String,String>> selectNameAndClassificationIdReturnMap(@Param("tableName") String tableName);

    List<HashMap<String, String>> selectNameAndLevelReturnMap(@Param("tableName") String tableName);

    List<HashMap<String, String>> selectNameAndParentIdReturnMap(@Param("tableName") String tableName);
}