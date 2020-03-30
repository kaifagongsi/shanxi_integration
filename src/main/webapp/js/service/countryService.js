//service层
firstwebApp.service('countryService',function ($http) {
    //分类页面加载
    /*this.loadClass = function () {
        //alert("service");
        return $http.post('../../countrydbcpzs/getlist.do');
    }*/

    //列表项加载
    this.search = function () {
        //alert("service");
        return $http.post('../../countrydbcpzs/search.do');
    }

});
