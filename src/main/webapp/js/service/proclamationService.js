//统计service层
proclamationApp.service('proclamationService',function ($http) {
    //三类公告页面加载
    this.load = function (searchMap) {
        return $http.post('proclamation/search.do',searchMap);
    }
    //列表页加载
    this.search = function (searchMap) {
        return $http.post('proclamation/getList.do',searchMap);
    }

    this.upload = function (pData) {
        return $http.post('proclamation/save.do',pData);
    }

    this.initById = function (pData) {
        return $http.post('proclamation/getContent.do',pData);
    }

});