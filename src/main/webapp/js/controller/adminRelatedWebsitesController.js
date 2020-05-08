adminApp.controller('relatedWebsitesController',function ($scope,adminRelatedWebsitesService) {

    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':10};

    $scope.pageDate = {'list':'','totalPages':'','total':''};

    $scope.currPageNo = 1;
    $scope.firstDot = true;//前面有点
    $scope.lastDot = true;//后面有点
    // 加载默认列表
    $scope.loadList = function () {
        adminRelatedWebsitesService.loadList($scope.searchMap).success(function (response) {
            $scope.pageDate.list = response.queryResult.map.rows;
            $scope.pageDate.totalPages =response.queryResult.map.totalPages;
            $scope.pageDate.total = response.queryResult.map.total;
            buildPageLabel($scope.pageDate.totalPages);
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
        if($scope.pageDate.totalPages == $scope.currPageNo){
            return true;
        }else{
            return false;
        }
    };

    //刷新列表
    $scope.queryByPage = function (pageNo,type) {
            //页码验证
            if(pageNo < 1 || pageNo > $scope.pageDate.totalPages){
                return;
            }
            $scope.currPageNo = pageNo;
            $scope.searchMap.pageNo = pageNo;
            $scope.loadList();

    };

    /*$scope.flush = function () {
        adminProductService.load( $scope.searchMap).success(
            function(response){
                $scope.pageDate = response;
                $scope.pageDate.list = response.queryResult.map.rows;
                buildPageLabel($scope.pageDate.queryResult.map.totalPages);
            }
        );
    };*/
});