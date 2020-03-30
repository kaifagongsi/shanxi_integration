//统计service层
firstwebApp.service('uploadFileService',function ($http) {

    this.upload = function (pData) {
        return $http.post('../../upload/save.do',pData);
    }

    this.initById = function (pData) {
        return $http.post('../../upload/getContent.do',pData);
    }

    this.insert = function (pData) {
        return $http.post('../../upload/insert.do',pData);
    }

});