package com.kfgs.mapper;

import com.kfgs.domain.TbProductLandmark;
import com.kfgs.domain.TbProductLandmarkExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface TbProductLandmarkMapper {
    int countByExample(TbProductLandmarkExample example);

    int deleteByExample(TbProductLandmarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbProductLandmark record);

    int insertSelective(TbProductLandmark record);

    List<TbProductLandmark> selectByExample(TbProductLandmarkExample example);

    TbProductLandmark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbProductLandmark record, @Param("example") TbProductLandmarkExample example);

    int updateByExample(@Param("record") TbProductLandmark record, @Param("example") TbProductLandmarkExample example);

    int updateByPrimaryKeySelective(TbProductLandmark record);

    int updateByPrimaryKey(TbProductLandmark record);

    List<String> selectIndustry();

    List<String> selectTypeByIndustry(@Param("industry") String industry);

    List<TbProductLandmark> getList(@Param("industry") String industry, @Param("type") String type,@Param("city") String city,@Param("county") String county,@Param("year") String year,@Param("keywords") String keywords);
}