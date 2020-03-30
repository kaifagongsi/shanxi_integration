package com.kfgs.statistics.service;

import com.kfgs.domain.TbAdministrativeArea;
import com.kfgs.domain.response.QueryResponseResult;

import java.util.List;

/**
 * 服务层地理位置（省市县）接口
 */
public interface AdministrativeAreaService {
    /**
     * 返回 全部列表
     * @return
     */
    public QueryResponseResult findAll();

    /**
     * 根据父类ID 获取子类分类
     * @param parentId
     * @return
     */
    public QueryResponseResult findListByParentId(String parentId);

    /**
     * 获取所有包含path的地区
     * @param path
     * @return
     */
    public  List<TbAdministrativeArea> findListLikePath(String path);



}
