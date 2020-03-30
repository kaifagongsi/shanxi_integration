//统计service层
tongjiApp.service('productBulletinService',function ($http) {
    //列表页加载
    this.load = function (searchMap) {
        return $http.post('../../product/getList.do',searchMap);
    }


});