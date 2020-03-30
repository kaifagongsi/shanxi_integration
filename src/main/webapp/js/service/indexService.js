//service层
firstwebApp.service('indexService',function ($http) {

    this.getPatviewerCookie = function () {
        return $http.get("../../Simulation/getCookie.do");
    }

    this.searchQuest = function (url,formDate) {
        console.log(formDate)
        return $http.post("../../Simulation/getResponseBody.do?surl=" + url, formDate);
    }
});
