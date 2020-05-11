//统计service层
tongjiApp.service('statisticsService',function ($http) {

    //获取饼状图数据
    this.getPieChart= function () {
        return $http.get('../../statistics/pieChart.do');
    };

    this.getBlockShuju = function () {
        return $http.get("../../statistics/getBlock.do");
    };

    this.secondTabInit = function () {
        return $http.get("../../statistics/secondTabInit.do");
    };

    this.secondTableSearch = function (search) {
        return $http.post("../../statistics/secondTabSearch.do",search);
    };

    this.thridTabInit = function () {
        return $http.get("../../statistics/thridTabInit.do");
    };
    this.thridTableSearch = function (search) {
        return $http.post("../../statistics/thridTabSearch.do",search);
    };
    this.getSecondList = function (pageNo,search) {
        return $http.post("../../statistics/getSecondList.do?pageNo="+pageNo,search);
    };

    this.getCountNum = function () {
        return $http.get("../../statistics/getCountNum.do");
    };

});