adminApp.controller('adminProductAndEnterpriseController',function ($scope,adminProductService,$location,adminEnterpriseService) {
    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':10};
    $scope.pageDate={ 'list' : '','totalPages':''};
    $scope.enterprisePageDate={ 'list' : '','totalPages':''};
    $scope.currPageNo = 1;
    $scope.firstDot = true;//前面有点
    $scope.lastDot = true;//后面有点
    //产品详细信息的报错
    $scope.pData = {'content':'','title':'','id':'1','type':'展示','time':''};
    //产品自己的信息
    $scope.product = {'id':0,'name':'','classificationid':'','applicantOrganization':'','preliminaryExaminationBody':'','provinceName':'','cityName':'','protectionScope':'',
                        'documentDefiningTheScopeOfProtection':'','technicalSpecifications':'','useOfSpecialSigns':'','approvalAuthorityProduct':'',
                    'approvalAnnouncementNoProduct':'','approvalAnnouncementNoProductAll':'','protectionNoticeTitle':'','administrativeArea':''};

    $scope.adminArea = null;
    $scope.noticePiZhunList = null;
    $scope.noticeShouLiList = null;
    $scope.areasCityList = null;

    $scope.areasCountyList = null;

    $scope.content = null;

    //构造用标企业信息
    $scope.enterprise = {'id':0,'enterpriseName':'','enterpriseAddress':'','city':'','administrativeId':'','productId':'','corporateRepresentative':'','uniformSocialCreditCode':'',
                         'approvalAnnouncementNoEnterpriseAll':'','approvalAnnouncementNoEnterprise':'','approvalAuthorityEnterprise':'',
                        'isFirstSubmission':''};

    //用标列表展示list
    $scope.enterpriseList= {'list':''};
    //用标企业详细所用的三个下拉框
    $scope.entAreasCityList = null;
    $scope.entAreasCountyList = null;
    $scope.productList = null;
    $scope.hezhunList = null;

    //国内产品
    $scope.countryEntity = {'id' : '','name':''};

    //用标企业实体
    /*******************************用标企业新增/更新/删除**********************************/
    $scope.enterpriseDelete = function(id){
        if(window.confirm('你确定要取消交易吗？')){
            adminEnterpriseService.deleteEnterprise(id).success(function (response) {
                if(response.code == '10000'){
                    alert(response.message);
                }
            });
        }else{

        }

    };
    $scope.initEnterprise = function (){

        initSelectEnterprise();
        if ($location.$$search.id) {
            //表示为更新
            $scope.enterprise.id = $location.$$search['id'];
            console.log($location.$$search['id']);
            adminEnterpriseService.selectById($scope.enterprise.id).success(function (response) {
                console.log(response);
                $scope.enterprise = response.queryResult.map.item;
                $scope.enterprise.approvalAnnouncementNoEnterpriseAll = parseInt(response.queryResult.map.item.approvalAnnouncementNoEnterpriseAll);
            });
        }else{
            //表示为新增
        }

    };

    $scope.addEnterprise = function () {
        adminEnterpriseService.addEnterprise($scope.enterprise).success(function (response) {
            if('10000' == response.code){
                alert(response.message);
            }else{
                alert('插入失败，请检查数据是否正常');
            }
        });
    };

    function initSelectEnterprise(){
        adminEnterpriseService.initSelectEnterprise().success(function (responose) {
            $scope.entAreasCityList = responose.queryResult.map.entAreasCityList;
            $scope.productList = responose.queryResult.map.productList;
            $scope.hezhunList = responose.queryResult.map.protectionNoticesList;
        });
    }
    /*
    * 监听市级别发生变化，进行重新获取县级别的区间
    * */
    $scope.$watch('enterprise.city',function (newValue,oldValue) {
        console.log(newValue,oldValue);
        adminProductService.getAreasCountyList(newValue).success(function (response) {
            $scope.entAreasCountyList = response.queryResult.list;
        });
    });

    /*******************************用标企业列表**********************************/
    $scope.loadEnterprise = function(){
        adminEnterpriseService.loadEnterprise($scope.searchMap).success(function (response) {
            $scope.enterpriseList.list = response.queryResult.map.enterpriseList;
           console.log(response);
            $scope.pageDate = response;
           buildPageLabel(response.queryResult.map.totalPages);
        });
    };


    /*******************************国内产品功能**********************************/
    //国内产品列表
    $scope.loadCountryList = function(){
        adminProductService.loadCountryList($scope.searchMap).success(function (response) {
            $scope.enterprisePageDate = response;
            $scope.enterprisePageDate.list = response.queryResult.map.rows;
            $scope.enterprisePageDate.totalPages = $scope.enterprisePageDate.queryResult.map.totalPages;
            buildPageLabel($scope.enterprisePageDate.queryResult.map.totalPages);
        });
    };
    //国内产品详细
    $scope.initCountryProduct = function(){
        if($scope.countryEntity.id == ''){
            $scope.countryEntity.id = $location.$$search['id'];
            //查询产品详细信息
            adminProductService.getCountryProductByProductId($scope.countryEntity.id).success(function (response) {
                $scope.countryEntity.name = response.queryResult.map.name;
                CKEDITOR.instances.TextArea1.setData(response.queryResult.map.content);
                console.log(response);
            });
        }else {

        }

    };
    $scope.deleteCountryProduct = function(countryProductId){
        if(window.confirm('你确定要取消交易吗？')){
            adminProductService.deleteCountryProduct(countryProductId).success(function (response) {
                if(response.code == '10000'){
                    alert(response.message);
                    $scope.loadCountryList();
                }
            });
        }else{
            return false;
        }
    };

    /*******************************陕西产品功能**********************************/
    //产品删除
    $scope.deleteProduct = function(productId){
        if(window.confirm('你确定要取消交易吗？')){
            adminProductService.deleteProduct(productId).success(function (response) {
                alert(response.queryResult.message);
                $scope.load();
            });
        }else{

        }

    };

    /*
    * 监听市级别发生变化，进行重新获取县级别的区间
    * */
    $scope.$watch('product.administrativeAreaProv',function (newValue,oldValue) {
        console.log(newValue,oldValue);
        adminProductService.getAreasCountyList(newValue).success(function (response) {
            $scope.areasCountyList = response.queryResult.list;
        });
    });
    //初始化下拉框
    function initSelect() {
        adminProductService.initSelect().success(function (response) {
            console.log(response);
            $scope.adminArea = response.queryResult.map.adminArea;
            $scope.noticePiZhunList = response.queryResult.map.noticePiZhunList;
            $scope.noticeShouLiList = response.queryResult.map.noticeShouLiList;
            $scope.areasCityList = response.queryResult.map.areasCityList;
           // $scope.areasCountyList = response.queryResult.map.areasCountyList;
        });
    }


    $scope.initProduct = function(){
        //接收index.html传参
        initSelect();
        if ($location.$$search.id) {
            $scope.product.id = $location.$$search['id'];
            //查询产品相关信息
            adminProductService.getProductByProductId($scope.product.id).success(function (response) {
                if('11111' ==response.code ){
                    alert('操作失败，查询异常');
                }else{
                    $scope.product = response.queryResult.map.item;
                    $scope.product.approvalAnnouncementNoProductAll = parseInt($scope.product.approvalAnnouncementNoProductAll);
                    $scope.product.protectionNoticeTitle = parseInt($scope.product.protectionNoticeTitle);
                }
            });
            //查询产品详细信息
            adminProductService.getProductInfoByProductId($scope.product.id).success(function (response) {
                CKEDITOR.instances.TextArea1.setData(response.queryResult.map.content);
                console.log(response);
            });
        }
    };

    $scope.saveProduct = function(){
        console.log($scope.product);
        adminProductService.saveProduct($scope.product).success(function (response) {
           console.log(response);
            if(response.code == '10000'){
                alert('保存产品基本信息成功');
            }else{
                alert('发送异常请稍候再试');
            }
        });
    };

    //保存产品详细
    $scope.upload= function(){
        $scope.pData.content = CKEDITOR.instances.TextArea1.getData();
        $scope.pData.title = $('#title').val();
        $scope.pData.type = $('#fileType option:selected').val();//选中的值
        /*$scope.pData.type = '展示';*/
        console.log($scope.pData);
        adminProductService.upload( $scope.pData ).success(
            function(response3){
                alert('保存成功');
            }
        );
    };




    /*******************************产品列表**********************************/

    $scope.load = function () {
        adminProductService.load($scope.searchMap).success(function (response) {
            $scope.pageDate = response;
            $scope.pageDate.list = response.queryResult.map.rows;
            $scope.pageDate.totalPages = $scope.pageDate.queryResult.map.totalPages;
            buildPageLabel($scope.pageDate.queryResult.map.totalPages);
        });
    };


    //分页
    /**
     * 总页数
     */
    function buildPageLabel ( totalPages) {
        $scope.pageLabel = [];
        let maxPageNo = totalPages;//最后页码
        let firstPage = 1;//开始页码
        let lastPage = maxPageNo;//截止页码
        $scope.firstDot = true;//前面有点
        $scope.lastDot = true;//后面有点
        if(totalPages > 5){//如果总页数大于5
            if($scope.currPageNo <= 3){//当前页数小于等于3
                lastPage = 5;
                $scope.firstDot = false;//前面没点
            }else  if($scope.currPageNo >= lastPage - 2 ){//当前页数大于等于最大页数-2
                firstPage = maxPageNo -4;//后5页
                $scope.lastDot = false;//后面没点
            }else{//显示当前页为中心的5页
                firstPage = $scope.currPageNo - 2 ;
                lastPage = $scope.currPageNo + 2 ;
            }
        }else{
            $scope.firstDot = false;//前面无点
            $scope.lastDot = false;//后面无点
        }
        //循环生成页码的标签
        for(let i = firstPage;i <=lastPage; i++){
            $scope.pageLabel.push(i);
        }
    }

    //判断当前为第一页
    $scope.isTopPage = function () {
        if($scope.currPageNo == 1){
            return true;
        }else{
            return false;
        }
    };

    //判断当前为最后一页
    $scope.isEndPage = function () {
        if($scope.pageDate.totalPages == $scope.currPageNo){
            return true;
        }else{
            return false;
        }
    };

    //刷新列表
    $scope.queryByPage = function (pageNo,type) {
        if(type == '1'){//陕西产品
            //页码验证
            if(pageNo < 1 || pageNo > $scope.pageDate.totalPages){
                return;
            }
            $scope.currPageNo = pageNo;
            $scope.searchMap.pageNo = pageNo;
            $scope.flush();
        }else if(type == '2'){//用标企业
            //页码验证
            if(pageNo < 1 || pageNo > $scope.pageDate.totalPages){
                return;
            }
            $scope.currPageNo = pageNo;
            $scope.searchMap.pageNo = pageNo;
            $scope.loadEnterprise();
        } else if(type =='3'){ // 国内产品
            //页码验证
            if(pageNo < 1 || pageNo > $scope.enterprisePageDate.totalPages){
                return;
            }
            $scope.currPageNo = pageNo;
            $scope.searchMap.pageNo = pageNo;
            $scope.loadCountryList();
        }
    };

    $scope.flush = function () {
        adminProductService.load( $scope.searchMap).success(
            function(response){
                $scope.pageDate = response;
                $scope.pageDate.list = response.queryResult.map.rows;
                buildPageLabel($scope.pageDate.queryResult.map.totalPages);
            }
        );
    };

});
