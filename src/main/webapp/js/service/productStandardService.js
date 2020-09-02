//service层
standardApp.service('standardService',function ($http) {
    //使用地标企业页面加载
    this.load = function (searchMap) {
        return $http.post('../../standard/getList.do',searchMap);
    }

});