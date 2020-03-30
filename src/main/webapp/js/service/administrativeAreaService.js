//统计service层
tongjiApp.service('administrativeAreaService',function ($http) {

    //获取饼状图数据
    this.selectAll= function () {
        return $http.get('../../area/selectAll.do');
    }

    this.selectByParentId = function (parentId) {
        return $http.get("../../statistics/selectByParentId.do?id="+parentId);
    }
});