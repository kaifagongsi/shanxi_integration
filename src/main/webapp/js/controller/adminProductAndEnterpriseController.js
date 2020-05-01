adminApp.controller('adminProductAndEnterpriseController',function ($scope,adminProductService,$location) {
    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':10};
    $scope.pageDate={ 'list' : '','totalPages':''};
    $scope.currPageNo = 1;
    $scope.firstDot = true;//前面有点
    $scope.lastDot = true;//后面有点
    //产品详细信息的报错
    $scope.pData = {'content':'','title':'','id':'1','type':'展示','time':''};
    //产品自己的信息
    $scope.product = {'id':0,'name':'','classificationid':'','applicantOrganization':'','preliminaryExaminationBody':'','provinceName':'','cityName':'','protectionScope':'',
                        'documentDefiningTheScopeOfProtection':'','technicalSpecifications':'','useOfSpecialSigns':'','approvalAuthorityProduct':'',
                    'approvalAnnouncementNoProduct':'','approvalAnnouncementNoProductAll':'','protectionNoticeTitle':'','administrativeArea':''};

    $scope.adminArea = null;
    $scope.noticePiZhunList = null;
    $scope.noticeShouLiList = null;
    $scope.areasCityList = null;
    $scope.areasCountyList = null;
    $scope.content = null;

    $scope.enterpriseList= {'list':''};


    /*******************************用表企业**********************************/
    $scope.loadEnterprise = function(){
        adminProductService.loadEnterprise($scope.searchMap).success(function (response) {
            $scope.enterpriseList.list = response.queryResult.map.enterpriseList;
           console.log(response);
            $scope.pageDate = response;
           buildPageLabel(response.queryResult.map.totalPages);
        });
    };

    /*******************************产品功能**********************************/

    $scope.deleteProduct = function(productId){
        adminProductService.deleteProduct(productId).success(function (response) {
            console.log(response);
        });
    };

    /*
    * 监听市级别发生变化，进行重新获取县级别的区间
    * */
    $scope.$watch('product.administrativeAreaProv',function (newValue,oldValue) {
        console.log(newValue,oldValue);
        adminProductService.getAreasCountyList(newValue).success(function (response) {
            $scope.areasCountyList = response.queryResult.list;
        });
    });

    function initSelect() {
        adminProductService.initSelect().success(function (response) {
            console.log(response);
            $scope.adminArea = response.queryResult.map.adminArea;
            $scope.noticePiZhunList = response.queryResult.map.noticePiZhunList;
            $scope.noticeShouLiList = response.queryResult.map.noticeShouLiList;
            $scope.areasCityList = response.queryResult.map.areasCityList;
           // $scope.areasCountyList = response.queryResult.map.areasCountyList;
        });
    }


    $scope.initProduct = function(){
        //接收index.html传参
        initSelect();
        if ($location.$$search.id) {
            $scope.product.id = $location.$$search['id'];
            //查询产品相关信息
            adminProductService.getProductByProductId($scope.product.id).success(function (response) {
                if('11111' ==response.code ){
                    alert('操作失败，查询异常');
                }else{
                    $scope.product = response.queryResult.map.item;
                    $scope.product.approvalAnnouncementNoProductAll = parseInt($scope.product.approvalAnnouncementNoProductAll);
                    $scope.product.protectionNoticeTitle = parseInt($scope.product.protectionNoticeTitle);
                }
            });
            //查询产品详细信息
            adminProductService.getProductInfoByProductId($scope.product.id).success(function (response) {
                CKEDITOR.instances.TextArea1.setData(response.queryResult.map.content);
                console.log(response);
            });
        }
    };

    $scope.saveProduct = function(){
        console.log($scope.product);
        adminProductService.saveProduct($scope.product).success(function (response) {
           console.log(response);
            if(response.code == '10000'){
                alert('保存产品基本信息成功');
            }else{
                alert('发送异常请稍候再试');
            }
        });
    };

    //保存产品详细
    $scope.upload= function(){
        $scope.pData.content = CKEDITOR.instances.TextArea1.getData();
        $scope.pData.title = $('#title').val();
        $scope.pData.type = $('#fileType option:selected').val();//选中的值
        /*$scope.pData.type = '展示';*/
        console.log($scope.pData);
        adminProductService.upload( $scope.pData ).success(
            function(response3){
                alert('保存成功');
            }
        );
    };




    /*******************************产品列表**********************************/

    $scope.load = function () {
        adminProductService.load($scope.searchMap).success(function (response) {
            $scope.pageDate = response;
            $scope.pageDate.list = response.queryResult.map.rows;
            $scope.pageDate.totalPages = $scope.pageDate.queryResult.map.totalPages;
            buildPageLabel($scope.pageDate.queryResult.map.totalPages);
        });
    };


    //分页
    /**
     * 总页数
     */
    function buildPageLabel ( totalPages) {
        $scope.pageLabel = [];
        let maxPageNo = totalPages;//最后页码
        let firstPage = 1;//开始页码
        let lastPage = maxPageNo;//截止页码
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
        for(let i = firstPage;i <=lastPage; i++){
            $scope.pageLabel.push(i);
        }
    }

    //判断当前为第一页
    $scope.isTopPage = function () {
        if($scope.currPageNo == 1){
            return true;
        }else{
            return false;
        }
    };

    //判断当前为最后一页
    $scope.isEndPage = function () {
        if($scope.pageDate.totalPages == $scope.currPageNo){
            return true;
        }else{
            return false;
        }
    };

    //刷新列表
    $scope.queryByPage = function (pageNo,type) {
        if(type == '1'){
            //页码验证
            if(pageNo < 1 || pageNo > $scope.pageDate.totalPages){
                return;
            }
            $scope.currPageNo = pageNo;
            $scope.searchMap.pageNo = pageNo;
            $scope.flush();
        }else{
            //页码验证
            if(pageNo < 1 || pageNo > $scope.pageDate.totalPages){
                return;
            }
            $scope.currPageNo = pageNo;
            $scope.searchMap.pageNo = pageNo;
            $scope.loadEnterprise();
        }
    };

    $scope.flush = function () {
        adminProductService.load( $scope.searchMap).success(
            function(response){
                $scope.pageDate = response;
                $scope.pageDate.list = response.queryResult.map.rows;
                buildPageLabel($scope.pageDate.queryResult.map.totalPages);
            }
        );
    };

});