adminApp.service('adminRelatedWebsitesService',function ($http) {

    this.loadList = function (searchMap) {
        return $http.post("../../admin/relatedWebsitesController/getRelatedWebsitesList.do",searchMap);
    };

    this.saveUploadImg = function () {
        /*
        * H5的类：FormData
        * */
        var formData=new FormData();
        formData.append("file",imgFile.files[0]);
        return $http({
            method:'POST',
            url:"/admin/relatedWebsitesController/saveImg.do",
            data: formData,
            /*
            * anjularjs对于post和get请求默认的Content-Type header 是application/json。通过设置
            * ‘Content-Type’: undefined，这样浏览器会帮我们把Content-Type 设置为 multipart/form-data.
            *  通过设置 transformRequest: angular.identity ，
            *  anjularjs transformRequest function 将序列化我们的formdata object.
            * */
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        });
    };

    this.saveRelatedMode = function (model) {
        return $http.put("../../admin/relatedWebsitesController/saveRelatedModel.do",model);
    };
});