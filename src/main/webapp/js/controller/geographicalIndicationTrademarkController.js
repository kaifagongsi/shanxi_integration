//控制层
trademarkApp.controller('trademarkController',function ($scope,$location,geographicalIndicationTrademarkService) {
    $scope.searchMap = {'pageNo': 1, 'pageSize': 15,'searchType':'0','searchVal':''};
    $scope.resultMap = {'totalPages': '0','rows':null,'total':0};

    //页面加载
    $scope.search = function () {
        geographicalIndicationTrademarkService.search($scope.searchMap).success(function (response) {
            console.log(response);
            $scope.resultMap.total = response.queryResult.map.total;
            $scope.resultMap.totalPages = response.queryResult.map.totalPages;
            $scope.resultMap.rows = response.queryResult.map.list;
            buildPageLabel();
        })
    };

    /* 分页跳转 */
    $scope.queryByPage = function (pageNo) {
        //页码验证
        if(pageNo < 1 || pageNo > $scope.resultMap.totalPages){
            return;
        }
        $scope.searchMap.pageNo = pageNo;
        $scope.search();
    };
    /*  构建分页 */
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
});