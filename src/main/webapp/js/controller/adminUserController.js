//控制层
adminApp.controller('adminUserController',function ($scope,$location,adminUserService) {

    $scope.user = "";

    $scope.oldPassword = "";
    $scope.newPassword = "";
    $scope.focusoldPassword = false;
    $scope.oldPasswordFlag = false;

    $scope.getUser = function () {
        adminUserService.getLoginUser().success(function (response) {
            $scope.user = response.queryResult.map.user;
        });
    };
    $scope.savePassword = function () {
        if($scope.oldPassword != "" && $scope.oldPasswordFlag == false && $scope.newPassword !=""){
            console.log($scope.oldPassword + $scope.newPassword);
            adminUserService.changePassword($scope.user,$scope.newPassword).success(function (response) {
                console.log(response);
                alert(response.message);
            });
        }else{
            alert("请确认原始密码正确");
        }
        $scope.oldPassword = "";
        $scope.newPassword = "";
    };

    $scope.checkOldPassword = function () {
        adminUserService.checkOldPassword($scope.user,$scope.oldPassword ).success(function (response) {
            $scope.oldPasswordFlag = !response.queryResult.map.oldPasswordFlag;
        });
    }
});