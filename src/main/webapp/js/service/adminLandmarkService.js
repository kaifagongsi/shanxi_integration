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
        return $http.get('../../admin/landmarkController/selectByParentId.do?id='+cityId);
    };

    //根据行业获取分类
    this.getTypeList = function (industryName) {
        return $http.get('../../admin/landmarkController/selectByIndustry.do?name='+encodeURI(encodeURI(industryName)));
    }

    //新增
    this.saveLandmark = function (landmarkEntity) {
        return $http.post('../../admin/landmarkController/saveLandmark.do',landmarkEntity);
    }

    //编辑
    this.initByProductNumber = function (pData) {
        return $http.post('../../admin/landmarkController/initByProductNumber.do',pData);
    }

    //删除
    this.landmarkDelete = function (productNumber) {
        return  $http.delete('../../admin/landmarkController/deleteLandmark.do',{params:{'productNumber':productNumber}});
    }
});