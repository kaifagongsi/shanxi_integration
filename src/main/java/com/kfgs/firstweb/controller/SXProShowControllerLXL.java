package com.kfgs.firstweb.controller;

import com.kfgs.firstweb.service.CountryProShowService;
import com.kfgs.firstweb.service.SXProShowService;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2019-12-26-13-02
 * Module:
 * Description:
 *
 * @author: LXL
 */
@Controller
@RequestMapping("lxlController")
public class SXProShowControllerLXL {
    @Autowired
    SXProShowService sxProShowService;
    @Autowired
    CountryProShowService countryProShowService;



    @RequestMapping("textIndexProPreview")
    public void previewIndexPro(HttpServletRequest req, HttpServletResponse response){

        //0.定义html
        String pageHtml = "";
        //接收参数
        String type = req.getParameter("type");
        Map map = new HashMap();
        if (type.equals("1")){//陕西
            Map<String, Object> body = sxProShowService.search();
            map.put("tongji",body.get("type"));
            map.put("123456","456789456");
        }else if (type.equals("2")){//国内
            Map<String, Object> body1 = countryProShowService.search();

            map.put("tongjiguonei",body1.get("type"));
            map.put("123456","456789456");
        }
        //1.模型获取数据：
        /*Map<String, Object> body = sxProShowService.search();
        Map map = new HashMap();
        map.put("tongji",body.get("type"));
        map.put("123456","456789456");*/
        //2.获取模板
        Template template = null;
        try {
            template = getTemplate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("加载静态模板异常");
        }
        //3.绑定数据
        if(template != null){
            pageHtml =  generateHtml(template,map);
        }
        if(StringUtils.isNotEmpty(pageHtml)){

            try {
                ServletOutputStream outputStream = response.getOutputStream();
                response.setContentType("text/html;charset=utf‐8");
                // response.setHeader("Content-type","text/html;charset=utf‐8");
                outputStream.write(pageHtml.getBytes("utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String generateHtml(Template template, Map<String, Object> map) {
        try {

            //生成配置类
            Configuration configuration = new Configuration(Configuration.getVersion());
            //模板加载器
            StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
            stringTemplateLoader.putTemplate("template",template.toString());
            //配置模板加载器
            configuration.setTemplateLoader(stringTemplateLoader);

            //获取模板
            Template template1 = configuration.getTemplate("template");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template1,  map);
            return html;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Template getTemplate() throws Exception {
        //创建配置类
        Configuration configuration=new Configuration(Configuration.getVersion());
        //设置模板路径
        String classpath = this.getClass().getResource("/").getPath();
        configuration.setDirectoryForTemplateLoading(new File(classpath + "/templates/"));
        //设置字符集
        configuration.setDefaultEncoding("utf8");
        //加载模板
        Template template = configuration.getTemplate("show.ftl");
        return  template;
    }
}
