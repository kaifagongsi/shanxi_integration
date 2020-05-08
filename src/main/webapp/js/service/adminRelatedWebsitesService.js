adminApp.service('adminRelatedWebsitesService',function ($http) {

    this.loadList = function (searchMap) {
        return $http.post("../../admin/relatedWebsitesController/getRelatedWebsitesList.do",searchMap);
    }
});