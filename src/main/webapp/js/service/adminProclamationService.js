adminApp.service('adminProclamationService',function ($http) {

    //列表页加载
    this.load = function (searchMap) {
        return $http.post('/proclamation/getList.do',searchMap);
    }

    this.initById = function (pData) {
        return $http.post('/proclamation/getContent.do',pData);
    }

    //修改政策
    this.saveOrupdate = function(contentMap){
        return $http.post('/proclamation/saveOrupdate.do',contentMap);
    }

    //批量删除政策
    this.deleteAll = function (idList) {
        return $http.post('/proclamation/deleteAll.do',idList);
    }
});