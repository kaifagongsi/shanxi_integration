//统计控制层
tongjiApp.controller('productBulletinShowChontroller',function ($scope,$location,productBulletinShowService) {



    $scope.getProduceInfo = function () {
        var id = $location.search()['idVal'];
        console.log(id);
        productBulletinShowService.getInfo(id).success(
            function (response) {
                console.log(response);
                $scope.productInfo = response.data;
                $scope.list = response.list;
            }
        );
    };
});