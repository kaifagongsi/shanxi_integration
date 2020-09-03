//统计service层
standardApp.service('productStandardShowService',function ($http) {

    //列表页加载
    this.getInfo = function (standardName) {
        return $http.get('../../standard/getStandardInfo.do?standardName='+standardName);
    };
});