package com.kfgs.mapper;

import com.kfgs.domain.TbProductLandmark;
import com.kfgs.domain.TbProductLandmarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbProductLandmarkMapper {
    int countByExample(TbProductLandmarkExample example);

    int deleteByExample(TbProductLandmarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbProductLandmark record);

    int insertSelective(TbProductLandmark record);

    List<TbProductLandmark> selectByExampleWithBLOBs(TbProductLandmarkExample example);

    List<TbProductLandmark> selectByExample(TbProductLandmarkExample example);

    List<String> selectIndustryList();

    List<String> selectTypeList();

    List<String> selectProductNumberList();

    List<String> findTypeByIndustry(String name);

    TbProductLandmark selectByPrimaryKey(Integer id);

    TbProductLandmark selectByProductNumber(String productNumber);

    int updateByExampleSelective(@Param("record") TbProductLandmark record, @Param("example") TbProductLandmarkExample example);

    int updateByExampleWithBLOBs(@Param("record") TbProductLandmark record, @Param("example") TbProductLandmarkExample example);

    int updateByExample(@Param("record") TbProductLandmark record, @Param("example") TbProductLandmarkExample example);

    int updateByPrimaryKeySelective(TbProductLandmark record);

    int updateByPrimaryKeyWithBLOBs(TbProductLandmark record);

    int updateByPrimaryKey(TbProductLandmark record);

    int insertLandmark(TbProductLandmark record);

    int insertList(List<TbProductLandmark> landmarkList);


}