package com.kfgs.statistics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.*;
import com.kfgs.domain.ext.TbEnterpriseExt;
import com.kfgs.domain.ext.TbProductExt;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbClassificationMapper;
import com.kfgs.mapper.TbEnterpriseMapper;
import com.kfgs.mapper.TbProductMapper;
import com.kfgs.mapper.TbProductProtectionNoticeMapper;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.statistics.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Date: 2019-12-04-19-37
 * <p>Module:</p>
 * <p>Description:</p>
 *
 * @author:
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    TbProductMapper tbProductMapper;

    @Autowired
    TbClassificationMapper tbClassificationMapper;

   @Autowired
   TbProductProtectionNoticeMapper tbProductProtectionNoticeMapper;

   @Autowired
   TbEnterpriseMapper tbEnterpriseMapper;

    @Override
    public QueryResponseResult selectByDistinctApprovalYear() {
        List<String> list = tbProductMapper.selectDistinctProductApprovalYear();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public Map getList(Map searchMap){
        //返回页面结果集
        Map mapResult = new HashMap();
        TbProductExample slectExample = new TbProductExample();
        TbProductExample.Criteria criteria = slectExample.createCriteria();
        //检索的关键字
        String searchType = searchMap.get("searchType").toString();
        String searchVal = searchMap.get("searchVal").toString();
        if(searchType != null && searchType != "" && searchVal != null && searchVal != "" &&  !"请输入待查询信息".equals(searchVal)){
            if("name".equals(searchType)){
                criteria.andIsdeleteEqualTo(0).andNameLike('%' + searchVal + '%');
            }else if("classificationName".equals(searchType)){
                List<String> ids = new LinkedList<String>();
                TbClassificationExample tbClassificationExample = new TbClassificationExample();
                tbClassificationExample.createCriteria().andParentidEqualTo("0000").andNameLike('%' + searchVal + '%').andIsdeleteEqualTo(0);
                List<TbClassification> tbClassifications = tbClassificationMapper.selectByExample(tbClassificationExample);
                if(tbClassifications != null && tbClassifications.size() > 0){
                    for(TbClassification  tbClassification : tbClassifications){
                        // 获取分类的名称 根据分类ID
                        tbClassificationExample = new TbClassificationExample();
                        tbClassificationExample.createCriteria().andParentidEqualTo(tbClassification.getClassificationid());
                        List<TbClassification> classificationList = tbClassificationMapper.selectByExample(tbClassificationExample);
                        if(classificationList != null && classificationList.size() > 0){
                            for(TbClassification temp : classificationList){
                                ids.add(temp.getClassificationid());
                            }
                        }
                    }
                    if(ids != null && ids.size() > 0){
                        criteria.andIsdeleteEqualTo(0).andClassificationidIn(ids);
                    }
                }
            }else if("administrativeAreaName".equals(searchType)){
                slectExample.or().andIsdeleteEqualTo(0).andProvinceNameLike('%' + searchVal + '%');
                slectExample.or().andIsdeleteEqualTo(0).andCityNameLike('%' + searchVal + '%');
            }else if("approvalYear".equals(searchType)){
                criteria.andIsdeleteEqualTo(0).andApprovalYearLike('%' + searchVal + '%');
            }
        }
        criteria.andIsdeleteEqualTo(0);
        slectExample.setOrderByClause("  create_time desc  ");
        PageHelper.startPage(Integer.parseInt(searchMap.get("pageNo").toString()),15);
        Page<TbProductExt> page = (Page<TbProductExt>) tbProductMapper.getList(slectExample);
        mapResult.put("rows",page.getResult());
        mapResult.put("totalPages", page.getPages());
        mapResult.put("total",page.getTotal());
        return mapResult;
    }

    @Override
    public Map<String, Object> getProductInfo(String productId) {
        Map resultMap = new HashMap();
        if (productId == null || productId == "") {
            resultMap.put("state","200");
            resultMap.put("message","参数错误");
            return resultMap;
        }
        TbProduct product = tbProductMapper.selectByPrimaryKey(Integer.parseInt(productId));
        TbProductExt tbProductExt = new TbProductExt();
        BeanUtils.copyProperties(product,tbProductExt);
        // 获取分类的名称 根据分类ID
        TbClassificationExample example = new TbClassificationExample();
        example.createCriteria().andClassificationidEqualTo(product.getClassificationid().substring(0,2)+"00").andIsdeleteEqualTo(0);
        List<TbClassification> classificationList = tbClassificationMapper.selectByExample(example);
        if(classificationList.size() <= 0 ){
            resultMap.put("state","200");
            resultMap.put("message","未知错误");
            return resultMap;
        }
        tbProductExt.setClassificationName(classificationList.get(0).getName());
        //拼装区域
        tbProductExt.setArea(product.getProvinceName()+product.getCityName());
        //核准公告为1对1 所有不用处理
        //受理公告可能为1对多，需要处理
        String gongGaoTitleAndTime = getShouLiGongGaoByProductId(productId);
        if("--".equals(gongGaoTitleAndTime)){
            tbProductExt.setProtectionNoticeTitle("");
            tbProductExt.setNoticeTime("");
        }else{
            tbProductExt.setProtectionNoticeTitle(gongGaoTitleAndTime.split("--")[0]);
            tbProductExt.setNoticeTime(gongGaoTitleAndTime.split("--")[1]);
        }
        resultMap.put("state","200");
        resultMap.put("data",tbProductExt);
        //处理核准公告
        List<TbEnterpriseExt> enterpriseExts = tbEnterpriseMapper.selectEnterpriseByProductId(productId);
        resultMap.put("list",enterpriseExts);
        return resultMap;
    }

    private String getShouLiGongGaoByProductId(String productId){
        List<TbProtectionNotice> protectionNotices = tbProductProtectionNoticeMapper.selectGongGaoTitleByProducrId(productId);
        StringBuilder title = new StringBuilder();
        StringBuilder time = new StringBuilder();
        for(int i = 0; i < protectionNotices.size(); i++ ){
            title.append(protectionNotices.get(i).getTitle());
            time.append(protectionNotices.get(i).getNoticeTime());
            if(i != protectionNotices.size() - 1){
                title.append(",");
                time.append(",");
            }
        }
        return title.toString()+"--"+time.toString();
    }
}
