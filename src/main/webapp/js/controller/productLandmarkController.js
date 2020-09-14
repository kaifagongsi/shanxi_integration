landmarkApp.controller('landmarkController',function ($scope,$location,landmarkService) {
    $scope.searchMap = {'pageNo': 1, 'pageSize': 20, 'keywords': '','selectIndustry':'','selectType':'','selectCity':'','selectCounty':'','selectYear':'' };
    $scope.resultMap = {"totalPages": "0"};
    $scope.industryMap = [
        {
            "industry":"种植业类",
            "type":[
                "蔬菜类",
                "果品类",
                "粮食类",
                "食用菌类",
                "油料类",
                "糖料类",
                "茶叶类",
                "香料类",
                "药材类",
                "花卉类",
                "烟草类",
                "棉麻蚕丝类",
                "热带作物类",
                "其他植物类"
            ]
        },
        {
            "industry":"畜牧业类",
            "type":[
                "肉类产品类",
                "蛋类产品类",
                "奶制品类",
                "蜂类产品类",
                "其他畜牧产品类"
            ]
        },
        {
            "industry":"水产业类",
            "type":[
                "水产动物类",
                "水产植物类",
                "水产初级加工品类"
            ]
        }

    ];
    $scope.shanxiMap = [
        {
            "city":"西安市",
            "county":[
                "市辖区",
                "新城区",
                "碑林区",
                "莲湖区",
                "灞桥区",
                "未央区",
                "雁塔区",
                "阎良区",
                "临潼区",
                "长安区",
                "蓝田县",
                "周至县",
                "鄠邑区",
                "高陵区"
            ]
        },
        {
            "city":"铜川市",
            "county":[
                "市辖区",
                "王益区",
                "印台区",
                "耀州区",
                "宜君县"
            ]
        },
        {
            "city":"宝鸡市",
            "county":[
                "市辖区",
                "渭滨区",
                "金台区",
                "陈仓区",
                "凤翔县",
                "岐山县",
                "扶风县",
                "眉县",
                "陇县",
                "千阳县",
                "麟游县",
                "凤县",
                "太白县"
            ]
        },
        {
            "city":"咸阳市",
            "county":[
                "市辖区",
                "秦都区",
                "杨凌区",
                "渭城区",
                "三原县",
                "泾阳县",
                "乾县",
                "礼泉县",
                "永寿县",
                "彬州市",
                "长武县",
                "旬邑县",
                "淳化县",
                "武功县",
                "兴平市"
            ]
        },
        {
            "city":"渭南市",
            "county":[
                "市辖区",
                "临渭区",
                "华州区（华州区）",
                "潼关县",
                "大荔县",
                "合阳县",
                "澄城县",
                "蒲城县",
                "白水县",
                "富平县",
                "韩城市",
                "华阴市"
            ]
        },
        {
            "city":"延安市",
            "county":[
                "市辖区",
                "宝塔区",
                "延长县",
                "延川县",
                "子长县",
                "安塞区",
                "志丹县",
                "吴起县",
                "甘泉县",
                "富县",
                "洛川县",
                "宜川县",
                "黄龙县",
                "黄陵县"
            ]
        },
        {
            "city":"汉中市",
            "county":[
                "市辖区",
                "汉台区",
                "南郑区",
                "城固县",
                "洋县",
                "西乡县",
                "勉县",
                "宁强县",
                "略阳县",
                "镇巴县",
                "留坝县",
                "佛坪县"
            ]
        },
        {
            "city":"榆林市",
            "county":[
                "市辖区",
                "榆阳区",
                "神木区",
                "府谷县",
                "横山区",
                "靖边县",
                "定边县",
                "绥德县",
                "米脂县",
                "佳县",
                "吴堡县",
                "清涧县",
                "子洲县"
            ]
        },
        {
            "city":"安康市",
            "county":[
                "市辖区",
                "汉滨区",
                "汉阴县",
                "石泉县",
                "宁陕县",
                "紫阳县",
                "岚皋县",
                "平利县",
                "镇坪县",
                "旬阳县",
                "白河县"
            ]
        },
        {
            "city":"商洛市",
            "county":[
                "市辖区",
                "商州区",
                "洛南县",
                "丹凤县",
                "商南县",
                "山阳县",
                "镇安县",
                "柞水县"
            ]
        },
        {
            "city":"杨凌示范区",
            "county":[
                "杨陵区"
            ]
        }
    ];
    $scope.yearList = [
        "2008年",
        "2009年",
        "2010年",
        "2011年",
        "2012年",
        "2013年",
        "2014年",
        "2015年",
        "2016年",
        "2017年",
        "2018年",
        "2019年",
        "2020年"
    ]

    //页面加载
    $scope.load = function () {
        //获取类型
        if ($("#industryVal") != undefined && $("#industryVal").val() != null && $("#industryVal").val() != '') {
            $scope.searchMap.selectIndustry = $("#industryVal").find("option:selected").text();
        } else {
            $scope.searchMap.selectIndustry = '';
        }
        //获取分类
        if ($("#typeVal") != undefined && $("#typeVal").val() != null && $("#typeVal").val() != ''){
            $scope.searchMap.selectType = $("#typeVal").find("option:selected").text();
        } else {
            $scope.searchMap.selectType = '';
        }
        //获取省
        if ($("#cityVal") != undefined && $("#cityVal").val() != null && $("#cityVal").val() != ''){
            $scope.searchMap.selectCity = $("#cityVal").find("option:selected").text();
        } else {
            $scope.searchMap.selectCity = '';
        }
        //获取市区
        if ($("#countyVal") != undefined && $("#countyVal").val() != null && $("#countyVal").val() != ''){
            $scope.searchMap.selectCounty = $("#countyVal").find("option:selected").text();
        } else {
            $scope.searchMap.selectCounty = '';
        }
        //获取年份
        if ($("#yearVal") != undefined && $("#yearVal").val() != null && $("#yearVal").val() != ''){
            $scope.searchMap.selectYear = $("#yearVal").find("option:selected").text();
        } else {
            $scope.searchMap.selectYear = '';
        }
        //获取查询关键字
        if ($("input[name='searchMap.keywords']") != undefined && $("input[name='searchMap.keywords']").val() != null && $("input[name='searchMap.keywords']").val() != ''
            && $("input[name='searchMap.keywords']").val() != '关键词搜索') {
            $scope.searchMap.keywords = $("input[name='searchMap.keywords']").val();
        } else {
            $scope.searchMap.keywords = '';
        }

        landmarkService.load($scope.searchMap).success(
            function (response) {
                $scope.resultMap = response;//搜索返回的结果
                buildPageLabel();
            }
        );
    };

    /*$scope.getShanxiMap = function(){
        landmarkService.getShanxiMap().success(
            function (response) {
                $scope.shanxiMap = response;
            }
        )
    };*/

    buildPageLabel = function () {
        $scope.pageLabel = [];
        var maxPageNo = $scope.resultMap.totalPages;//最后页码
        var firstPage = 1;//开始页码
        var lastPage = maxPageNo;//截止页码
        $scope.firstDot = true;//前面有点
        $scope.lastDot = true;//后面有点
        if($scope.resultMap.totalPages > 5){//如果总页数大于5
            if($scope.searchMap.pageNo <= 3){//当前页数小于等于3
                lastPage = 5;
                $scope.firstDot = false;//前面没点
            }else  if($scope.searchMap.pageNo >= lastPage - 2 ){//当前页数大于等于最大页数-2
                firstPage = maxPageNo -4;//后5页
                $scope.lastDot = false;//后面没点
            }else{//显示当前页为中心的5页
                firstPage = $scope.searchMap.pageNo - 2 ;
                lastPage = $scope.searchMap.pageNo + 2 ;
            }
        }else{
            $scope.firstDot = false;//前面无点
            $scope.lastDot = false;//后面无点
        }
        //循环生成页码的标签
        for(var i = firstPage;i <=lastPage; i++){
            $scope.pageLabel.push(i);
        }
    };

    $scope.queryByPage = function (pageNo) {
        //页码验证
        if(pageNo < 1 || pageNo > $scope.resultMap.totalPages){
            return;
        }
        $scope.searchMap.pageNo = pageNo;
        $scope.load();
    };

    //判断当前为第一页
    $scope.isTopPage = function () {
        if($scope.searchMap.pageNo == 1){
            return true;
        }else{
            return false;
        }
    };

    //判断当前为最后一页
    $scope.isEndPage = function () {
        if($scope.resultMap.totalPages == $scope.searchMap.pageNo){
            return true;
        }else{
            return false;
        }
    };
});