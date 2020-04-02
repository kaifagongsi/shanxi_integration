package com.kfgs.firstweb.service.impl;

import com.kfgs.domain.TbProductShow;
import com.kfgs.domain.TbProductShowExample;
import com.kfgs.domain.TbRelatedWebsites;
import com.kfgs.domain.TbRelatedWebsitesExample;
import com.kfgs.firstweb.service.UploadService;
import com.kfgs.mapper.TbProductShowMapper;
import com.kfgs.mapper.TbRelatedWebsitesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    TbProductShowMapper tbProductShowMapper;

    @Autowired
    TbRelatedWebsitesMapper tbRelatedWebsitesMapper;

    @Override
    public int updateByExampleSelective(Map pData){
        TbProductShow record = new TbProductShow();
        record.setContent(pData.get("content").toString().getBytes());
        TbProductShowExample selectExample = new TbProductShowExample();
        selectExample.createCriteria().andTitleEqualTo(pData.get("title").toString());
        int returnResult = tbProductShowMapper.updateByExampleSelective(record, selectExample);
        return returnResult;
    }

    @Override
    public Map<String,Object> selectByPrimaryKey(Map pData){
        Map<String,Object> map = new HashMap<>();
        //1.查询产品的内容
        TbProductShowExample tbProductShowExample = new TbProductShowExample();
        String productId = pData.get("id").toString();
        tbProductShowExample.createCriteria().andIdEqualTo(Integer.parseInt(productId)).andTitleEqualTo(pData.get("title").toString());
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
