adminApp.controller('adminProductController',function ($scope,adminProductService) {
    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':15};

    $scope.load = function () {
        adminProductService.load($scope.searchMap).success(function (response) {
            console.log(response);
        });
    }

});