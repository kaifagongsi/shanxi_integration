package com.kfgs.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.kfgs.admin.service.AdminProductService;
import com.kfgs.domain.TbProduct;
import com.kfgs.domain.response.QueryResponseResult;
import com.kfgs.mapper.TbProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Date: 2020-04-22-21-36
 * Module:
 * Description:
 *
 * @author:
 */
public class AdminProductImpl implements AdminProductService {

    @Autowired
    TbProductMapper tbProductMapper;

    @Override
    public QueryResponseResult adminProductListLoad(Map map) {
        PageHelper.startPage(Integer.parseInt(map.get("pageNo").toString()),Integer.parseInt(map.get("pageSize").toString()));
        List<TbProduct> productList  = tbProductMapper.selectProductIdAndNameAndAdminAreaAndProductClassificationAndApprovalAnnouncementNoProductAndProtectionNotice();
        return null;
    }
}
