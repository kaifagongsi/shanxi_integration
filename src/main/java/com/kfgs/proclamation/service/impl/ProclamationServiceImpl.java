package com.kfgs.proclamation.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.TbPolicyDocument;
import com.kfgs.domain.TbPolicyDocumentExample;
import com.kfgs.domain.TbProtectionNotice;
import com.kfgs.domain.TbProtectionNoticeExample;
import com.kfgs.mapper.TbProtectionNoticeMapper;
import com.kfgs.proclamation.service.ProclamtionService;
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
public class ProclamationServiceImpl implements ProclamtionService {


    @Override
    public String text() {
        return "1111";
    }


    @Autowired
    TbProtectionNoticeMapper tbProtectionNoticeMapper;

    //查找各类公告数据
    @Override
    public Map<String,List<TbProtectionNotice>> getList() {
        Map<String,List<TbProtectionNotice>> map = new HashMap<String,List<TbProtectionNotice>>();
        TbProtectionNoticeExample slectExample = new TbProtectionNoticeExample();
        slectExample.createCriteria().andIsdeleteEqualTo(0);
        List<TbProtectionNotice> tbProtectionNotices = tbProtectionNoticeMapper.selectByExample(slectExample);
        if(tbProtectionNotices != null && tbProtectionNotices.size() > 0){
                for(TbProtectionNotice tmp : tbProtectionNotices){
                    if(map.containsKey(tmp.getTypeval())){
                        List<TbProtectionNotice> list = map.get(tmp.getTypeval());
                        list.add(tmp);
                        map.put(tmp.getTypeval(),list);
                    }else{
                        List<TbProtectionNotice> list = new ArrayList<TbProtectionNotice>();
                        list.add(tmp);
                        map.put(tmp.getTypeval(),list);
                    }
                }
        }
        return map;
    }


    @Override
    public List<TbProtectionNotice> getList(int page) {
        PageHelper.startPage(page,20);
        List<TbProtectionNotice> list = tbProtectionNoticeMapper.selectAll();
        return list;
    }

    @Override
    public Map<String,Object> search(Map searchMap){
        //返回页面结果集
        Map<String,Object> map = new HashMap<>();
        //按照公告类型，提供数据
        Map<String,List<TbProtectionNotice>> typeMap = new HashMap<String,List<TbProtectionNotice>>();

        TbProtectionNoticeExample slectExample = new TbProtectionNoticeExample();
        TbProtectionNoticeExample.Criteria criteria = slectExample.createCriteria();
        criteria.andIsdeleteEqualTo(0);
        slectExample.setOrderByClause(" notice_time desc");
        List<TbProtectionNotice> tbProtectionNotices = tbProtectionNoticeMapper.selectByExample(slectExample);
        if(tbProtectionNotices != null && tbProtectionNotices.size() > 0){
            for(TbProtectionNotice tmp : tbProtectionNotices){
                List<TbProtectionNotice> list = new ArrayList<TbProtectionNotice>();
                if(typeMap.containsKey(tmp.getTypeval())){
                    list = typeMap.get(tmp.getTypeval());
                }
                list.add(tmp);
                typeMap.put(tmp.getTypeval(),list);
            }
        }

        map.put("rows",typeMap);
        return  map;
    }


    @Override
    public Map<String,Object> getList(Map searchMap) {
        PageHelper.startPage(Integer.parseInt(searchMap.get("pageNo").toString()),15);
        //返回页面结果集
        Map<String,Object> map = new HashMap<>();
        TbProtectionNoticeExample slectExample = new TbProtectionNoticeExample();
        TbProtectionNoticeExample.Criteria criteria = slectExample.createCriteria();
        criteria.andIsdeleteEqualTo(0);
        //查询关键字
        String keywords = searchMap.get("keywords").toString();
        if(StringUtils.isNotBlank(ObjectUtils.toString(searchMap.get("type"), ""))){
            criteria.andTypevalEqualTo(searchMap.get("type").toString());
        }
        if(keywords != null && keywords != "" &&  !"请输入查询公告名称".equals(keywords)){
            criteria.andTitleLike("%" + keywords + "%");
        }
        slectExample.setOrderByClause(" notice_time desc, typeVal asc");
        Page<TbProtectionNotice> page = (Page<TbProtectionNotice>) tbProtectionNoticeMapper.selectByExample(slectExample);

        map.put("rows",page.getResult());
        map.put("totalPages", page.getPages());
        map.put("total",page.getTotal());
        return map;
    }

    @Override
    public int updateByExampleSelective(Map pData){
        TbProtectionNotice record = new TbProtectionNotice();
        record.setContent(pData.get("content").toString().getBytes());
        TbProtectionNoticeExample slectExample = new TbProtectionNoticeExample();
        slectExample.createCriteria().andTitleEqualTo(pData.get("title").toString());
        int returnResult = tbProtectionNoticeMapper.updateByExampleSelective(record, slectExample);
        return returnResult;
    }

    @Override
    public Map<String,Object> selectByPrimaryKey(Map pData){
        Map<String,Object> map = new HashMap<>();
        if(pData.get("id") != "undefined" && pData.get("id") != null && StringUtils.isNotBlank(ObjectUtils.toString(pData.get("id"), ""))  ){
            TbProtectionNotice model = tbProtectionNoticeMapper.selectByPrimaryKey(Integer.parseInt(pData.get("id").toString()));
            if(model != null && model.getContent() == null){
                map.put("content",new String("暂无数据"));
            }else if(StringUtils.isNotBlank(model.getContent().toString())){
                map.put("content",new String(model.getContent()));
                map.put("noticeTime", model.getNoticeTime());
                map.put("typeVal",model.getTypeval());
                map.put("title",model.getTitle());
                map.put("id",model.getId());
            }else{
                map.put("content",new String("暂无数据"));
            }
        }
        return map;
    }


    @Override
    public int saveOrupdate(Map contentMap){
        int returnResult = 0;
        TbProtectionNotice record = new TbProtectionNotice();
        if(contentMap.get("id") != "undefined" && contentMap.get("id") != null && StringUtils.isNotBlank(ObjectUtils.toString(contentMap.get("id"), ""))  ){
            record.setNoticeTime(contentMap.get("noticeTime").toString());
            record.setContent(contentMap.get("content").toString().getBytes());
            record.setId(Integer.parseInt(contentMap.get("id").toString()));
            record.setIsdelete(0);
            record.setTitle(contentMap.get("title").toString());
            record.setTypeval(contentMap.get("typeVal").toString());
            returnResult = tbProtectionNoticeMapper.updateByPrimaryKeySelective(record);
        }else{
            record.setNoticeTime(contentMap.get("noticeTime").toString());
            record.setContent(contentMap.get("content").toString().getBytes());
            record.setIsdelete(0);
            record.setTitle(contentMap.get("title").toString());
            record.setTypeval(contentMap.get("typeVal").toString());
            returnResult = tbProtectionNoticeMapper.insertSelective(record);
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
            returnResult = tbProtectionNoticeMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
        return returnResult;
    }


}
