package com.kfgs.admin.service;

import com.kfgs.domain.response.QueryResponseResult;

import java.util.Map;

/**
 * Date: 2020-05-08-17-08
 * Module:
 * Description:
 *
 * @author:
 */
public interface AdminRelatedWebsitesService {

    QueryResponseResult getRelatedWebsitesList(Map map);
}
