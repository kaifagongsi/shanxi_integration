//控制层
adminApp.controller('adminController',function ($scope,$location,adminService) {

    $scope.dataBasesType = "1";

    $scope.productType = "1";

    $scope.saveExcel = function () {
        console.log("adminController");
        adminService.saveUploadExcel($scope.dataBasesType,$scope.productType).success(function (response) {
            console.log(response);
        });
    }
});