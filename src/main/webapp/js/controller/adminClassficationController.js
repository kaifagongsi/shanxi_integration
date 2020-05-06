adminApp.controller('adminClassficationController',function ($scope,$http,adminClassficationService) {

    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':15};
    $scope.resultMap= {"totalPages":"0"};
    $scope.classData={"name":'',"maxId":''}
    $scope.idList=new Array();
    //国内分类
    $scope.loadCountry = function () {
        adminClassficationService.loadCountry($scope.searchMap).success(function (response) {
            $scope.resultMap = response;//搜索返回的结果
            buildPageLabel();
            console.log(response);
        });
    }

    //陕西分类
    $scope.loadShanxi = function(){
        adminClassficationService.loadShanxi($scope.searchMap).success(function (response) {
            $scope.resultMap = response;//搜索返回的结果
            buildPageLabel();
            console.log(response);
        })
    }

    //新增国内分类
    $scope.addCountryClass = function(){

        $scope.classData.maxId = document.getElementsByName("maxId");
        //alert($scope.classData.maxId);
        $scope.classData.name = $("#className").val();
        var imageFile = $("#imageFile").val();
        if($scope.classData.name == '' || $scope.classData.name.length == 0){
            alert("请输入分类名称");
            return;
        }
        if(imageFile == '' || imageFile.length == 0){
            alert("请选择需要上传的类别图片");
            return;
        }
        if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(imageFile)){
            alert("图片类型必须是(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)\"");
            $("#imageFile").val('');
            return;
        }
        var formData = new FormData();
        formData.append("imagePath",$("#imageFile")[0].files[0]);
        formData.append("className",$("#className").val());
        formData.append("maxId",$("#maxId").val());

        return $http({
            method: 'post',
            url: '../../admin/savePic.do',
            data: formData,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        }).then(function (response) {
            alert("操作成功!");
            location.reload();
        });

        }


    //新增陕西分类
    $scope.addShanxiClass = function(){
        $scope.classData.maxId = document.getElementsByName("maxId");
        //alert($scope.classData.maxId);
        $scope.classData.name = $("#className").val();
        var imageFile = $("#imageFile").val();
        if($scope.classData.name == '' || $scope.classData.name.length == 0){
            alert("请输入分类名称");
            return;
        }
        if(imageFile == '' || imageFile.length == 0){
            alert("请选择需要上传的类别图片");
            return;
        }
        if(!/\.(?:png|jpg|bmp|gif|PNG|JPG|BMP|GIF)$/.test(imageFile)){
            alert("图片类型必须是(.png|jpg|bmp|gif|PNG|JPG|BMP|GIF)\"");
            $("#imageFile").val('');
            return;
        }
        var formData = new FormData();
        formData.append("imagePath",$("#imageFile")[0].files[0]);
        formData.append("className",$("#className").val());
        formData.append("maxId",$("#maxId").val());

        return $http({
            method: 'post',
            url: '../../admin/saveShanxiPic.do',
            data: formData,
            headers: {'Content-Type': undefined},
            transformRequest: angular.identity
        }).then(function (response) {
            alert("操作成功!");
            location.reload();
        });
    }

    //删除陕西分类
    $scope.deleteShanxiClass = function(){
        var checkboxs = document.getElementsByName('mychk');
        var rootids = $("#rootids").val();
        var list = rootids.split(",");
        var num = checkboxs.length;
        var len = 0;
        for (var i=0;i<num;i++){
            if (checkboxs[i].checked){
                if(list.indexOf(checkboxs[i].value) > -1){
                    alert("有产品的类别不能删除，请先删除产品");
                    return;
                }
                $scope.idList.push(checkboxs[i].value);
                len++;
            }
        }
        if(len<1){
            alert("请至少选择一条记录！");
            return;
        }
        if(confirm("请确认是否删除？该操作不可恢复。")){
            adminClassficationService.deleteShanxi($scope.idList).success(function (response) {
                alert("删除成功！");
                location.reload();
                console.log(response);
            })
        }
    }

    //删除国内分类
    $scope.deleteCountryClass = function(){
        var checkboxs = document.getElementsByName('mychk');
        var rootids = $("#rootids").val();
        var list = rootids.split(",");
        var num = checkboxs.length;
        var len = 0;
        for (var i=0;i<num;i++){
            if (checkboxs[i].checked){
                if(list.indexOf(checkboxs[i].value) > -1){
                    alert("有产品的类别不能删除，请先删除产品");
                    return;
                }
                $scope.idList.push(checkboxs[i].value);
                len++;
            }
        }
        if(len<1){
            alert("请至少选择一条记录！");
            return;
        }
        if(confirm("请确认是否删除？该操作不可恢复。")){
            adminClassficationService.deleteCounrty($scope.idList).success(function (response) {
                alert("删除成功！");
                location.reload();
                console.log(response);
            })
        }
    }

    buildPageLabel = function () {
        $scope.pageLabel = [];
        var maxPageNo = $scope.resultMap.totalPages;//最后页码
        var firstPage = 1;//开始页码
        var lastPage = maxPageNo;//截止页码
        $scope.firstDot = true;//前面有点
        $scope.lastDot = true;//后面有点
        if($scope.resultMap.totalPages > 5){//如果总页数大于5
            if($scope.searchMap.pageNo <= 3){//当前页数小于等于3
                lastPage = 5;
                $scope.firstDot = false;//前面没点
            }else  if($scope.searchMap.pageNo >= lastPage - 2 ){//当前页数大于等于最大页数-2
                firstPage = maxPageNo -4;//后5页
                $scope.lastDot = false;//后面没点
            }else{//显示当前页为中心的5页
                firstPage = $scope.searchMap.pageNo - 2 ;
                lastPage = $scope.searchMap.pageNo + 2 ;
            }
        }else{
            $scope.firstDot = false;//前面无点
            $scope.lastDot = false;//后面无点
        }
        //循环生成页码的标签
        for(var i = firstPage;i <=lastPage; i++){
            $scope.pageLabel.push(i);
        }
    };

    $scope.queryByPage = function (pageNo) {
        //页码验证
        if(pageNo < 1 || pageNo > $scope.resultMap.totalPages){
            return;
        }
        $scope.searchMap.pageNo = pageNo;
        $scope.search();
    };

    //判断当前为第一页
    $scope.isTopPage = function () {
        if($scope.searchMap.pageNo == 1){
            return true;
        }else{
            return false;
        }
    };

    //判断当前为最后一页
    $scope.isEndPage = function () {
        if($scope.resultMap.totalPages == $scope.searchMap.pageNo){
            return true;
        }else{
            return false;
        }
    };

})