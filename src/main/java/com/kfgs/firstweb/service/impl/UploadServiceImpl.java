package com.kfgs.firstweb.service.impl;

import com.kfgs.domain.TbProductShow;
import com.kfgs.domain.TbProductShowExample;
import com.kfgs.firstweb.service.UploadService;
import com.kfgs.mapper.TbProductShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    TbProductShowMapper tbProductShowMapper;

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
        tbProductShowExample.createCriteria().andIdEqualTo(Integer.parseInt(pData.get("id").toString())).andTitleEqualTo(pData.get("title").toString());
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

        return map;
    }


}
