//统计控制层
standardApp.controller('productStandardShowController',function ($scope,$location,productStandardShowService) {

    $scope.getStandardInfo = function () {
        var name = $location.search()['nameVal'];
        console.log(name);
        productStandardShowService.getInfo(name).success(
            function (response) {
                console.log(response);
                $scope.standardInfo = response.data;
                //$scope.list = response.list;
            }
        );
    };
});