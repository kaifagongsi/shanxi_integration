//admin的上传excel的service
adminApp.service('adminUploadExcelService',function ($http) {

    this.saveUploadExcel = function (dataBasesType,productType) {
        /*
        * H5的类：FormData
        * */
        var formData=new FormData();
        formData.append("file",exampleInputFile.files[0]);
        formData.append("dataBasesType",dataBasesType);
        formData.append("productType",productType);
        return $http({
            method:'POST',
            url:"/admin/uploadExcel.do",
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
    }

});