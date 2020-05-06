adminApp.controller('adminPolicyController',function ($scope,$location,adminPolicyService) {
    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':15};
    $scope.searchData = {'content':'','title':'','id':''};
    $scope.contentMap= {"content":"",'title':'','id':'','createTime':'','typeVal':''};
    $scope.resultMap= {"totalPages":"0"};
    $scope.idList = new Array();


    //列表页加载
    $scope.load=function(){
        adminPolicyService.load( $scope.searchMap ).success(
            function(response1){
                $scope.resultMap = response1;//搜索返回的结果
                buildPageLabel();
            }
        );
    };

    $scope.search=function(){
        adminPolicyService.load( $scope.searchMap ).success(
            function(response1){
                $scope.resultMap = response1;//搜索返回的结果
                buildPageLabel();
            }
        );
    };

   //查看详情
    $scope.initById= function(){
        //接收index.html传参
        var idVal = "";
        if ($location.$$search.idVal) {
            $scope.searchData.id = $location.$$search['idVal'];
        }
        adminPolicyService.initById( $scope.searchData ).success(
            function(response2){
                console.log(response2);
                $scope.contentMap=response2;//搜索返回的结果
            }
        );
    };

    //新增编辑政策
    $scope.saveOrupdate= function(){
        $scope.contentMap.content = CKEDITOR.instances.TextArea1.getData();
        $scope.contentMap.id = $("#policyId").val();
        $scope.contentMap.title = $("#title").val();
        $scope.contentMap.typeVal = $("#typeVal").val();
        $scope.contentMap.createTime = $("#createTime").val();

        adminPolicyService.saveOrupdate( $scope.contentMap ).success(
            function(response2){
                alert("保存成功！");
                location.href="../../admin/policy/policyList.html";
            }
        );
    };

    //删除政策
    $scope.deleteAll = function(){
        var checkboxs = document.getElementsByName('mychk');
        var num = checkboxs.length;
        var len = 0;
        for (var i=0;i<num;i++){
            if (checkboxs[i].checked){
                $scope.idList.push(checkboxs[i].value);
                len++;
            }
        }
        if(len<1){
            alert("请至少选择一条记录！");
            return;
        }
        if(confirm("请确认是否删除？该操作不可恢复。")){
            adminPolicyService.deleteAll($scope.idList).success(function (response) {
                alert("删除成功！");
                location.reload();
            })
        }
    }

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