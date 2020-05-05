adminApp.service('adminEnterpriseService',function ($http) {
    this.loadEnterprise = function (map) {
        return $http.post('../../admin/enterpriseController/getEnterpriseList.do',map);
    };

    this.initSelectEnterprise = function () {
        return $http.get('../../admin/enterpriseController/initSelectEnterprise.do');
    };

    this.addEnterprise = function (entity) {
        return $http.put('../../admin/enterpriseController/addEnterprise.do',entity);
    };
});
