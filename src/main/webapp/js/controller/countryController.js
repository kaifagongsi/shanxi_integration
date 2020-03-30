//控制层
firstwebApp.controller('countryController',function ($scope,$location,countryService) {
    /*$scope.searchMap = {'pageNo': 1, 'pageSize': 20};
    $scope.resultMap = {"totalPages": "0"};*/

    $scope.resultMap = {};
    //页面加载
    $scope.search = function () {

        //alert("controller");
        countryService.search().success(
            function (response) {
                console.log(response);
                $scope.resultMap = response;//搜索返回的结果
            }
        );

    };
});