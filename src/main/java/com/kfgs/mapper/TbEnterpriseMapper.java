package com.kfgs.mapper;

import com.kfgs.domain.TbEnterprise;
import com.kfgs.domain.TbEnterpriseExample;
import com.kfgs.domain.ext.TbEnterpriseExcel;
import com.kfgs.domain.ext.TbEnterpriseExt;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbEnterpriseMapper {
    int countByExample(TbEnterpriseExample example);

    int deleteByExample(TbEnterpriseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbEnterprise record);

    int insertSelective(TbEnterprise record);

    List<TbEnterprise> selectByExample(TbEnterpriseExample example);

    TbEnterprise selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbEnterprise record, @Param("example") TbEnterpriseExample example);

    int updateByExample(@Param("record") TbEnterprise record, @Param("example") TbEnterpriseExample example);

    int updateByPrimaryKeySelective(TbEnterprise record);

    int updateByPrimaryKey(TbEnterprise record);

    List<Map> selectEnterpriseGroupByApprovalYear();

    List<TbEnterprise> selectByIdInList(List list);

    List<String> selectDistinctEnterpriseApprovalYear();


   /* //柱状图
    List<Map> selectHistogramByProEnt(@Param("year")String year,@Param("classification") String classification,@Param("parentId")String parentId);

    //获取面积饼图数据
    List<Map> selectPieAreaEnt(@Param("year")String year,@Param("classification") String classification,@Param("parentId")String parentId);*/

    @MapKey("id")
    Map<Integer, Map> selectByIdAndName();

    //柱状图
    List<Map> selectHistogramByProEnt(@Param("year") String year, @Param("classification") String classification, @Param("parentId") String parentId);

    //获取面积饼图数据
    List<Map> selectPieAreaEnt(@Param("year") String year, @Param("classification") String classification, @Param("parentId") String parentId);

    //折线图数据
    List<Map> selectLineChartByYearEnt(@Param("classification") String classification, @Param("parentId") String parentId);

    //使用地标企业
    List<TbEnterpriseExt> selectSydbqyList(TbEnterpriseExt tbEnterpriseExt);

    List<TbEnterpriseExt> selectEnterpriseByProductId(String productId);


    List<TbEnterpriseExt> selectByExampleReturnTBEXT( TbEnterpriseExample example);

    int insertList(List<TbEnterpriseExcel> enterpriseList);

    List<TbEnterpriseExt> selectAdminEnterpriseList();

    TbEnterpriseExt selectById(String id);

    int deleteById(Integer id);

    int selectCountWeiBianGen();

    int insertWithOutId(TbEnterpriseExt tbEnterpriseExt);
}
