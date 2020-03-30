package com.kfgs.mapper;

import com.kfgs.domain.TbProduct;
import com.kfgs.domain.TbProductExample;
import com.kfgs.domain.ext.TbProductExt;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbProductMapper {
    int countByExample(TbProductExample example);

    int deleteByExample(TbProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbProduct record);

    int insertSelective(TbProduct record);

    List<TbProduct> selectByExample(TbProductExample example);

    TbProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbProduct record, @Param("example") TbProductExample example);

    int updateByExample(@Param("record") TbProduct record, @Param("example") TbProductExample example);

    int updateByPrimaryKeySelective(TbProduct record);

    int updateByPrimaryKey(TbProduct record);

    List<Map<String,String>> selectProductGroupByApprovalYear();

    List<String> selectDistinctProductApprovalYear();

    List<TbProduct> selectByIdInList(List list);

    //柱状图
    List<Map> selectHistogramByPro(@Param("year") String year, @Param("classification") String classification, @Param("parentId") String parentId);

    //面积图
    List<Map> selectPieAreaData(@Param("year") String year, @Param("classification") String classification, @Param("parentId") String parentId);

    //折线图
    List<Map> selectLineChartByYear(@Param("classification") String classification, @Param("parentId") String parentId);

    //获取产品list
    List<TbProduct> selectListSecondTable(@Param("year") String year, @Param("classification") String classification, @Param("parentId") String parentId);

    //获取列表产品的扩展
    List<TbProductExt>  selectListSecondTableByExt(@Param("year") String year, @Param("classification") String classification, @Param("parentId") String parentId);

    @MapKey("id")
    Map<Integer, Map> selectByIdAndName();

    //产品列表
    List<TbProductExt> getList(TbProductExample example);
}