adminApp.service('adminProductStandardService',function ($http) {

    this.loadList = function (searchMap) {
        return $http.post("../../admin/productStandardController/getList.do",searchMap);
    }

    this.initProductStandardInfoServer = function(id){
        return $http.get("../../admin/productStandardController/intiProductStandard.do?id="+id);
    }
});