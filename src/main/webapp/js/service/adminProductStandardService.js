adminApp.service('adminProductStandardService',function ($http) {

    this.loadList = function (searchMap) {
        return $http.post("../../admin/productStandardController/getList.do",searchMap);
    }

    this.initProductStandardInfoServer = function(id){
        return $http.get("../../admin/productStandardController/intiProductStandard.do?id="+id);
    }

    this.saveProductStandardServer = function (item) {
        return $http.post("../../admin/productStandardController/saveProductStandard.do",item);
    }

    this.deleteProductStandard = function (id) {
        return $http.delete("../../admin/productStandardController/deleteProductStandard.do",{params:{'id':id}});
    }
});