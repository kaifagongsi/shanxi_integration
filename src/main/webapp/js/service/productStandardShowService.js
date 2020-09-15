//统计service层
standardApp.service('productStandardShowService',function ($http) {

    //列表页加载
    this.getInfo = function (standardNumber) {
        return $http.get('../../standard/getStandardInfo.do?standardNumber='+standardNumber);
    };
});