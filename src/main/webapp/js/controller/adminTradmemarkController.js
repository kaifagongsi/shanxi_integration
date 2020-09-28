adminApp.controller('adminTrademarkController',function ($scope,$location,adminTrademarkServer) {

    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':10};
    $scope.resultMap = {'totalPages': '0','total':'','rows':''};
    $scope.currPageNo = 1;
    //初始化详细页面
    $scope.trademarkInfo = null;
    $scope.initTrademarkData = function() {
        if($location.$$search.id){
            adminTrademarkServer.selectOne($location.$$search.id).success(function (response) {
                console.log(response)
                $scope.trademarkInfo = response.queryResult.map.item;
            })
        }else{// 表示为新增 上面都不做

        }

    }

    //保存详细
    $scope.saveTrademark = function(){
        var parse = JSON.stringify($scope.trademarkInfo);
        console.log(parse)
        console.log(pdfFile.files[0]);
        if(pdfFile.files[0] != null){//表示上传新文件
            adminTrademarkServer.saveTrademark(parse).success(function (response) {
                if(response.code  === '10000'){
                    alert(response.message)
                }else{
                    alert("处理完成");
                    location.href="../../admin/trademark/trademarkDataList.html";
                }
            })
        }else{//仅仅保存实体，文件不替换
            adminTrademarkServer.saveEntity($scope.trademarkInfo).success(function (response) {
                if(response.code  === '10000'){
                    alert(response.message)
                }else{
                    alert("处理完成");
                    location.href="../../admin/trademark/trademarkDataList.html";
                }
            })

        }

    }


    //列表页面
    $scope.getList = function () {
        adminTrademarkServer.getList($scope.searchMap).success(function (response) {
            console.log(response);
            $scope.resultMap = response.queryResult.map;
            buildPageLabel();
        })
    }

    $scope.deleteTrademark = function(registrationNumber){
        adminTrademarkServer.deleteTrademark(registrationNumber).success(function (response) {
            if(response.code = '10000'){
                alert("删除成功");
            }else{
                alert("请稍候尝试");
            }
            location.href="../../admin/trademark/trademarkDataList.html";
        })
    }


    $scope.queryByPage = function (pageNo) {
        //页码验证
        if(pageNo < 1 || pageNo > $scope.resultMap.totalPages){
            return;
        }
        $scope.searchMap.pageNo = pageNo;
        $scope.currPageNo = pageNo;
        $scope.getList();
    };

    //绘制分页信息
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
        if($scope.resultMap.totalPages == $scope.currPageNo){
            return true;
        }else{
            return false;
        }
    };
})