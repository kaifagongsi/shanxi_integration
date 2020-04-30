adminApp.service('adminPolicyService',function ($http) {

    //列表页加载
    this.load = function (searchMap) {
        return $http.post('/policypapers/getList.do',searchMap);
    }

    this.initById = function (pData) {
        return $http.post('/policypapers/getContent.do',pData);
    }

    //修改政策
    this.saveOrupdate = function(contentMap){
        return $http.post('/policypapers/saveOrupdate.do',contentMap);
    }

    //批量删除政策
    this.deleteAll = function (idList) {
        return $http.post('/policypapers/deleteAll.do',idList);
    }
});