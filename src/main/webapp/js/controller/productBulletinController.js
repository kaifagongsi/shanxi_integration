//统计控制层
tongjiApp.controller('productBulletinController',function ($scope,$location,$window,productBulletinService) {


    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':15,'searchType':'','searchVal':''};
    $scope.resultMap= {"totalPages":"0"};

    //列表页加载
    $scope.load=function(){
        productBulletinService.load( $scope.searchMap ).success(
            function(response1){
                $scope.resultMap = response1;//搜索返回的结果
                buildPageLabel();
            }
        );
    };

    //搜索
    $scope.search=function(){
        //获取查询关键字
        if($("#classificationSelect") != undefined && $("#classificationSelect").val() != null && $("#classificationSelect").val() != ''){
            $scope.searchMap.searchType = $("#classificationSelect").val();
        }else{
            $scope.searchMap.searchType = '';
            $scope.searchMap.searchVal = '';
        }
        //获取查询数值
        if($("input[name='searchMap.searchVal']") != undefined && $("input[name='searchMap.searchVal']").val() != null  && $("input[name='searchMap.searchVal']").val() != ''
            && $("input[name='searchMap.searchVal']").val() != '请输入待查询信息' ){
            $scope.searchMap.searchVal = $("input[name='searchMap.searchVal']").val();
        }else{
            $scope.searchMap.searchVal = '';
            $scope.searchMap.searchType = '';
        }
        productBulletinService.load( $scope.searchMap ).success(
            function(response1){
                $scope.resultMap = response1;//搜索返回的结果
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

    $scope.queryByPage = function (pageNo) {
        //页码验证
        if(pageNo < 1 || pageNo > $scope.resultMap.totalPages){
            return;
        }
        $scope.searchMap.pageNo = pageNo;
        $scope.search();
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