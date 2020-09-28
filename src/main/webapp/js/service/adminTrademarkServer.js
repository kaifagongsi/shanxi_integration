adminApp.service('adminTrademarkServer',function ($http) {

    this.getList = function (searchMap) {
        return $http.post('../../admin/trademark/getList.do',searchMap);
    }

    this.selectOne = function (id) {
        return $http.get('../../admin/trademark/selectOne.do?id='+id);
    }

    this.saveEntity = function (item) {
        return $http.post('../../admin/trademark/saveEntity.do',item);
    }

    this.saveTrademark = function (item) {
        /*
        * H5的类：FormData
        * */
        var formData=new FormData();
        formData.append("file",pdfFile.files[0]);
        formData.append("item",item);
        console.log(item);
        return $http({
            method:'POST',
            url:"/admin/trademark/saveTrademark.do",
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

    this.deleteTrademark = function (registrationNumber) {
        return  $http.delete('../../admin/trademark/deleteTrademark.do',{params:{'id':registrationNumber}})
    }
})