adminApp.controller('adminProductStandardController',function ($scope,$location,adminProductStandardService) {

    // 查询参数
    $scope.searchMap = {'pageNo': 1, 'pageSize': 15, 'keywords': '', 'searchType': '', 'searchVal': ''};
    $scope.resultMap = {'totalPages': '0','total':'','rows':''};
    //数据列表页面列表页加载
    $scope.load=function(){
        adminProductStandardService.loadList( $scope.searchMap ).success(
            function(response){
                $scope.resultMap = response.queryResult.map;//搜索返回的结果
                buildPageLabel();
            }
        );
    };

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



    //初始化详细页面
    $scope.productStandardInfoItem = null;
    $scope.initProductStandardInfo = function(){
        if($location.$$search.id){ // 表示为编辑
            adminProductStandardService.initProductStandardInfoServer($location.$$search.id).success( function (response) {
                $scope.productStandardInfoItem = response.queryResult.map.item;
                console.log($scope.productStandardInfoItem);
            })
        }else{ // 表示为新增

        }
    }

    $scope.saveProductStandard = function () {
        adminProductStandardService.saveProductStandardServer($scope.productStandardInfoItem).success( function (response) {
            if(response.code == '10000'){
                alert("保存成功！");
                location.href="../../admin/productStandard/productStandardDataList.html";
            }
        })
    }

    $scope.deleteProductStandard = function (id) {
        alert(id);
        adminProductStandardService.deleteProductStandard(id).success(function (response) {
            if(response.code == '10000'){
                alert("删除成功！");
                $scope.load();
            }
        })
    }
});