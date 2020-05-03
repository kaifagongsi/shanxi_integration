package com.kfgs.admin.service;

import com.kfgs.domain.response.QueryResponseResult;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface AdminAreaService {

    public QueryResponseResult findParent();

    /**
     * 根据父类ID 获取子类分类
     * @param parentId
     * @return
     */
    public QueryResponseResult findListByParentId(String parentId);

    //查找树形结构数据
    public String findTree();
}
