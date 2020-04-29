adminApp.service('adminClassficationService',function ($http) {
    //国内产品分类
    this.loadCountry = function (searchMap) {
        return $http.post('../../admin/getComplaintFinishList.do',searchMap);
    }

    //陕西产品分类
    this.loadShanxi = function (searchMap) {
        return $http.post('../../admin/getComplaintTodoList.do',searchMap);
    }

});