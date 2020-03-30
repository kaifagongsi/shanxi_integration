package com.kfgs.firstweb.controller;

import com.kfgs.domain.ext.FormDate;
import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* *
 * 功能描述:
 * 〈〉
 *
 * @param null 1
 * @return : 模拟访问，获取session
 * @author : mango
 * @date : 2020/2/15 15:03
 */
@Controller
@RequestMapping("/Simulation")
public class SimulationWebController {

    @ResponseBody
    @GetMapping("/getCookie")
    public Map getCookie(HttpServletRequest servletRequestrequest) throws IOException {
        String userAgent = servletRequestrequest.getHeader("User-Agent");
        System.out.println(userAgent);
        Map result = new HashMap();
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://www.patviewer.com/")
                .addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .addHeader("Accept-Encoding","gzip, deflate")
                .addHeader("Accept-Language:","zh-CN,zh;q=0.9")
                .addHeader("Connection","keep-alive")
                .addHeader("Host","www.patviewer.com")
                .addHeader("Upgrade-Insecure-Requests","1")
                .addHeader("User-Agent",userAgent)
                .build();
        okhttp3.Call call = client.newCall(request);
        // 执行GET请求，并在异步回调中处理请求
        Response response = call.execute();
        Headers headers = response.headers();
        List<String> jsessionid = headers.values("Set-Cookie");
        System.out.println(jsessionid);
        //截取JSESSIONID
        String setCookie = jsessionid.get(0);
        String jession = setCookie.substring(setCookie.indexOf("=") + 1 , setCookie.indexOf(";"));
        System.out.println(response);
        result.put("session",jession);
        return result;
    }

    @PostMapping("/getResponseBody")
    public void getResponseBody(HttpServletRequest req, HttpServletResponse resp, String surl, String pageType, String quickSearchEncode, @RequestBody FormDate formDate) throws IOException {
        //1.获取session
        String userAgent = req.getHeader("User-Agent");
        OkHttpClient clientSession=new OkHttpClient();
        Request requestSession = new Request.Builder()
                //.url("http://www.patviewer.com")
                .url(surl+"&pageType="+pageType + "&quickSearchEncode="+quickSearchEncode)
                .addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .addHeader("Accept-Language:","zh-CN,zh;q=0.9")
                .addHeader("Connection","keep-alive")
                .addHeader("Host","www.patviewer.com")
                .addHeader("User-Agent",userAgent)
                .build();
        okhttp3.Call callSession = clientSession.newCall(requestSession);
        // 执行GET请求，并在异步回调中处理请求
        Response responseSession = callSession.execute();
        Headers headers = responseSession.headers();
        List<String> jsessionid = headers.values("Set-Cookie");
        String setCookie = jsessionid.get(0);
        String jession = setCookie.substring(setCookie.indexOf("=") + 1 , setCookie.indexOf(";"));


       /* String formDateJson = JSON.toJSONString(formDate);
        System.out.println(formDateJson);*/
        //请求body
        /*okhttp3.RequestBody body;
        body = okhttp3.RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), formDateJson);*/
        okhttp3.RequestBody body =new FormBody.Builder()
                .addEncoded("content1",formDate.getContent1())
                .addEncoded("colname",formDate.getColname())
                .addEncoded("strWhere",formDate.getStrWhere())
                .addEncoded("simpleSearch",formDate.getSimpleSearch())
                .addEncoded("presearchword",formDate.getPresearchword())
                .addEncoded("savesearchword",formDate.getSavesearchword())
                .addEncoded("strChannels",formDate.getStrChannels())
                .addEncoded("strSources",formDate.getStrSources())
                .addEncoded("strSortMethod",formDate.getStrSortMethod())
                .addEncoded("strDefautCols",formDate.getStrDefautCols())
                .addEncoded("strStat",formDate.getStrStat())
                .addEncoded("iHitPointType",formDate.getIHitPointType())
                .addEncoded("searchKind",formDate.getSearchKind())
                .addEncoded("bContinue",formDate.getBContinue())
                .addEncoded("trsLastWhere",formDate.getTrsLastWhere())
                .addEncoded("channelid",formDate.getChannelid())
                .addEncoded("content",formDate.getContent())
                .build();

        System.out.println(body);
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder()
                .url(surl+"&pageType="+pageType + "&quickSearchEncode="+quickSearchEncode)
//                .addHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
//                .addHeader("Connection","keep-alive")
//                .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
//                .addHeader("Host","www.patviewer.com")
                .addHeader("User-Agent",userAgent)
//                .addHeader("Host","www.patviewer.com")
//                .addHeader("Origin","http://www.patviewer.com")
//                .addHeader("Referer","http://www.patviewer.com/")
                //.addHeader("Cookie","JSESSIONID="+req.getRequestedSessionId().replaceAll("%22",""))
                .addHeader("Cookie","JSESSIONID="+jession)
                .post( body)
                .build();

        okhttp3.Call call = client.newCall(request);
        // 执行GET请求，并在异步回调中处理请求
        Response response = call.execute();
        System.out.println("body :" + response.body().string());
        System.out.println("code:" + response.code());
        System.out.println("message:" + response.message());
        ServletOutputStream outputStream = resp.getOutputStream();
        resp.setContentType("text/html;charset=utf‐8");
        // response.setHeader("Content-type","text/html;charset=utf‐8");
        //outputStream.write(response.getBytes("utf-8"));
        String string = response.body().string();
        outputStream.write(string.getBytes("utf-8"));
    }
}
