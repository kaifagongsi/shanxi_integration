package com.kfgs.firstweb.service.impl;

import com.kfgs.domain.TbClassficationCountry;
import com.kfgs.domain.TbClassficationCountryExample;
import com.kfgs.firstweb.service.CountryProShowService;
import com.kfgs.mapper.TbClassficationCountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CountryProShowServiceImpl implements CountryProShowService {

    @Autowired
    TbClassficationCountryMapper tbClassficationCountryMapper;

    @Override
    public Map<String,Object> search(){

        return  getType();
    }

    private Map getType() {
        List listId = new ArrayList();
        List nameList = new ArrayList();
        //返回页面结果集
        Map<String,Object> map = new HashMap<>();
        //按照类别提供数据集
        Map<String,List<TbClassficationCountry>> typeMap = new HashMap<String,List<TbClassficationCountry>>();

        TbClassficationCountryExample tbClassificationExample = new TbClassficationCountryExample();
        tbClassificationExample.createCriteria().andIsdeleteEqualTo(0);
        List<TbClassficationCountry> list = tbClassficationCountryMapper.selectByExample(tbClassificationExample);

        if (list != null && list.size()>0){
            for(TbClassficationCountry temp:list){
                //判断父节点创建类别Map
                if(temp.getRootid().equals("1") || temp.getRootid() == "1"){
                    List<TbClassficationCountry> list_father = new ArrayList<>();
                    String idAndName = temp.getClassificationid().concat(temp.getName());
                    //typeMap.put(idAndName,list_father);
                    typeMap.put(temp.getClassificationid(),list_father);
                }
            }
            for(TbClassficationCountry son:list){
                //创建子节点
                if (son.getRootid().equals("2")){
                    List<TbClassficationCountry> list_son = new ArrayList<>();
                    if(typeMap.containsKey(son.getParentid())){
                        list_son = typeMap.get(son.getParentid());
                        list_son.add(son);
                    }
                }
            }
        }

        //新建map
        Map<String,List<TbClassficationCountry>> newtypeMap = new HashMap<String,List<TbClassficationCountry>>();
        //List<Map<String,List<TbClassification>>> newtypeList= new ArrayList<>();
        Iterator it = typeMap.keySet().iterator();
        while (it.hasNext()){
            // Map<String,List<TbClassification>> newtypeMap = new HashMap<String,List<TbClassification>>();
            //取出key
            String key = it.next().toString();
            String id = "";
            String name="";
            String idAndName="";
            System.out.println(key);
            //取出value
            List<TbClassficationCountry> newlist = new ArrayList<>();
            newlist = typeMap.get(key);

            //根据key（id）获取name
            TbClassficationCountryExample tbClassificationExample1 = new TbClassficationCountryExample();
            tbClassificationExample1.createCriteria().andClassificationidEqualTo(key);
            List<TbClassficationCountry> list1 = tbClassficationCountryMapper.selectByExample(tbClassificationExample1);
            for(TbClassficationCountry fa:list1){
                id = fa.getClassificationid();
                name = fa.getName();
                idAndName = id.concat(name);
                /*nameList.add(name);
                listId.add(fa.getClassificationid());*/
            }
            newtypeMap.put(idAndName,newlist);
            //newtypeList.add(newtypeMap);
        }
        //map.put("type",typeMap);
        map.put("type",newtypeMap);
        /*map.put("list",listId);
        map.put("listName",nameList);*/
        return map;
    }

}
