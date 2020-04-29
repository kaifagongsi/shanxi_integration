adminApp.service('adminComplaintService',function ($http) {
    //已处理列表页加载
    this.load = function (searchMap) {
        return $http.post('../../admin/getComplaintFinishList.do',searchMap);
    }

    //未处理列表页加载
    this.loadTodo = function (searchMap) {
        return $http.post('../../admin/getComplaintTodoList.do',searchMap);
    }

    //修改维权处理情况
    this.updateHandling = function(pData){
        return $http.post('../../admin/updateHandling.do',pData);
    }

    //新增维权处理情况
    this.insertHandling = function (pData){
        return $http.post('../../admin/insertHandling.do',pData);
    }

    //展示维权信息
    this.showHandling = function (showIdList) {
        return $http.post('../../admin/showHandling.do',showIdList);
    }
    //批量删除维权
    this.deleteAll = function (idList) {
        return $http.post('../../admin/deleteAll.do',idList);
    }


});