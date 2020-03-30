//统计控制层
proclamationApp.controller('proclamationController',function ($scope,$location,$window,proclamationService) {


    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':15,'ziduan':1,'type':'保护公告'};
    $scope.resultMap= {"totalPages":"0"};
    $scope.contentMap= {"content":""};

    $scope.pData = {'content':'','title':1,'id':'43','type':''};


    $scope.upload= function(){
        $scope.pData.content = CKEDITOR.instances.TextArea1.getData();
        $scope.pData.title = $("#title").val();
        $scope.pData.type = $('#fileType option:selected').val();//选中的值
        console.log($scope.pData);
        proclamationService.upload( $scope.pData ).success(
            function(response3){
                 alert("保存成功");
                 // if( $scope.pData.type == "公告"){
                 //     $window.location.href = "../../indexDetail.html?typeVal=1";
                 // }else  if( $scope.pData.type == "政策"){
                 //     $window.location.href = "http://localhost:9104/policyPapers.html";
                 // }
            }
        );
    };

    $scope.initById= function(){
        //接收index.html传参
        var idVal = "";
        if ($location.$$search.idVal) {
            $scope.pData.id = $location.$$search['idVal'];
        }
        proclamationService.initById( $scope.pData ).success(
            function(response2){
                console.log(response2);
                $scope.contentMap=response2;//搜索返回的结果
            }
        );
    };

    //三类公告页面加载
    $scope.load=function(){
        proclamationService.load( $scope.searchMap ).success(
            function(response){
                $scope.resultMap=response;//搜索返回的结果
            }
        );
    };

    //列表页加载
    $scope.search=function(){
        //接收index.html传参
        var typeVal = "";
        if ($location.search().typeVal) {
            typeVal = $location.search()['typeVal'];
        }
        if(typeVal != ""){
            if(typeVal == "1"){
                $scope.searchMap.type = '受理公告';
            }else if(typeVal == "2"){
                $scope.searchMap.type = '批准公告';
            }else if(typeVal == "3"){
                $scope.searchMap.type = '核准公告';
            }
        }
        proclamationService.search( $scope.searchMap ).success(
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