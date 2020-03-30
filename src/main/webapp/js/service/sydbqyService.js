//service层
firstwebApp.service('sydbqyService',function ($http) {
    //使用地标企业页面加载
    this.load = function (searchMap) {
        return $http.post('../../sydbqy/getList.do',searchMap);
    }

});