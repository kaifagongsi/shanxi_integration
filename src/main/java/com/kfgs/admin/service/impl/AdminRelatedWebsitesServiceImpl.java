package com.kfgs.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.admin.service.AdminRelatedWebsitesService;
import com.kfgs.domain.TbProduct;
import com.kfgs.domain.TbRelatedWebsites;
import com.kfgs.domain.ext.TbRelatedWebsitesExt;
import com.kfgs.domain.response.CommonCode;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.domain.response.QueryResult;
import com.kfgs.mapper.TbProductMapper;
import com.kfgs.mapper.TbRelatedWebsitesMapper;
import com.kfgs.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Date: 2020-05-08-17-09
 * Module:
 * Description:
 *
 * @author:
 */
@Service
public class AdminRelatedWebsitesServiceImpl implements AdminRelatedWebsitesService {

    @Autowired
    TbRelatedWebsitesMapper tbRelatedWebsitesMapper;

    @Autowired
    TbProductMapper tbProductMapper;


    @Override
    public QueryResponseResult saveRelatedModel(TbRelatedWebsitesExt tbRelatedWebsitesExt) {
        System.out.println(tbRelatedWebsitesExt);

        if(tbRelatedWebsitesExt.getId() == null || tbRelatedWebsitesExt.getId() == 0){
            //表示新增相关企业或者网站
            if("1".equals(tbRelatedWebsitesExt.getType())){
                tbRelatedWebsitesExt.setType("相关企业");
            }else if("2".equals(tbRelatedWebsitesExt.getType())){
                tbRelatedWebsitesExt.setType("相关网站");
            }
            int insertNum = tbRelatedWebsitesMapper.insertTbRelatedWebsitesExt(tbRelatedWebsitesExt);
            if(1 == insertNum){
                return new QueryResponseResult(CommonCode.SUCCESS,null);
            }else{
                return new QueryResponseResult(CommonCode.FAIL,null);
            }
        }else{
            //表示编辑相关企业或者网站
            return null;
        }
    }

    @Override
    public QueryResponseResult getRelatedWebsitesList(Map map) {
        Map<String,Object> resultMap = new HashMap<>();
        PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),Integer.parseInt(map.get("pageSize").toString()));
        Page<TbRelatedWebsitesExt> page = (Page<TbRelatedWebsitesExt>) tbRelatedWebsitesMapper.getRelatedWebsitesList();
        resultMap.put("rows",page.getResult());
        resultMap.put("totalPages", page.getPages());
        resultMap.put("total",page.getTotal());
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        return queryResponseResult;
    }

    @Override
    public QueryResponseResult saveImg(MultipartFile file, HttpServletRequest request) {

        Map resultMap = new HashMap();
        System.out.println(file);
        //保存路径
        String path= request.getSession().getServletContext().getRealPath("/")+"static\\relatedWebsites\\";
        System.out.println(path);
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") );
        String fileName = UUIDUtils.generateUuid8() + suffix;
        File targetImg = new File(path + fileName);
        try{
            if(targetImg.exists()){
                targetImg.delete();
                System.out.println("原图片已删除");
            }
            FileOutputStream outputStream = new FileOutputStream(path+fileName);
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
            String imgPath = path+fileName;
            resultMap.put("picUrl","../../static/relatedWebsites/" + fileName);
            QueryResult queryResult = new QueryResult();
            queryResult.setMap(resultMap);
            return  new QueryResponseResult(CommonCode.SUCCESS,queryResult);
        }catch (IllegalStateException e) {
            e.printStackTrace();
            return  new QueryResponseResult(CommonCode.FAIL,null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return  new QueryResponseResult(CommonCode.FAIL,null);
        } catch (IOException e) {
            e.printStackTrace();
            return  new QueryResponseResult(CommonCode.FAIL,null);
        }
    }


    @Override
    public QueryResponseResult selectById(String id) {
        TbRelatedWebsites tbRelatedWebsites = tbRelatedWebsitesMapper.selectByPrimaryKey(Integer.parseInt(id));
        QueryResult queryResult = new QueryResult();
        Map resultMap = new HashMap();
        resultMap.put("relatedWebsites",tbRelatedWebsites);
        queryResult.setMap(resultMap);
        return  new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult loadProductRelatedWebsites() {
        Map resultMap = new HashMap();
        //产品列表
        List<TbProduct> productList = tbProductMapper.selectByIdAndNameReturnList();
        resultMap.put("productList",productList);
        //相关企业
        List<TbRelatedWebsites> relatedententerpriseList =  tbRelatedWebsitesMapper.selectByType("相关企业");
        resultMap.put("enterpriseList",relatedententerpriseList);
        //相关网站
        List<TbRelatedWebsites> relatedWebsitesList =  tbRelatedWebsitesMapper.selectByType("相关网站");
        resultMap.put("websitesList",relatedWebsitesList);
        QueryResult queryResult = new QueryResult();
        queryResult.setMap(resultMap);
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

    @Override
    public QueryResponseResult saveProductAboutEntAndWeb(TbRelatedWebsitesExt tbRelatedWebsitesExt) {
        System.out.println(tbRelatedWebsitesExt);
        List<TbRelatedWebsites> relatedententerpriseList = tbRelatedWebsitesMapper.selectById(tbRelatedWebsitesExt.getEnt());
        List<TbRelatedWebsites> relatedentWebsitesList = tbRelatedWebsitesMapper.selectById(tbRelatedWebsitesExt.getWeb());

        for(TbRelatedWebsites relatedententerprise : relatedententerpriseList){
            relatedententerprise.setProductId(tbRelatedWebsitesExt.getProductId());
        }

        for(TbRelatedWebsites relatedentWebsites : relatedentWebsitesList){
            relatedentWebsites.setProductId(tbRelatedWebsitesExt.getProductId());
        }
        int entNum = tbRelatedWebsitesMapper.insertProductAboutEntAndWeb(relatedententerpriseList);
        int webNum = tbRelatedWebsitesMapper.insertProductAboutEntAndWeb(relatedentWebsitesList);
        if(entNum == relatedententerpriseList.size() && webNum == relatedentWebsitesList.size() ){
            return new QueryResponseResult(CommonCode.SUCCESS,null);
        }else{
            return new QueryResponseResult(CommonCode.FAIL,null);
        }
    }
}
