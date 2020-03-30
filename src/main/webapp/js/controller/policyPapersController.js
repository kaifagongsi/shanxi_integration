//统计控制层
policyPapersapp.controller('policyPapersController',function ($scope,$location,policyPapersService) {


    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':15,'ziduan':1,'type':'国家政策'};
    $scope.resultMap= {"totalPages":"0"};
    $scope.contentMap= {"content":""};

    $scope.pData = {'content':'','title':1,'id':'43'};

    //搜索
    $scope.search=function(){
        $scope.searchMap.type = '国家政策';
        policyPapersService.search( $scope.searchMap ).success(
            function(response1){
                console.log(response1);
                $scope.resultMap = response1;//搜索返回的结果
                buildPageLabel();
            }
        );
    };

    $scope.load=function(type){
        $scope.searchMap.type = '国家政策';
        if(type != undefined && type != '' && type != null){
            $scope.searchMap.type = type;
        }
        if($scope.searchMap.type == '国家政策'){
            $("#znone").addClass("current");
            $("#zntwo").removeClass("current");
        }else if($scope.searchMap.type == '陕西省地方政策'){
            $("#zntwo").addClass("current");
            $("#znone").removeClass("current");
        }
        policyPapersService.search( $scope.searchMap ).success(
            function(response1){
                $scope.resultMap = response1;//搜索返回的结果
                buildPageLabel();
                location.href = "#firstAnchor";
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

    $scope.initById= function(){
        //接收index.html传参
        var idVal = "";
        if ($location.$$search.idVal) {
            $scope.pData.id = $location.$$search['idVal'];
        }
        policyPapersService.initById( $scope.pData ).success(
            function(response2){
                console.log(response2);
                $scope.contentMap=response2;//搜索返回的结果
            }
        );
    };
});