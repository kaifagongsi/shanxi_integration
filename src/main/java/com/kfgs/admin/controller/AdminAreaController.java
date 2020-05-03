package com.kfgs.admin.controller;

import com.kfgs.admin.service.AdminAreaService;
import com.kfgs.domain.TbAdministrativeArea;
import com.kfgs.domain.response.QueryResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("admin")
public class AdminAreaController {
    @Autowired
    AdminAreaService adminAreaService;

    @RequestMapping(value="findTree",method = RequestMethod.POST)
    @ResponseBody
    public String findTree(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        return adminAreaService.findTree();
    }
}
