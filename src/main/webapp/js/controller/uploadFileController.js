//统计控制层
firstwebApp.controller('uploadFileController',function ($scope,$location,$window,uploadFileService) {


    /*$scope.searchMap = {'keywords':'','pageNo':1,'pageSize':15,'ziduan':1,'type':'保护公告'};
    $scope.resultMap= {"totalPages":"0"};
    $scope.contentMap= {"content":""};*/

    $scope.contentMap= {"content":""};
    $scope.pData = {'content':'','title':'','id':'1','type':'展示','time':''};

    /*$scope.insert = function(){
        $scope.pData.content = CKEDITOR.instances.TextArea1.getData();
        $scope.pData.title = $("#title").val();
        $scope.pData.type = $('#fileType option:selected').val();//选中的值
        $scope.pData.time = date();
        console.log($scope.pData);
        uploadFileService.insert($scope.pData).success(
            function (response1) {
                alert("保存成功");
            }
        )
    }*/

    $scope.upload= function(){
        $scope.pData.content = CKEDITOR.instances.TextArea1.getData();
        $scope.pData.title = $("#title").val();
        $scope.pData.type = $('#fileType option:selected').val();//选中的值
        /*$scope.pData.type = '展示';*/
        console.log($scope.pData);
        uploadFileService.upload( $scope.pData ).success(
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
        var titleVal = "";
        if ($location.$$search.idVal) {
            $scope.pData.id = $location.$$search['idVal'];
        }
        if($location.$$search.titleVal){
            $scope.pData.title = $location.$$search['titleVal'];
        }
        uploadFileService.initById( $scope.pData ).success(

            function(response2){
                console.log(response2);
                $scope.contentMap=response2;//搜索返回的结果
                $scope.list = response2.list;
                if( $scope.list == '' ){
                    $scope.isShow = false;// 表示没有相关企业
                }else{
                    $scope.isShow = true;//表示有相关企业或网站
                }
                $scope.websites = response2.list.websites;
                $scope.enter = response2.list.enter;
            }
        );
    };



});