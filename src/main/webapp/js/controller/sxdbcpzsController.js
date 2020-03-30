//控制层
firstwebApp.controller('sxdbcpzsController',function ($scope,$location,sxdbcpzsService) {
    /*$scope.searchMap = {'pageNo': 1, 'pageSize': 20};
    $scope.resultMap = {"totalPages": "0"};*/

    $scope.resultMap = {};
    //页面加载
    $scope.search = function () {
        $(".cplist").mCustomScrollbar("destroy");
        //alert("controller");
        sxdbcpzsService.search().success(
            function (response) {
                console.log(response);
                $scope.resultMap = response;//搜索返回的结果
                $(".cplist").mCustomScrollbar({
                    theme:"dark-thick",
                    mouseWheel:true,
                    scrollButtons:{
                        enable:true
                    },
                    advanced:{
                        updateOnContentResize:true
                    }
                });
                $(".cplist").mCustomScrollbar("update");
            }
        );

    };


});