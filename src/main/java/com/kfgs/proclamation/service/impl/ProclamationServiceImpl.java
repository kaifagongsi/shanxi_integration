package com.kfgs.proclamation.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.TbProtectionNotice;
import com.kfgs.domain.TbProtectionNoticeExample;
import com.kfgs.mapper.TbProtectionNoticeMapper;
import com.kfgs.proclamation.service.ProclamtionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        slectExample.createCriteria().andIsdeleteEqualTo(0).andTypevalEqualTo(searchMap.get("type").toString());
        slectExample.setOrderByClause(" create_time desc");
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
        TbProtectionNotice model = tbProtectionNoticeMapper.selectByPrimaryKey(Integer.parseInt(pData.get("id").toString()));
        //System.out.println("=============" +  new String(model.getContent()));
        if(model.getContent() == null){
            map.put("content",new String("暂无数据"));
        }else if(StringUtils.isNotBlank(model.getContent().toString())){
            map.put("content",new String(model.getContent()));
        }else{
            map.put("content",new String("暂无数据"));
        }

        return map;
    }

}
