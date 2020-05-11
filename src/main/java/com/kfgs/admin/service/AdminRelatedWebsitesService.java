package com.kfgs.admin.service;

import com.kfgs.domain.ext.TbRelatedWebsitesExt;
import com.kfgs.domain.response.QueryResponseResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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

    QueryResponseResult saveImg(MultipartFile file, HttpServletRequest request);

    QueryResponseResult saveRelatedModel(TbRelatedWebsitesExt tbRelatedWebsitesExt);

    QueryResponseResult selectById(String id);

    QueryResponseResult loadProductRelatedWebsites();


    QueryResponseResult saveProductAboutEntAndWeb(TbRelatedWebsitesExt tbRelatedWebsitesExt);

    QueryResponseResult deleteRelatedWebsites(String id);

    QueryResponseResult loadRelatedWebsitesList(Map map);


    QueryResponseResult getProductRelatedWebsitesRellevance(String id);

    QueryResponseResult deleteProductRelatedWebsitesRelevance(String id);
}
