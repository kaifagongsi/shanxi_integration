//控制层
adminApp.controller('adminUploadExcelController',function ($scope,$location,adminUploadExcelService) {

    $scope.dataBasesType = "1";

    $scope.productType = "1";

    $scope.saveExcel = function () {
        console.log("adminController");
        adminUploadExcelService.saveUploadExcel($scope.dataBasesType,$scope.productType).success(function (response) {
            console.log(response);
        });
    }
});