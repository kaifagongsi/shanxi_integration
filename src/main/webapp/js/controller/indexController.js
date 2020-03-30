//控制层
firstwebApp.controller('indexController',function ($scope,indexService,$cookieStore,$location) {

    //加载cookie
    $scope.getCookie = function () {
        indexService.getPatviewerCookie().success(
            function (response) {
                console.log(response);
                console.log(response.session);
                var s = response.session
               // $cookies.put("AngularJs", "xcccc", {expires:new Date(new Date().getTime()+5000)})
                $cookieStore.put("JSESSIONID", s);
                var xx = $cookieStore.get("JSESSIONID");
                console.info(xx);
            }
        );
    };

  /*  content1: 电子
    colname: 申请号,公开（公告）号,申请（专利权）人,发明（设计）人,地址,名称,摘要+=
        strWhere: 申请号,公开（公告）号,申请（专利权）人,发明（设计）人,地址,名称,摘要+=(苹果)
    simpleSearch: 1
    presearchword:
        savesearchword: ON
    strChannels: 14,15,16,17
    strSources: fmsq_ft
    strSortMethod: RELEVANCE
    strDefautCols: 主权项, 名称, 摘要
    strStat:
        iHitPointType: 115
    searchKind: tableSearch
    bContinue:
        trsLastWhere:
            channelid:
                content: 苹果*/
    $scope.ceFormDate = {
        'content1':'电子',
        'colname':'申请号,公开（公告）号,申请（专利权）人,发明（设计）人,地址,名称,摘要+=',
        'strWhere':'',
        'simpleSearch':'1',
        'presearchword':'',
        'savesearchword':'ON',
        'strSources':'',
        'strChannels':'',
        'strSortMethod':'RELEVANCE',
        'strDefautCols':'主权项, 名称, 摘要',
        'strStat':'',
        'iHitPointType':'115',
        'searchKind':'tableSearch',
        'bContinue':'',
        'trsLastWhere':'',
        'channelid':'',
        'content':'',
        'searchUrl':''
    }
    $scope.area = ""
    $scope.searchUrl = ""
    $scope.search = function () {
        if($scope.ceFormDate.content.length > 5000){
            alert('超过非注册用户检索式长度，请注册或者联系管理员');
            return false;
        }
        if($scope.ceFormDate.content != null && $scope.ceFormDate.content !=''){
            if( ($scope.ceFormDate.content.indexOf(' and ') >-1 || $scope.ceFormDate.content.indexOf(' AND ') >-1)  &&
                ($scope.ceFormDate.content.indexOf(' or ') ==-1&&$scope.ceFormDate.content.indexOf(' OR ')==-1)&&
                ($scope.ceFormDate.content.indexOf(' not ') ==-1&&$scope.ceFormDate.content.indexOf(' NOT ')==-1)) {

                var reg = new RegExp(' and ','g');//g,表示全部替换。
                $scope.ceFormDate.content = $scope.ceFormDate.content.replace(reg,' ');

                var reg1 = new RegExp(' AND ','g');//g,表示全部替换。
                $scope.ceFormDate.content = $scope.ceFormDate.content.replace(reg1,' ');

                $scope.ceFormDate.strWhere = $scope.ceFormDate.colname + '(' +$scope.ceFormDate.content.replace(/\s+/g, ' and ') +')';
                // $("#strWhere").attr("value",$scope.ceFormDate.colname+"("+$.trim($scope.ceFormDate.content).replace(/\s+/g, " and ")+")");
            } else if(  ($scope.ceFormDate.content.indexOf(' and ') == -1 || $scope.ceFormDate.content.indexOf(' AND ') == -1)  &&
                ($scope.ceFormDate.content.indexOf(' or ') > -1 && $scope.ceFormDate.content.indexOf(' OR ') >-1)&&
                ($scope.ceFormDate.content.indexOf(' not ') > -1 && $scope.ceFormDate.content.indexOf(' NOT ') > -1)){

                $scope.ceFormDate.strWhere = $scope.ceFormDate.colname + '(' +$scope.ceFormDate.content +')';
            } else if( ($scope.ceFormDate.content.indexOf(' and ') > -1 || $scope.ceFormDate.content.indexOf(' AND ') > -1)  &&
                ($scope.ceFormDate.content.indexOf(' or ') > -1 && $scope.ceFormDate.content.indexOf(' OR ') >-1)&&
                ($scope.ceFormDate.content.indexOf(' not ') > -1 && $scope.ceFormDate.content.indexOf(' NOT ') > -1  )){

                $scope.ceFormDate.strWhere = $scope.ceFormDate.colname + '(' +$scope.ceFormDate.content +')';
                // $("#strWhere").attr("value",colname+"("+$.trim(content)+")");
            } else {
                $scope.ceFormDate.strWhere = $scope.ceFormDate.colname + '(' + $scope.ceFormDate.content.replace(/\s+/g,' and ') + ' ) ';
                // $("#strWhere").attr("value",colname+"("+$.trim(content).replace(/\s+/g, " and ")+")");
            }

            console.log($scope.ceFormDate);
            console.log($scope.area);
            if( $scope.are == 'cn' ){
                $scope.ceFormDate.strChannels = '14,15,16,17';
                $scope.ceFormDate.strSources = 'fmsq_ft';
                $scope.searchUrl = 'http://www.patviewer.com/pretoJsonOverView.do?simpleSearch=1&pageType=all&quickSearchEncode=UTF8';
            }else if( $scope.are == 'sb' ){
                $scope.ceFormDate.strWhere = '商标名称= '+ $scope.ceFormDate.content;
                $scope.searchUrl = 'http://www.patviewer.com/pretoJsonOverViewsb.do?wap=2&simpleSearch=1&pageType=all&quickSearchEncode=UTF8';
            }else if( $scope.are == 'dl' ){
                $scope.ceFormDate.strWhere = '产品名称=" '+ $scope.ceFormDate.content;
                $scope.searchUrl = 'http://www.patviewer.com/pretoJsonOverViewdl.do?wap=2&simpleSearch=1&pageType=all&quickSearchEncode=UTF8';
            }else {
                $scope.ceFormDate.strChannels = '18,19,20,21,22,23,24,25';
                $scope.ceFormDate.strSources = '18,19,20,21,22,23,24,25';
                $scope.searchUrl = 'http://www.patviewer.com/pretoJsonOverView.do?simpleSearch=1&pageType=all&quickSearchEncode=UTF8';
            }
            indexService.searchQuest($scope.searchUrl,$scope.ceFormDate).success(
                function (response) {
                    var url = $location.absUrl().split("angularJS_")[0]+'angularJS_newTab.html';
                    window.open(url,"_blank",response)
                    console.log(response);
                }
            );
        }else{
            return false;
        }
    }

});
