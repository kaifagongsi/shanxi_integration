adminApp.controller('adminComplaintController',function ($scope,$http,adminComplaintService) {
    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':15,'searchType':'','searchVal':''};
    $scope.resultMap= {"totalPages":"0"};
    $scope.pData = {"complaintId":'',"handlingInfo":'',"complaintDetail":''};
    $scope.idList = new Array();
    $scope.downData = {"path":''};

    $scope.load = function () {
        adminComplaintService.load($scope.searchMap).success(function (response) {
            $scope.resultMap = response;//搜索返回的结果
            var all = document.getElementById("all");
            buildPageLabel();
            /*console.log(response);*/
        });
    }

    chk = function(){
        var all = document.getElementById("all");
        var mychk = document.getElementsByName("mychk");
        //alert("mychk长度=="+mychk.length);
        if(all.checked==true){
            //alert("all.checked==true全选");
            if(mychk.length){
                for(var i=0;i<mychk.length;i++){
                    mychk[i].checked = true;
                }

            }
            //mychk.chcked=true;
        }else{
            //alert("all.checked==false全不选");
            if(mychk.length){
                for(var i=0;i<mychk.length;i++){
                    mychk[i].checked = false;
                }

            }
        }
    }

    $scope.loadTodo = function () {
        adminComplaintService.loadTodo($scope.searchMap).success(function (response) {
            $scope.resultMap = response;//搜索返回的结果
            buildPageLabel();
            /*console.log(response);*/
        });
    }

    //根据关键词查询
    $scope.search = function (){
        //获取查询关键字
        if($("#searchType") != undefined && $("#searchType").val() != null && $("#searchType").val() != ''){
            $scope.searchMap.searchType = $("#searchType").val();
        }else{
            $scope.searchMap.searchType = '';
            $scope.searchMap.searchVal = '';
        }
        //获取查询数值
        if($("input[name='searchMap.searchVal']") != undefined && $("input[name='searchMap.searchVal']").val() != null  && $("input[name='searchMap.searchVal']").val() != ''
            && $("input[name='searchMap.searchVal']").val() != '请输入查询关键词' ){
            $scope.searchMap.searchVal = $("input[name='searchMap.searchVal']").val();
        }else{
            $scope.searchMap.searchVal = '';
            $scope.searchMap.searchType = '';
        }
        adminComplaintService.load($scope.searchMap).success(function (response) {
            $scope.resultMap = response;//搜索返回的结果
            buildPageLabel();
            /*console.log(response);*/
        });

    }
    $scope.searchTodo = function(){
        //获取查询关键字
        if($("#searchType") != undefined && $("#searchType").val() != null && $("#searchType").val() != ''){
            $scope.searchMap.searchType = $("#searchType").val();
        }else{
            $scope.searchMap.searchType = '';
            $scope.searchMap.searchVal = '';
        }
        //获取查询数值
        if($("input[name='searchMap.searchVal']") != undefined && $("input[name='searchMap.searchVal']").val() != null  && $("input[name='searchMap.searchVal']").val() != ''
            && $("input[name='searchMap.searchVal']").val() != '请输入查询关键词' ){
            $scope.searchMap.searchVal = $("input[name='searchMap.searchVal']").val();
        }else{
            $scope.searchMap.searchVal = '';
            $scope.searchMap.searchType = '';
        }
        adminComplaintService.loadTodo($scope.searchMap).success(function (response) {
            $scope.resultMap = response;//搜索返回的结果
            buildPageLabel();
            /*console.log(response);*/
        });
    }

    //新增保存维权处理情况
    $scope.handlingInsert = function(){
        $scope.pData.complaintId = $("#complaintId").val();
        $scope.pData.complaintDetail = $("#complaintDetail").val();
        //alert($scope.pData.complaintId);
        $scope.pData.handlingInfo = $("#handlingSituation").val();

        adminComplaintService.insertHandling($scope.pData).success(function (response) {
            alert("保存成功！");
            location.reload();
            /*console.log(response);*/
        })
    }

    //维权处理情况修改
    $scope.handlingUpdate = function(){
        $scope.pData.complaintId = $("#complaintId").val();
        $scope.pData.complaintDetail = $("#complaintDetail").val();
        //alert($scope.pData.complaintId);
        $scope.pData.handlingInfo = $("#handlingSituation").val();
        if(confirm("该操作不可撤销，是否确认更改当前维权处理信息?")) {
            adminComplaintService.updateHandling($scope.pData).success(function (response) {
                alert("更新成功！");
                location.reload();
                /*console.log(response);*/
            })
        }
    }

    //展示维权
    $scope.showHandling = function(){
        var checkboxs = document.getElementsByName('mychk');
        var num = checkboxs.length;
        //alert(num);
        var len = 0;
        for (var i=0;i<num;i++){
            if (checkboxs[i].checked){
                $scope.idList.push(checkboxs[i].value);
                len++;
            }
        }
        //alert($scope.idList.length);
        if(len<1){
            alert("请至少选择一条记录！");
            return;
        }
        if(confirm("选中的记录将对公众展示，请确认")){

            adminComplaintService.showHandling($scope.idList).success(function (response) {
                alert("操作成功！");
                location.reload();
                /*console.log(response);*/
            })
        }
    }

    //删除维权
    $scope.deleteAll = function(){
        var checkboxs = document.getElementsByName('mychk');
        var num = checkboxs.length;
        //alert(num);
        var len = 0;
        for (var i=0;i<num;i++){
            if (checkboxs[i].checked){
                $scope.idList.push(checkboxs[i].value);
                len++;
            }
        }
        //alert($scope.idList.length);
        if(len<1){
            alert("请至少选择一条记录！");
            return;
        }
        if(confirm("请确认是否删除？该操作不可恢复。")){

            adminComplaintService.deleteAll($scope.idList).success(function (response) {
                alert("删除成功！");
                location.reload();
                /*console.log(response);*/
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

    $scope.queryFinishByPage = function (pageNo) {
        //页码验证
        if(pageNo < 1 || pageNo > $scope.resultMap.totalPages){
            return;
        }
        $scope.searchMap.pageNo = pageNo;
        $scope.load();
    };

    $scope.queryTodoByPage = function (pageNo) {
        //页码验证
        if(pageNo < 1 || pageNo > $scope.resultMap.totalPages){
            return;
        }
        $scope.searchMap.pageNo = pageNo;
        $scope.loadTodo();
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