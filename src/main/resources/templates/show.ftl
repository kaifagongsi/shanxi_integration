<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>地标产品展示 - 中国▪陕西地理标志保护产品</title>
    <meta content="陕西地理标志保护产品,陕西地理标志保护产品,产品,地理,保护,标志,地理标志,地理标志保护,地理标志保护产品,茶,酒,果蔬,养殖,中药材,经济作物,地方特种,地方特色食品,食品,工艺品" name="keywords" />
    <meta content="" name="description" />

    <script type="text/javascript" src="http://172.17.1.249:9103/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="http://172.17.1.249:9103/js/jquery.SuperSlide.2.1.1.js"></script>
    <script type="text/javascript" src="http://172.17.1.249:9103/js/jquery.hoverdir.js"></script>

    <!--  导入angularjs  -->
    <script type="text/javascript" src="http://172.17.1.249:9103/plugins/angularjs/angular.min.js"></script>
    <script type="text/javascript" src="http://172.17.1.249:9103/js/firstWebBase.js"></script>
    <script type="text/javascript" src="http://172.17.1.249:9103/js/service/sxdbcpzsService.js"></script>
    <script type="text/javascript" src="http://172.17.1.249:9103/js/controller/sxdbcpzsController.js"></script>

    <!--<script type="text/javascript" src="../../js/jquery.js"></script>-->
    <!-- custom scrollbar plugin -->
    <link rel="stylesheet" type="text/css" href="http://172.17.1.249:9103/css/index/jquery.mCustomScrollbar.css" />
    <script src="http://172.17.1.249:9103/js/index/jquery.mCustomScrollbar.concat.min.js"></script>

</head>


<body class="cpzs" >
<#--${tongji['0400蔬菜类'][0].classificationid}-------------------------------->
<div class="main" style="width: 100%;height: 100%;min-height: 600px;min-width: 1200px;" ng-controller="sxdbcpzsController" ng-init="search()">
    <!--top-->
    <link rel="stylesheet" type="text/css" href="http://172.17.1.249:9103/css/index/dbcp.css">
    <link rel="stylesheet" type="text/css" href="http://172.17.1.249:9103/css/index/cmsstyle.css">
    <link href="http://172.17.1.249:9103/css/index/atlas.css" rel="stylesheet"/>

    <!-- custom scrollbar plugin -->
    <link rel="stylesheet" type="text/css" href="http://172.17.1.249:9103/css/index/jquery.mCustomScrollbar.css" />
    <script src="http://172.17.1.249:9103/js/index/jquery.mCustomScrollbar.concat.min.js"></script>

    <script type="text/javascript" src="http://172.17.1.249:9103/js/index/mcomm.js"></script>


    <div class="headerbg">
        <div class="header">
            <div class="logo"></div>
            <div class="nav">
                <ul>
                    <li><a href="/page/index.do" target="_self">首 页</a></li>
                    <li class="current"><a href="/page/dbcpzs.do" target="_self" title="地标产品展示">地标产品展示</a></li>
                    <li><a href="/page/sydbqy.do" title="使用地标企业">使用地标企业</a></li>
                    <li><a href="http://172.17.1.249:9102/Statistics.html" target="_self" title="地标产品统计">地标产品统计</a></li>
                    <li><a href="http://172.17.2.15:9103/index.html" target="_self" title="地标保护公告">地标保护公告</a></li>
                    <li><a href="http://172.17.2.15:9103/guideBook.htm" target="_self" title="地标申报指南">地标申报指南</a></li>
                    <li><a href="http://172.17.2.15:9104/policyPapers.html" target="_self" title="政策文件">政策文件</a></li>
                    <li><a href="http://172.17.2.15:9103/productIntroduction.html" target="_self" title="地标产品介绍">地标产品介绍</a></li>
                </ul>
                <label class="showSearch" title="搜索"></label>
            </div>
        </div>

    </div>
    <div class="cpindex" >
        <div class="home_ad">
            <div class="picScroll-left">
                <div class="bd">

                    <ul class="picList da-thumbs">
                        <#if tongji??>
                            <#list  tongji?keys as k >
                                <li>
                                    <div class="ad">
                                        <div class="tl">${k?substring(4)}</div>
                                        <img src="http://172.17.1.249:9103/img/index/201507/${k?substring(0,4)}.jpg" />
                                        <div class=" cplist">
                                            <p>
                                                <#list tongji[k] as list>
                                                <#--${list.classificationid}-->
                                                    <a href="http://172.17.1.249:9103/page/detail.do#?idVal=${list.id}&titleVal=${list.name}" title="${list.name}" target="_blank">${list.name}</a>
                                                </#list>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                            </#list>
                        </#if>
                        <#if tongjiguonei??>
                            <#list  tongjiguonei?keys as k >
                                <li>
                                    <div class="ad">
                                        <div class="tl">${k?substring(4)}</div>
                                        <img src="http://localhost:9103/img/index/guonei/${k?substring(0,4)}.jpg" />
                                        <div class=" cplist">
                                            <p>
                                                <#list tongjiguonei[k] as list>
                                                <#--${list.classificationid}-->
                                                    <a href="http://localhost:9103/page/detail.do#?idVal=${list.id}&titleVal=${list.name}" title="${list.name}" target="_blank">${list.name}</a>
                                                </#list>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                            </#list>
                        </#if>
                    </ul>
                </div>
                <div class="ad_title">
                    <div class="hd">
                        <a class="prev" title=""></a>
                        <a class="next" title=""></a>
                        <!--  <div style="width: 200px;margin: 0 auto;text-align:center;"><ul></ul></div>-->
                    </div>
                </div>
            </div>


        </div>
    </div>

    <!--footer-->
    <div class="footer">
        <span style="margin-top: 2px;display: block;"></span>
    </div>		<!--/footer-->
</div>

<script type="text/javascript">

    $(function() {
        $('#da-thumbs > li').hoverdir();
    });

    $(".home_ad .picScroll-left").slide({
        titCell:".hd ul",
        mainCell:".bd ul",
        autoPage:true,
        effect:"left",
        autoPlay:true,
        scroll:1,
        vis:4,
        pnLoop:false,
        delayTime:1000
    });

    (function($){
        $(window).load(function(){
            //$.mCustomScrollbar.defaults.scrollButtons.enable=true; //enable scrolling buttons by default
            //$.mCustomScrollbar.defaults.axis="yx"; //enable 2 axis scrollbars by default
            $(".cplist").mCustomScrollbar({theme:"dark-thick"});//dark-thick minimal-dark
        });
    })(jQuery);

</script>


</body>
</html>