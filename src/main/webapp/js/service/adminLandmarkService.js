adminApp.service('adminLandmarkService',function ($http) {
    this.loadLandmark = function (map) {
        return $http.post('../../admin/landmarkController/getAdminLandmarkList.do',map);
    };

    //初始化省市下拉框
    this.initSelect = function () {
        return $http.get('../../admin/landmarkController/getSelectMap.do');
    };

    //根据省市获取区县
    this.getAreasCountyList = function (cityId) {
        return $http.get('../../admin/landmarkController/selectByParentId.do?id=' + cityId);
    };

    //新增
    this.saveLandmark = function (landmarkEntity) {
        return $http.post('../../admin/landmarkController/saveLandmark.do',landmarkEntity);
    }
});