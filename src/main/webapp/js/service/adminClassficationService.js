adminApp.service('adminClassficationService',function ($http) {

    //国内产品分类
    this.loadCountry = function (searchMap) {
        return $http.post('../../admin/getCountryClassList.do',searchMap);
    }

    //陕西产品分类
    this.loadShanxi = function (searchMap) {
        return $http.post('../../admin/getShanxiClassList.do',searchMap);
    }
    //修改国内分类
    this.updateCountryClass = function (editClass) {
        return $http.post('../../admin/updateCountryClass.do',editClass);
    }
    //修改陕西分类
    this.updateShanxiClass = function (editClass) {
        return $http.post('../../admin/updateShanxiClass.do',editClass);
    }
    //新增国内分类
    this.addCountryClass = function () {
        return $http.post('../../admin/addCountryClass.do');
    }

    //新增陕西分类
    this.addShanxiClass = function () {
        return $http.post('../../admin/addShanxiClass.do');
    }
    
    //批量删除陕西分类类别
    this.deleteShanxi = function (idList) {
        return $http.post('../../admin/deleteShanxi.do',idList)
    }

    //批量删除国内分类类别
    this.deleteCounrty = function (idList) {
        return $http.post('../../admin/deleteCounrty.do',idList)
    }
});