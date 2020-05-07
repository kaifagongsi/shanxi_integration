adminApp.service('adminUserService',function ($http) {

    this.getLoginUser = function () {
        return $http.get("../../admin/userController/getLoginUser.do");
    };
    
    this.checkOldPassword = function (username,oldPassword) {
        return $http.post("../../admin/userController/checkOldPassword.do?username=" + username+"&oldPassword=" + oldPassword);
    };

    this.changePassword = function (username, newPassword) {
        return $http.post("../../admin/userController/changePassword.do?username=" + username+"&newPassword=" + newPassword);
    }
})