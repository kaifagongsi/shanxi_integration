//service层
trademarkApp.service('geographicalIndicationTrademarkService',function ($http) {
    //分类页面加载
    /*this.loadClass = function () {
        //alert("service");
        return $http.post('../../countrydbcpzs/getlist.do');
    }*/

    //列表项加载
    this.search = function (item) {
        return $http.post('../../trademark/search.do',item);
    }

});
