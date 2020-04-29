adminApp.service('adminProductService',function ($http) {
    this.load = function (searchMap) {
        return $http.post("../../admin/productController/getAdminProductList.do",searchMap);
    };


    this.upload = function (pData) {
        return $http.post('../../upload/save.do',pData);
    };

    this.saveProduct = function (product) {
        return $http.put('../../admin/productController/addProduct.do',product);
    }

    this.initSelect = function () {
        return $http.get('../../admin/productController/getSelectMap.do');
    }
});