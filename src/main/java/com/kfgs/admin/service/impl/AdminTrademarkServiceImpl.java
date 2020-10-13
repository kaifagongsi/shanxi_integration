package com.kfgs.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.admin.service.AdminTrademarkService;
import com.kfgs.domain.TbGeographicalIndicationTrademark;
import com.kfgs.domain.TbGeographicalIndicationTrademarkExample;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.domain.response.ResultCode;
import com.kfgs.mapper.TbGeographicalIndicationTrademarkMapper;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminTrademarkServiceImpl implements AdminTrademarkService {

    @Autowired
    TbGeographicalIndicationTrademarkMapper trademarkMapper;
    @Override
    public QueryResponseResult getList(Map searchMmap) {
        HashMap resultMap = new HashMap();
        PageHelper.startPage(Integer.parseInt(searchMmap.get("pageNo").toString()),Integer.parseInt(searchMmap.get("pageSize").toString()));
        Page<TbGeographicalIndicationTrademark> trademarkPage = (Page<TbGeographicalIndicationTrademark>)trademarkMapper.selectByExample(null);
        resultMap.put("rows",trademarkPage.getResult());
        resultMap.put("totalPages", trademarkPage.getPages());
        resultMap.put("total",trademarkPage.getTotal());
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult selectOne(String id) {
        TbGeographicalIndicationTrademarkExample example = new TbGeographicalIndicationTrademarkExample();
        example.createCriteria().andRegistrationNumberEqualTo(id);
        List<TbGeographicalIndicationTrademark> list = trademarkMapper.selectByExample(example);
        if(list != null && list.size() != 1){
            return new QueryResponseResult(CommonCode.FAIL,null);
        }else{
            HashMap map = new HashMap();
            map.put("item",list.get(0));
            QueryResult queryResult = new QueryResult();
            queryResult.setMap(map);
            return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        }
    }

    @Override
    @Transactional
    public QueryResponseResult saveTrademark(MultipartFile file, TbGeographicalIndicationTrademark trademark, HttpServletRequest httpRequest) {
        //1.检查实体是否存在
        TbGeographicalIndicationTrademarkExample example = new TbGeographicalIndicationTrademarkExample();
        example.createCriteria().andRegistrationNumberEqualTo(trademark.getRegistrationNumber());
        List<TbGeographicalIndicationTrademark> list = trademarkMapper.selectByExample(example);

        if(list.size() == 0){//表示为新增
            if(file != null){ //判断有无文件上传
                //修改文件路径
                trademark.setPdfPath(file.getOriginalFilename());
                return insertTrademark(file,trademark,httpRequest,true);
            }else{
                return insertTrademark(file,trademark,httpRequest,false);
            }
        }else if(list.size() == 1){//标识为更新，并且数据正常

            int delete = trademarkMapper.deleteByExample(example);
            if(delete == 1){
                //判断文件是否需要重新上次
                if(file == null){ // 仅仅上传实体
                    return insertTrademark(file,trademark,httpRequest,false);
                }else{
                    //修改文件路径
                    trademark.setPdfPath(file.getOriginalFilename());
                    return insertTrademark(file,trademark,httpRequest,true);
                }
                /*boolean flag = false;
                if(list.get(0).getPdfPath().equals(file.getOriginalFilename())){//比较数据库中的名字是否与传入文件的名字一直
                    flag = false;
                }else{ // 文件需要重新写入
                    flag = true;
                    //修改文件路径
                    trademark.setPdfPath(file.getOriginalFilename());
                }
                return insertTrademark(file,trademark,httpRequest,flag);*/
            }else{
                int c = 8/0;
                return new QueryResponseResult(CommonCode.DELETE_ERROR_DATE, null);
            }
        }else{
            //不可更新，数据有问题
            return new QueryResponseResult(CommonCode.SELECT_ERROR_DATE,null);
        }
    }

    @Override
    public QueryResponseResult deleteTrademark(String id) {
        TbGeographicalIndicationTrademarkExample example = new TbGeographicalIndicationTrademarkExample();
        example.createCriteria().andRegistrationNumberEqualTo(id);
        int delete = trademarkMapper.deleteByExample(example);
        if(delete == 1){
            return  new QueryResponseResult(CommonCode.SUCCESS,null);
        }else{
            return  new QueryResponseResult(CommonCode.FAIL,null);
        }
    }


    private QueryResponseResult insertTrademark(MultipartFile file, TbGeographicalIndicationTrademark trademark, HttpServletRequest httpRequest, Boolean flagFileCover){
        int insert = trademarkMapper.insert(trademark);
        if(insert ==1 ){ //插入成功
            if(flagFileCover){ //
                //插入成功，开始复制文件
                //System.getProperty("user.dir")
                //String str_path = System.getProperty("user.dir");
                //System.out.println(str_path);
                //1.获取路径
                String index = httpRequest.getSession().getServletContext().getRealPath("/")+"static/trademark/pdf/" + file.getOriginalFilename();
                System.out.println(index);
                File tar  = new File(index);
                try {
                    //2.复制文件
                    FileUtils.copyInputStreamToFile(file.getInputStream(),tar);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return new QueryResponseResult(CommonCode.SUCCESS,null);
        }else {
            //更新不成功，提示错误
            try{
                int c = 8/0;
            }catch (Exception e){

            }finally {
                return new QueryResponseResult(CommonCode.INSERT_ERROR,null);
            }
        }
    }
}
