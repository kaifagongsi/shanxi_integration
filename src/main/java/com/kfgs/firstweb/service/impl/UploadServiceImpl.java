package com.kfgs.firstweb.service.impl;

import com.kfgs.domain.*;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.firstweb.service.UploadService;
import com.kfgs.mapper.TbClassficationCountryMapper;
import com.kfgs.mapper.TbProductShowMapper;
import com.kfgs.mapper.TbRelatedWebsitesMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    TbProductShowMapper tbProductShowMapper;

    @Autowired
    TbRelatedWebsitesMapper tbRelatedWebsitesMapper;

    @Autowired
    TbClassficationCountryMapper tbClassficationCountryMapper;


    @Override
    public String updateByExampleSelective(Map pData) {
        //已有国内产品展示数据的删除
        if (StringUtils.isNotBlank(pData.get("id").toString())) {
            TbProductShow tbProductShow = tbProductShowMapper.selectById(pData.get("id").toString());
            if (tbProductShow != null) {
                TbProductShowExample tbProductShowExample = new TbProductShowExample();
                tbProductShowExample.createCriteria().andIdEqualTo(Integer.parseInt(pData.get("id").toString()));
                tbProductShowMapper.deleteByExample(tbProductShowExample);
                tbClassficationCountryMapper.deleteByPrimaryKey(Integer.parseInt(pData.get("classificationId").toString()));
            }
        } else {

        }
        TbClassficationCountryExample example = new TbClassficationCountryExample();
        example.createCriteria().andNameEqualTo(pData.get("title").toString());
        List<TbClassficationCountry> list = tbClassficationCountryMapper.selectByExample(example);
        TbClassficationCountry classification = new TbClassficationCountry();
        if(list != null && list.size() > 0){
            //获取最大产品类别
            String classificationid = list.get(0).getParentid();
            classification = tbClassficationCountryMapper.selectMaxClassificationIdMaxLevelAndParentIdByClassificationId(classificationid);
        }else{
            example = new TbClassficationCountryExample();
            example.createCriteria().andNameEqualTo(pData.get("classificationName").toString());
            list = tbClassficationCountryMapper.selectByExample(example);
            if(list != null && list.size() > 0){
                //获取最大产品类别
                String classificationid = list.get(0).getClassificationid();
                classification = tbClassficationCountryMapper.selectMaxClassificationIdMaxLevelAndParentIdByClassificationId(classificationid);
            }
        }

        //插入新的数据
        Date currentDate = new Date();
        //2.向tbProductShwo插入数据
        TbProductShow tbProductShow  = new TbProductShow();
        tbProductShow.setTitle(pData.get("title").toString());
        tbProductShow.setType("展示");
        tbProductShow.setCreateTime(currentDate);
        tbProductShow.setIsdelete(0);
        tbProductShow.setContent(pData.get("content").toString().getBytes());
        List productShwoList = new ArrayList();
        productShwoList.add(tbProductShow);
        int insertList = tbProductShowMapper.insertList(productShwoList);

        //3.向tb_classfication_country表中插入数据
        int insertClassification = 0;
        if(classification != null){
            TbClassficationCountry tbClassficationCountry = new TbClassficationCountry();
            tbClassficationCountry.setName(pData.get("title").toString());
            tbClassficationCountry.setIsdelete(0);
            tbClassficationCountry.setCreateTime(currentDate);
            tbClassficationCountry.setRootid("2");
            tbClassficationCountry.setParentid(classification.getParentid());
            tbClassficationCountry.setClassificationid(String.format("%04d",Integer.parseInt(classification.getClassificationid())));
            tbClassficationCountry.setLevel(classification.getLevel());
            insertClassification = tbClassficationCountryMapper.insert(tbClassficationCountry);
        }
        if( 1 == insertClassification && 1 == insertList ){
            return "success";
        }else{
            return "fail";
        }
    }

    @Override
    public Map<String,Object> selectByPrimaryKey(Map pData){
        Map<String,Object> map = new HashMap<>();
        //1.查询产品的内容
        TbProductShowExample tbProductShowExample = new TbProductShowExample();
        String productId = pData.get("id").toString();
        tbProductShowExample.createCriteria().andTitleEqualTo(pData.get("title").toString());
        List<TbProductShow> model = tbProductShowMapper.selectByExampleWithBLOBs(tbProductShowExample);
        if (model !=null && model.size()== 1) {
            for (TbProductShow xx : model) {
                if(xx.getContent() == null){
                    map.put("content","相关资料等待上传中...");

                }else {
                    map.put("content", new String(xx.getContent()));
                }
            }
        }else if(model == null){
            map.put("content","参数错误");
        }
        //2查询相关网站、相关
        TbRelatedWebsitesExample example = new TbRelatedWebsitesExample();
        example.createCriteria().andProductIdEqualTo(productId).andTypeEqualTo("相关网站");
        List<TbRelatedWebsites> websites = tbRelatedWebsitesMapper.selectByExample(example);
        example.clear();
        example.createCriteria().andProductIdEqualTo(productId).andTypeEqualTo("相关企业");
        List<TbRelatedWebsites> enter = tbRelatedWebsitesMapper.selectByExample(example);
        if(websites.size() == 0 && enter.size() == 0 ){
            map.put("list","");
        }else{
            Map relatedWebSites = new HashMap();
            relatedWebSites.put("websites",websites);
            relatedWebSites.put("enter",enter);
            map.put("list",relatedWebSites);
        }
        return map;
    }


}
