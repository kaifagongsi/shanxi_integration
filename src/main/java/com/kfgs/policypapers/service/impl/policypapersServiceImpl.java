package com.kfgs.policypapers.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.TbComplaintsAboutRightsProtectionExample;
import com.kfgs.domain.TbPolicyDocument;
import com.kfgs.domain.TbPolicyDocumentExample;
import com.kfgs.mapper.TbPolicyDocumentMapper;
import com.kfgs.policypapers.service.policypapersService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class policypapersServiceImpl implements policypapersService {


    @Autowired
    TbPolicyDocumentMapper tbPolicyDocumentMapper;

    //查找各类政策文件数据
    @Override
    public Map<String,List<TbPolicyDocument>> getList() {
        Map<String,List<TbPolicyDocument>> map = new HashMap<String,List<TbPolicyDocument>>();
        TbPolicyDocumentExample slectExample = new TbPolicyDocumentExample();
        slectExample.createCriteria().andIsdeleteEqualTo(0);
        List<TbPolicyDocument> tbPolicyDocuments = tbPolicyDocumentMapper.selectByExample(slectExample);
        if(tbPolicyDocuments != null && tbPolicyDocuments.size() > 0){
            for(TbPolicyDocument tmp : tbPolicyDocuments){
                if(map.containsKey(tmp.getTypeval())){
                    List<TbPolicyDocument> list = map.get(tmp.getTypeval());
                    list.add(tmp);
                    map.put(tmp.getTypeval(),list);
                }else{
                    List<TbPolicyDocument> list = new ArrayList<TbPolicyDocument>();
                    list.add(tmp);
                    map.put(tmp.getTypeval(),list);
                }
            }
        }
        return map;
    }


    @Override
    public Map<String,Object> getList(Map searchMap) {
        PageHelper.startPage(Integer.parseInt(searchMap.get("pageNo").toString()),15);
        //返回页面结果集
        Map<String,Object> map = new HashMap<>();
        TbPolicyDocumentExample slectExample = new TbPolicyDocumentExample();
        TbPolicyDocumentExample.Criteria criteria = slectExample.createCriteria();
        criteria.andIsdeleteEqualTo(0);
        //查询关键字
        String keywords = searchMap.get("keywords").toString();
        if(StringUtils.isNotBlank(ObjectUtils.toString(searchMap.get("type"), ""))){
            criteria.andTypevalEqualTo(searchMap.get("type").toString());
        }
        if(keywords != null && keywords != "" &&  !"请输入查询政策名称".equals(keywords)){
            criteria.andTitleLike("%" + keywords + "%");
        }
        slectExample.setOrderByClause(" create_time desc, typeVal asc");
        Page<TbPolicyDocument> page = (Page<TbPolicyDocument>) tbPolicyDocumentMapper.selectByExample(slectExample);
        map.put("rows",page.getResult());
        map.put("totalPages", page.getPages());
        map.put("total",page.getTotal());
        return map;
    }


    @Override
    public int updateByExampleSelective(Map pData){
        TbPolicyDocument record = new TbPolicyDocument();
        record.setContent(pData.get("content").toString().getBytes());
        TbPolicyDocumentExample slectExample = new TbPolicyDocumentExample();
        slectExample.createCriteria().andTitleEqualTo(pData.get("title").toString());
        int returnResult = tbPolicyDocumentMapper.updateByExampleSelective(record, slectExample);
        return returnResult;
    }

    @Override
    public Map<String,Object> selectByPrimaryKey(Map pData){
        Map<String,Object> map = new HashMap<>();
        if(pData.get("id") != "undefined" && pData.get("id") != null && StringUtils.isNotBlank(ObjectUtils.toString(pData.get("id"), ""))  ){
            TbPolicyDocument model = tbPolicyDocumentMapper.selectByPrimaryKey(Integer.parseInt(pData.get("id").toString()));
            if(model != null){
                if(model.getContent() != null){
                    map.put("content",new String(model.getContent()));
                }
            }
            map.put("createTime", model.getCreateTime());
            map.put("typeVal",model.getTypeval());
            map.put("title",model.getTitle());
            map.put("id",model.getId());
        }
        return map;
    }

    @Override
    public int saveOrupdate(Map contentMap){
        int returnResult = 0;
       TbPolicyDocument record = new TbPolicyDocument();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(contentMap.get("id") != "undefined" && contentMap.get("id") != null && StringUtils.isNotBlank(ObjectUtils.toString(contentMap.get("id"), ""))  ){
                record.setCreateTime(sdf.parse(contentMap.get("createTime").toString()));
                record.setContent(contentMap.get("content").toString().getBytes());
                record.setId(Integer.parseInt(contentMap.get("id").toString()));
                record.setIsdelete(0);
                record.setTitle(contentMap.get("title").toString());
                record.setTypeval(contentMap.get("typeVal").toString());
                returnResult = tbPolicyDocumentMapper.updateByPrimaryKeySelective(record);
            }else{
                record.setCreateTime(sdf.parse(contentMap.get("createTime").toString()));
                record.setContent(contentMap.get("content").toString().getBytes());
                record.setIsdelete(0);
                record.setTitle(contentMap.get("title").toString());
                record.setTypeval(contentMap.get("typeVal").toString());
                returnResult = tbPolicyDocumentMapper.insertSelective(record);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnResult;
    }

    //批量删除
    @Override
    public int deleteByExample(List idList){
        int len = idList.size();
        int returnResult = 0;
        for(int i=0;i<len;i++){
            String id = idList.get(i).toString();
            returnResult = tbPolicyDocumentMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
        return returnResult;
    }
}
