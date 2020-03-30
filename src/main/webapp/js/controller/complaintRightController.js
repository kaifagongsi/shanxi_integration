

//统计控制层
firstwebApp.controller('complaintRightController',function ($scope,$http,$location,$window,complaintRightService) {


    $scope.searchMap = {'keywords':'','pageNo':1,'pageSize':15};
    $scope.resultMap= {"totalPages":"0"};
    $scope.pData = {'object':'','detail':'','money':'','state':'0','time':'','complainant':'','contact':'','filepath':''};

    //列表页加载
    $scope.load=function(){
        complaintRightService.load( $scope.searchMap ).success(
            function(response1){
                $scope.resultMap = response1;//搜索返回的结果
                buildPageLabel();
            }
        );
    };

    String.prototype.Trim = function() {
        var m = this.match(/^\s*(\S+(\s+\S+)*)\s*$/);
        return (m == null) ? "" : m[1];
    }

    String.prototype.isMobile = function() {
        return (/^(?:13\d|15[89])-?\d{5}(\d{3}|\*{3})$/.test(this.Trim()));
    }

    String.prototype.isTel = function()
    {
        //"兼容格式: 国家代码(2到3位)-区号(2到3位)-电话号码(7到8位)-分机号(3位)"
        //return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/.test(this.Trim()));
        return (/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/.test(this.Trim()));
    }

    //投诉提交
    $scope.uploadfile=function(){
        $scope.pData.detail = $("#detail").val();
        $scope.pData.object = $("#object").val();
        $scope.pData.money = $("#money").val();
        $scope.pData.complainant = $("#complainant").val();
        $scope.pData.contact = $("#contact").val();

        //$scope.pData.filepath = "E:\\Projects\\shanxi\\shanxi-firstweb-web\\target\\classes\\static\\file\\";

        if($scope.pData.object == null) {
            alert("投诉对象不可为空！");
        }else if($scope.pData.detail == null) {
            alert("投诉详情不可为空！");
        }else if($scope.pData.money == null) {
            alert("投诉金额不可为空！");
        }else if($scope.pData.complainant == null) {
            alert("投诉人不可为空！");
        }else if(!($scope.pData.contact.isMobile() || $scope.pData.contact.isTel())){
            alert("请输入正确的手机号码或电话号码\n\n例如:13916752109或0712-3614072");
        }else {

            //获取表单
            var formData = new FormData(document.getElementById("rights_info"));
            //获取文件
            var file = document.getElementById("file").files[0];

            if (file != null) {
                $scope.pData.filepath = "E:\\Projects\\shanxi\\shanxi-firstweb-web\\target\\classes\\static\\file\\";
                var filename = file.name;
                $scope.pData.filepath += filename
                formData.append("file", file);
            }

            return $http({
                method: 'post',
                url: '../../upload/savefile.do',
                data: formData,
                headers: {'Content-Type': undefined},
                transformRequest: angular.identity
            }).then(function (response) {
                //alert(response);
                complaintRightService.uploadfile($scope.pData).success(
                    alert("提交成功！")
                )
            });
        }
    }


    //搜索
    $scope.search=function(){
        complaintRightService.load( $scope.searchMap ).success(
            function(response1){
                $scope.resultMap = response1;//搜索返回的结果
                buildPageLabel();
            }
        );
    };

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

    //tab切换后加载指定的图标
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        if(e.target.innerHTML=="我要投诉"){
            // $("#tab-allState").addClass("current");
            // $("#tab-product").removeClass("current");
        }else if(e.target.innerHTML=="案件处理情况"){
            $scope.load();
        }
    });


});