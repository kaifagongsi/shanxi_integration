package com.kfgs.firstweb.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kfgs.domain.TbEnterprise;
import com.kfgs.domain.TbEnterpriseExample;
import com.kfgs.domain.TbProduct;
import com.kfgs.domain.TbProductExample;
import com.kfgs.domain.ext.TbEnterpriseExt;
import com.kfgs.firstweb.service.SydbqyService;
import com.kfgs.mapper.TbEnterpriseMapper;
import com.kfgs.mapper.TbProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SydbqyServiceImpl implements SydbqyService {

    @Autowired
    TbEnterpriseMapper tbEnterpriseMapper;
    @Autowired
    TbProductMapper tbProductMapper;

    @Override
    public String text() {
        String str = "<!doctype html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>地标产品展示 - 中国▪陕西地理标志保护产品</title>\n" +
                "    <meta content=\"陕西地理标志保护产品,陕西地理标志保护产品,产品,地理,保护,标志,地理标志,地理标志保护,地理标志保护产品,茶,酒,果蔬,养殖,中药材,经济作物,地方特种,地方特色食品,食品,工艺品\" name=\"keywords\" />\n" +
                "    <meta content=\"\" name=\"description\" />\n" +
                "\n" +
                "    <script type=\"text/javascript\" src=\"http://localhost:9101/js/jquery-1.8.3.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"http://localhost:9101/js/jquery.SuperSlide.2.1.1.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"http://localhost:9101/js/jquery.hoverdir.js\"></script>\n" +
                "\n" +
                "    <!--  导入angularjs  -->\n" +
                "    <#--<script type=\"text/javascript\" src=\"http://localhost:9101/plugins/angularjs/angular.min.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"http://localhost:9101/js/base.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"http://localhost:9101/js/service/sxdbcpzsService.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"http://localhost:9101/js/controller/sxdbcpzsController.js\"></script>-->\n" +
                "\n" +
                "    <!--<script type=\"text/javascript\" src=\"../../js/jquery.js\"></script>-->\n" +
                "    <!-- custom scrollbar plugin -->\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:9101/css/index/jquery.mCustomScrollbar.css\" />\n" +
                "    <script src=\"http://localhost:9101/js/index/jquery.mCustomScrollbar.concat.min.js\"></script>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "\n" +
                "<body class=\"cpzs\" >\n" +
                "<div class=\"main\" style=\"width: 100%;height: 100%;min-height: 600px;min-width: 1200px;\">\n" +
                "    <!--top-->\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:9101/css/index/dbcp.css\">\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:9101/css/index/cmsstyle.css\">\n" +
                "    <link href=\"http://localhost:9101/css/index/atlas.css\" rel=\"stylesheet\"/>\n" +
                "\n" +
                "    <!-- custom scrollbar plugin -->\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:9101/css/index/jquery.mCustomScrollbar.css\" />\n" +
                "    <script src=\"http://localhost:9101/js/index/jquery.mCustomScrollbar.concat.min.js\"></script>\n" +
                "\n" +
                "    <script type=\"text/javascript\" src=\"http://localhost:9101/js/index/mcomm.js\"></script>\n" +
                "\n" +
                "\n" +
                "    <div class=\"headerbg\">\n" +
                "        <div class=\"header\">\n" +
                "            <div class=\"logo\"></div>\n" +
                "            <div class=\"nav\">\n" +
                "                <ul>\n" +
                "                    <li><a href=\"/page/index.do\" target=\"_self\">首 页</a></li>\n" +
                "                    <li class=\"current\"><a href=\"/page/dbcpzs.do\" target=\"_self\" title=\"地标产品展示\">地标产品展示</a></li>\n" +
                "                    <li><a href=\"/page/sydbqy.do\" title=\"使用地标企业\">使用地标企业</a></li>\n" +
                "                    <li><a href=\"#\" target=\"_self\" title=\"地标产品统计\">地标产品统计</a></li>\n" +
                "                    <li><a href=\"#\" target=\"_self\" title=\"地标保护公告\">地标保护公告</a></li>\n" +
                "                    <li><a href=\"#\" target=\"_self\" title=\"地标申报指南\">地标申报指南</a></li>\n" +
                "                    <li><a href=\"#\" target=\"_self\" title=\"政策文件\">政策文件</a></li>\n" +
                "                    <li><a href=\"#\" target=\"_self\" title=\"地标产品介绍\">地标产品介绍</a></li>\n" +
                "                </ul>\n" +
                "                <label class=\"showSearch\" title=\"搜索\"></label>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "    <div class=\"cpindex\" >\n" +
                "        <div class=\"home_ad\">\n" +
                "            <div class=\"picScroll-left\">\n" +
                "                <div class=\"bd\">\n" +
                "\n" +
                "                    <ul class=\"picList da-thumbs\">\n" +
                "\n" +
                "                        <li>\n" +
                "                            <div class=\"ad\">\n" +
                "                                <div class=\"tl\">测试1</div>\n" +
                "                                <img src=\"../member/upload/pms/201507/0619524175a1.png\" />\n" +
                "                                <div class=\" cplist\">\n" +
                "                                    <p>\n" +
                "                                        <a href=\"405.html\" title=\"贵州茅台酒\" target=\"_blank\">测试1-1</a>\n" +
                "                                    </p>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <div class=\"ad\">\n" +
                "                                <div class=\"tl\">测试2</div>\n" +
                "                                <img src=\"../member/upload/pms/201507/06195259xd0e.png\" />\n" +
                "                                <div class=\" cplist\">\n" +
                "                                    <p>\n" +
                "                                        <a href=\"398.html\" title=\"赫章核桃\" target=\"_blank\">测试2-1</a>\n" +
                "                                    </p>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <div class=\"ad\">\n" +
                "                                <div class=\"tl\">养殖类</div>\n" +
                "                                <img src=\"../member/upload/pms/201507/061953133uhf.png\" />\n" +
                "                                <div class=\" cplist\">\n" +
                "                                    <p>\n" +
                "                                        <a href=\"393.html\" title=\"从江香猪\" target=\"_blank\">从江香猪</a>\n" +
                "\n" +
                "                                    </p>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <div class=\"ad\">\n" +
                "                                <div class=\"tl\">中药材类</div>\n" +
                "                                <img src=\"../member/upload/pms/201507/06195329bech.png\" />\n" +
                "                                <div class=\" cplist\">\n" +
                "                                    <p>\n" +
                "                                        <a href=\"392.html\" title=\"赤水金钗石斛\" target=\"_blank\">赤水金钗石斛</a>\n" +
                "\n" +
                "                                    </p>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <div class=\"ad\">\n" +
                "                                <div class=\"tl\">粮油类</div>\n" +
                "                                <img src=\"../member/upload/pms/201507/06195344ijt5.png\" />\n" +
                "                                <div class=\" cplist\">\n" +
                "                                    <p>\n" +
                "                                        <a href=\"403.html\" title=\"黎平香禾糯\" target=\"_blank\">黎平香禾糯</a>\n" +
                "                                    </p>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <div class=\"ad\">\n" +
                "                                <div class=\"tl\">加工食品类</div>\n" +
                "                                <img src=\"../member/upload/pms/201507/06195405423m.png\" />\n" +
                "                                <div class=\" cplist\">\n" +
                "                                    <p>\n" +
                "                                        <a href=\"396.html\" title=\"独山盐酸菜\" target=\"_blank\">独山盐酸菜</a>\n" +
                "\n" +
                "                                    </p>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <div class=\"ad\">\n" +
                "                                <div class=\"tl\">工艺品类</div>\n" +
                "                                <img src=\"../member/upload/pms/201510/111043429zqi.png\" />\n" +
                "                                <div class=\" cplist\">\n" +
                "                                    <p>\n" +
                "                                        <a href=\"416.html\" title=\"大方漆器\" target=\"_blank\">大方漆器</a>\n" +
                "\n" +
                "                                    </p>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </li>\n" +
                "                        <li>\n" +
                "                            <div class=\"ad\">\n" +
                "                                <div class=\"tl\">工艺品类</div>\n" +
                "                                <img src=\"../member/upload/pms/201510/111043429zqi.png\" />\n" +
                "                                <div class=\" cplist\">\n" +
                "                                    <p>\n" +
                "                                        <a href=\"416.html\" title=\"大方漆器\" target=\"_blank\">大方漆器</a>\n" +
                "\n" +
                "                                    </p>\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                        </li>\n" +
                "                    </ul>\n" +
                "\n" +
                "\n" +
                "                </div>\n" +
                "                <div class=\"ad_title\">\n" +
                "                    <div class=\"hd\">\n" +
                "                        <a class=\"prev\" title=\"\"></a>\n" +
                "                        <a class=\"next\" title=\"\"></a>\n" +
                "                        <!--  <div style=\"width: 200px;margin: 0 auto;text-align:center;\"><ul></ul></div>-->\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <!--footer-->\n" +
                "    <div class=\"footer\">\n" +
                "        <span style=\"margin-top: 2px;display: block;\"></span>\n" +
                "    </div>\t\t<!--/footer-->\n" +
                "</div>\n" +
                "\n" +
                "<script type=\"text/javascript\">\n" +
                "\n" +
                "    $(function() {\n" +
                "        $('#da-thumbs > li').hoverdir();\n" +
                "    });\n" +
                "\n" +
                "    $(\".home_ad .picScroll-left\").slide({\n" +
                "        titCell:\".hd ul\",\n" +
                "        mainCell:\".bd ul\",\n" +
                "        autoPage:true,\n" +
                "        effect:\"left\",\n" +
                "        autoPlay:true,\n" +
                "        scroll:1,\n" +
                "        vis:4,\n" +
                "        pnLoop:false,\n" +
                "        delayTime:1000\n" +
                "    });\n" +
                "\n" +
                "    (function($){\n" +
                "        $(window).load(function(){\n" +
                "            //$.mCustomScrollbar.defaults.scrollButtons.enable=true; //enable scrolling buttons by default\n" +
                "            //$.mCustomScrollbar.defaults.axis=\"yx\"; //enable 2 axis scrollbars by default\n" +
                "            $(\".cplist\").mCustomScrollbar({theme:\"dark-thick\"});//dark-thick minimal-dark\n" +
                "        });\n" +
                "    })(jQuery);\n" +
                "\n" +
                "</script>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return str;
    }

    @Override
    public Map<String,Object> getList(Map searchMap) {
        //返回页面结果集
        Map<String,Object> map = new HashMap<>();
        TbEnterpriseExample tbEnterpriseExample = new TbEnterpriseExample();
        String type = searchMap.get("searchType").toString();
        /*System.out.println("***************" + type);*/
        String keywords = searchMap.get("searchVal").toString();
        if("产品名称".equals(type)){
            TbProductExample productExample = new TbProductExample();
            productExample.createCriteria().andNameLike("%" + keywords + "%" ).andIsdeleteEqualTo(0);
            List<TbProduct> productList = tbProductMapper.selectByExample(productExample);
            List<Integer> list  = new ArrayList<>();
            for(TbProduct product : productList){
                list.add(product.getId());
            }
            tbEnterpriseExample.createCriteria().andProductIdIn(list);
            //List<TbEnterpriseExt> tbEnterpriseList = tbEnterpriseMapper.selectByExampleReturnTBEXT(tbEnterpriseExample);
        }else if("企业名称".equals(type)){
            tbEnterpriseExample.createCriteria().andEnterpriseNameLike("%" + keywords + "%");
        }else if("统一信用代码".equals(type)){
            tbEnterpriseExample.createCriteria().andUniformSocialCreditCodeLike("%" + keywords + "%");
        }else if("核准使用公告号".equals(type)){
            tbEnterpriseExample.createCriteria().andApprovalAnnouncementNoEnterpriseLike("%" + keywords + "%");
        }else if("核准时间".equals(type)){
            tbEnterpriseExample.createCriteria().andApprovalYearLikeWithYongBiao("%" + keywords + "%");
        }else if("核准单位".equals(type)){
            tbEnterpriseExample.createCriteria().andApprovalAuthorityEnterpriseLike("%" + keywords + "%");
        }else if("".equals(type)){

        }
        PageHelper.startPage(Integer.parseInt(searchMap.get("pageNo").toString()),20);
        Page<TbEnterpriseExt> page = (Page<TbEnterpriseExt>)tbEnterpriseMapper.selectByExampleReturnTBEXT(tbEnterpriseExample);
        //Page<TbEnterpriseExt> page = (Page<TbEnterpriseExt>) tbEnterpriseMapper.selectByExample(tbEnterpriseExample);
        //Page<TbEnterpriseExt> page = (Page<TbEnterpriseExt>) tbEnterpriseMapper.selectSydbqyList(null);
        System.out.println(page.getPages());
        map.put("rows",page.getResult());
        map.put("totalPages", page.getPages());
        map.put("total",page.getTotal());
        return map;
    }


}
