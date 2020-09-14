//service层
landmarkApp.service('landmarkService',function ($http) {
    //使用地标企业页面加载
    this.load = function (searchMap) {
        return $http.post('../../landmark/getList.do',searchMap);
    }

    /*this.getIndustryAndType = function () {
        return $http.get('../../landmark/getIndustryAndType.do');
    }*/

    //获取行政区间
    this.getShanxiMap = function () {
        return $http.get('../../landmark/getShanxiMap.do');
    }
});