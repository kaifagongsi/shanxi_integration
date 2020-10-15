adminApp.controller('adminLandmarkController',function ($scope,$location,adminLandmarkService) {
    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':10};
    $scope.pageDate={ 'list' : '','totalPages':''};
    $scope.landmarkEntity ={ "id":"","productName":"","productNumber":"","city":"","county":"","industry":"","type":"","certificateHolder":"","registerYear":"",'content':''};
    $scope.searchData = {'productNumber':''};
    $scope.contentMap= {'id':0,'productName':'','productNumber':'','city':'','county':'','industry':'','type':'','certificateHolder':'','registerYear':'','content':''};
    $scope.currPageNo = 1;
    $scope.firstDot = true;//前面有点
    $scope.lastDot = true;//后面有点

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

    $scope.areasCityList = null;
    $scope.areasCountyList = null;
    $scope.industryList = null;
    $scope.typeList = null;

    /*$scope.initLandmark = function() {
        initSelect();
    }*/
    //初始化省市和行业下拉框
    function initSelect() {
        adminLandmarkService.initSelect().success(function (response){
            //console.log(response);
            $scope.areasCityList = response.queryResult.map.areasCityList;
            $scope.areasCountyList = response.queryResult.map.areasCountyList;
            $scope.industryList = response.queryResult.map.industryList;
            $scope.typeList = response.queryResult.map.typeList;
        })
    }

    /*
    * 监听市级别发生变化，进行重新获取县级别的区间
    * */
    $scope.$watch('contentMap.city',function (newValue,oldValue) {
        console.log(newValue,oldValue);
        adminLandmarkService.getAreasCountyList(newValue).success(function (response) {
            $scope.areasCountyList = response.queryResult.list;
        });
    });

    /**
     * 监听行业发生变化，重新获取分类的区间
     */
    $scope.$watch('contentMap.industry',function (newValue,oldValue) {
        console.log(newValue,oldValue);
        adminLandmarkService.getTypeList(newValue).success(function (response) {
            $scope.typeList = response.queryResult.list;
        })
    })


    /***************************农产品地理标志编辑********************************/
    $scope.initByProductNumber = function (){
        //接收index.html传参
        var idVal = "";
        if ($location.$$search.idVal) {
            //表示为更新
            initSelect();
            $scope.searchData.productNumber = $location.$$search['idVal'];
            adminLandmarkService.initByProductNumber($scope.searchData).success(
                function (response2) {
                    initSelect();
                    $scope.contentMap = response2;//搜索返回的结果
                    $("#city").find("option").eq(0).val(response2.city).text(response2.city);
                    $("#county").find("option").eq(0).val(response2.county).text(response2.county);
                    $("#industry").find("option").eq(0).val(response2.industry).text(response2.industry);
                    $("#type").find("option").eq(0).val(response2.type).text(response2.type);
                    console.log(CKEDITOR.instances.TextArea1.status === 'unloaded')
                    //$("#city option[text='"+response2.city+"']").attr("selected",true);
                    /*console.log(CKEDITOR.instances.TextArea1.status);
                    if(CKEDITOR.instances.TextArea1.status === 'unloaded'){
                        CKEDITOR.instances.TextArea1.setData($scope.contentMap.content);
                    }
                    console.log($scope.contentMap)*/
                   /* do{
                        if(CKEDITOR.instances.TextArea1.status === 'unloaded'){
                            CKEDITOR.instances.TextArea1.setData($scope.contentMap.content);
                            break;
                        }
                    }while(true)*/
                    CKEDITOR.on( 'instanceReady', function( evt ) {
                        var editor = evt.editor;
                        editor.setData( $scope.contentMap.content );

                    });
                }
            )
        }
        else{
            initSelect();
            return;
        }
    };

    /*******************************农产品地理标志列表**********************************/
    $scope.loadLandmark = function () {
        adminLandmarkService.loadLandmark($scope.searchMap).success(function (response) {
            //console.log(response)
            $scope.pageDate = response;
            $scope.pageDate.list = response.queryResult.map.rows;
            $scope.pageDate.totalPages = $scope.pageDate.queryResult.map.totalPages;
            buildPageLabel($scope.pageDate.queryResult.map.totalPages);
        });
    };

    /*********************************新增、编辑农产品地理标志*****************************/
    $scope.saveLandmark = function () {
        $scope.landmarkEntity.id = $("#landmarkId").val();
        $scope.landmarkEntity.productName = $("#productName").val();
        $scope.landmarkEntity.productNumber = $("#productNumber").val();
        $scope.landmarkEntity.city = $("#city option:selected").text();
        $scope.landmarkEntity.county = $("#county option:selected").text();
        $scope.landmarkEntity.industry = $("#industry option:selected").text();
        $scope.landmarkEntity.type = $("#type option:selected").text();
        $scope.landmarkEntity.certificateHolder = $("#certificateHolder").val();
        $scope.landmarkEntity.registerYear = $("#registerYear option:selected").text();
        $scope.landmarkEntity.content = CKEDITOR.instances.TextArea1.getData();
        adminLandmarkService.saveLandmark($scope.landmarkEntity).success(
            function(response2){
                console.log(response2);
                if (response2 == "success"){
                    alert("保存成功！");
                    location.href="../../admin/landmark/landmarkDataList.html";
                }
                else{
                    alert("保存出错，请检查后重试");
                }

            }
        )
    }

    /*********************************删除农产品地理标志*****************************/
    $scope.landmarkDelete = function (productNumber) {
        var msg = "删除后将不可恢复，是否确认删除？";
        if (confirm(msg) == true){
            adminLandmarkService.landmarkDelete(productNumber).success(function (response) {
                if(response.code = '10000'){
                    alert("删除成功");
                }else{
                    alert("请稍候尝试");
                }
                location.href="../../admin/landmark/landmarkDataList.html";
            })
        } else{
            return false;
        }

    }


    //分页
    /**
     * 总页数
     */
    function buildPageLabel ( totalPages) {
        $scope.pageLabel = [];
        var maxPageNo = totalPages;//最后页码
        var firstPage = 1;//开始页码
        var lastPage = maxPageNo;//截止页码
        $scope.firstDot = true;//前面有点
        $scope.lastDot = true;//后面有点
        if(totalPages > 5){//如果总页数大于5
            if($scope.currPageNo <= 3){//当前页数小于等于3
                lastPage = 5;
                $scope.firstDot = false;//前面没点
            }else  if($scope.currPageNo >= lastPage - 2 ){//当前页数大于等于最大页数-2
                firstPage = maxPageNo -4;//后5页
                $scope.lastDot = false;//后面没点
            }else{//显示当前页为中心的5页
                firstPage = $scope.currPageNo - 2 ;
                lastPage = $scope.currPageNo + 2 ;
            }
        }else{
            $scope.firstDot = false;//前面无点
            $scope.lastDot = false;//后面无点
        }
        //循环生成页码的标签
        for(var i = firstPage;i <=lastPage; i++){
            $scope.pageLabel.push(i);
        }
    }


    $scope.queryByPage = function (pageNo) {
        //页码验证
        if(pageNo < 1 || pageNo > $scope.pageDate.totalPages){
            return;
        }
        $scope.searchMap.pageNo = pageNo;
        $scope.loadLandmark();
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
        if($scope.pageDate.totalPages == $scope.searchMap.pageNo){
            return true;
        }else{
            return false;
        }
    };
});