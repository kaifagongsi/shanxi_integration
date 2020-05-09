//控制层
adminApp.controller('adminUploadExcelController',function ($scope,$location,adminUploadExcelService) {

    $scope.dataBasesType = "1";

    $scope.productType = "1";

    $scope.saveExcel = function () {
        adminUploadExcelService.saveUploadExcel($scope.dataBasesType,$scope.productType).success(function (response) {
            if(response.code == '10000'){
                alert(response.message);
            }else{
                alert("插入失败");
            }
        });
    }
});