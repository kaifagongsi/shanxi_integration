adminApp.controller('relatedWebsitesController',function ($scope,adminRelatedWebsitesService,$location) {
    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':10};
    $scope.productRelatedWebsitesSearchMap = {'keywords':'','pageNo':1,'pageSize':10};
    $scope.pageRelatedWebSitesDate = {'list':'','totalPages':'','total':''};
    $scope.productRelatedWebSitesRelevance = {'list':'','totalPages':'','total':''};
    $scope.currPageNo = 1;
    $scope.firstDot = true;//前面有点
    $scope.lastDot = true;//后面有点

    $scope.relatedMode = {'id':'','productId':'','name':'','picUrl':'','webUrl':'','type':'','productName':'','spare':''};

    //三个列表
    $scope.enterpriseList = null;
    $scope.productList = null;
    $scope.websitesList = null;

    $scope.productAboutEntAndWeb = {'productId':'','ent':[],'web':[],'id':''};

    /************************************检测列表切换*******************************************************/
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        if(e.target.innerHTML=="相关企业网站"){
            $scope.loadList();
        }else if(e.target.innerHTML=="产品与相关企业网站的关联"){
            $scope.loadRelatedWebsitesList();
        }
    });

    /*********************************产品与相关企业网站的关联的列表*****************************************/
    $scope.loadRelatedWebsitesList = function () {
        adminRelatedWebsitesService.loadRelatedWebsitesList($scope.productRelatedWebsitesSearchMap).success(function (response) {
            console.log(response);
            $scope.productRelatedWebSitesRelevance.list =  response.queryResult.map.rows;
            $scope.productRelatedWebSitesRelevance.total =  response.queryResult.map.total;
            $scope.pageRelatedWebSitesDate.totalPages =response.queryResult.map.totalPages;

            buildPageLabel($scope.pageRelatedWebSitesDate.totalPages);
        });
    };

    /*********************************产品与相关企业网站的关联*****************************************/

    $scope.loadProductRelatedWebsitesRellevance = function(){
        $scope.loadProductRelatedWebsites();
        if($location.$$search.id){
            // 编辑功能放弃 编辑功能放弃 编辑功能放弃 编辑功能放弃 编辑功能放弃 编辑功能放弃
             //表示为编辑
            $scope.productAboutEntAndWeb.id = $location.$$search['id'];
            //查询当前关联
            adminRelatedWebsitesService.getProductRelatedWebsitesRellevance($scope.productAboutEntAndWeb.id).success(function (response) {

            });
        }else{
            //表示为新增
        }
    };

    $scope.deleteProductRelatedWebsitesRelevance = function(id){
        if(window.confirm("确认删除该关联？")){
            adminRelatedWebsitesService.deleteProductRelatedWebsitesRelevance(id).success(function (response) {
                if(response.code = '10000'){
                    alert(response.message);
                    $scope.loadRelatedWebsitesList();
                }else{
                    alert("操作失败");
                }
            });
        }
    };



    //新增或者编辑是初始化下拉框
    $scope.loadProductRelatedWebsites = function(){
        adminRelatedWebsitesService.loadProductRelatedWebsites().success(function (response) {
            console.log(response);
            $scope.enterpriseList = response.queryResult.map.enterpriseList;
            $scope.productList = response.queryResult.map.productList;
            $scope.websitesList = response.queryResult.map.websitesList;
        });
    };


    $scope.saveProductAboutEntAndWeb = function(){
        adminRelatedWebsitesService.saveProductAboutEntAndWeb($scope.productAboutEntAndWeb).success(function (response) {
            if(response.code = '10000'){
                alert(response.message);
            }else{
                alert("操作失败");
            }
        });
    };


    /***************************************相关企业网站新增*********************************************************/

    $scope.load = function(){
        if ($location.$$search.id) {
            //表示为更新
            $scope.relatedMode.id = $location.$$search['id'];
            console.log($location.$$search['id']);
            adminRelatedWebsitesService.selectById($scope.relatedMode.id).success(function (response) {
                $scope.relatedMode= response.queryResult.map.relatedWebsites;
                /*console.log(response);
                $scope.enterprise = response.queryResult.map.item;
                $scope.enterprise.approvalAnnouncementNoEnterpriseAll = parseInt(response.queryResult.map.item.approvalAnnouncementNoEnterpriseAll);*/
            });
        }else{

        }
    };

    $scope.deleteRelatedWebsites = function( id ){
        if(window.confirm("您将删除改相关企业/网站，并删除对应的关联关系请谨慎操作，改操作不可恢复")){
            adminRelatedWebsitesService.deleteRelatedWebsites(id).success(function (response) {
                if(response.code == '10000'){
                    alert(response.message);
                    $scope.loadList();
                }else{
                    alert("保存失败");
                }
            });
        }else{
            alert("用户取消");
        }

    };

    $scope.saveRelatedMode = function (){
        adminRelatedWebsitesService.saveRelatedMode($scope.relatedMode).success(function (response) {
            if(response.code == '10000'){
                alert(response.message);
            }else{
                alert("保存失败");
            }
        });
    };

    $scope.saveImg = function () {
        if(imgFile.files[0] == null){
            alert("请选择图片");
        }else{
            adminRelatedWebsitesService.saveUploadImg().success(function (response) {
                if(response.code == '10000'){
                    alert(response.message);
                    $scope.relatedMode.picUrl = response.queryResult.map.picUrl;
                }else{
                    alert("图片上传失败");
                }
            });
        }
    };



    /***************************************相关企业网站列表*********************************************************/
    // 加载默认列表
    $scope.loadList = function () {
        adminRelatedWebsitesService.loadList($scope.searchMap).success(function (response) {
            $scope.pageRelatedWebSitesDate.list = response.queryResult.map.rows;
            $scope.pageRelatedWebSitesDate.totalPages =response.queryResult.map.totalPages;
            $scope.pageRelatedWebSitesDate.total = response.queryResult.map.total;
            buildPageLabel($scope.pageRelatedWebSitesDate.totalPages);
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
    };

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
        if($scope.pageRelatedWebSitesDate.totalPages == $scope.currPageNo){
            return true;
        }else{
            return false;
        }
    };

    //刷新列表
    $scope.queryByPage = function (pageNo,type) {

        if(type == 1 ){
            // 相关企业与网站
            //页码验证
            if(pageNo < 1 || pageNo > $scope.pageRelatedWebSitesDate.totalPages){
                return;
            }
            $scope.currPageNo = pageNo;
            $scope.searchMap.pageNo = pageNo;
            $scope.loadList();
        }else if(type == 2){
            //产品与相关企业与网站 的关联
        }

    };


});