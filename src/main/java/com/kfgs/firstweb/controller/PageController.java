package com.kfgs.firstweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"page"})
public class PageController {

    @RequestMapping({"index"})
    public String index()
    {
        return "index";
    }

    @RequestMapping({"sydbqy"})
    public String sydbqy()
    {
        return "sydbqy";
    }

    @RequestMapping({"dbcpzs"})
    public String dbqyzs(){return "dbcpzs";};

    @RequestMapping({"dbcpzs_country"})
    public String dbcpzs_country(){return "dbcpzs_country";}

    @RequestMapping("dbcpzs_shanxi")
    public String  dbcpzs_shanxi(){return "dbcpzs_shanxi";}

    @RequestMapping("uploadFile")
    public String uploadFile(){return "uploadFile";}

    @RequestMapping("detail")
    public String detail(){
        return "detail";
    }

    @RequestMapping("complain")
    public String complain(){ return "complain"; }

    @RequestMapping("static")
    public  String statics(){ return "/WEB-INF/static.html";}

}
