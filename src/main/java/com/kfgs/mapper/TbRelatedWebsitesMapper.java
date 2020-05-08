package com.kfgs.mapper;

import com.kfgs.domain.TbRelatedWebsites;
import com.kfgs.domain.TbRelatedWebsitesExample;
import com.kfgs.domain.ext.TbRelatedWebsitesExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRelatedWebsitesMapper {
    int countByExample(TbRelatedWebsitesExample example);

    int deleteByExample(TbRelatedWebsitesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRelatedWebsites record);

    int insertSelective(TbRelatedWebsites record);

    List<TbRelatedWebsites> selectByExample(TbRelatedWebsitesExample example);

    TbRelatedWebsites selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRelatedWebsites record, @Param("example") TbRelatedWebsitesExample example);

    int updateByExample(@Param("record") TbRelatedWebsites record, @Param("example") TbRelatedWebsitesExample example);

    int updateByPrimaryKeySelective(TbRelatedWebsites record);

    int updateByPrimaryKey(TbRelatedWebsites record);

    List<TbRelatedWebsitesExt> getRelatedWebsitesList();
}