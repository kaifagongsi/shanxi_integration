package com.kfgs.policypapers.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.TbPolicyDocument;
import com.kfgs.domain.TbPolicyDocumentExample;
import com.kfgs.mapper.TbPolicyDocumentMapper;
import com.kfgs.policypapers.service.policypapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        slectExample.createCriteria().andIsdeleteEqualTo(0).andTypevalEqualTo(searchMap.get("type").toString());
        slectExample.setOrderByClause(" create_time desc");
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
        TbPolicyDocument model = tbPolicyDocumentMapper.selectByPrimaryKey(Integer.parseInt(pData.get("id").toString()));
        if(model != null){
            if(model.getContent() != null){
//                System.out.println("=============" +  new String(model.getContent()));
                map.put("content",new String(model.getContent()));
            }
        }
        return map;
    }

}
