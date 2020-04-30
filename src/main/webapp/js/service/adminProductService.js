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

    this.getAreasCountyList = function (cityId) {
        return $http.get('../../area/selectByParentId.do?id=' + cityId);
    }

    this.getProductByProductId = function (productId) {
        return $http.get('../../admin/productController/getProductByProductId.do?id='+productId);
    }

    this.getProductInfoByProductId = function (productId) {
        return $http.get('../../admin/productController/getProductContentByProductId.do?id='+productId);
    }

    this.deleteProduct = function (productId) {
        return $http.delete('../../admin/productController/deleteProduct.do?id='+productId);
    }
});