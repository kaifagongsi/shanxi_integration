//统计控制层
tongjiApp.controller('statisticsController',function ($scope,statisticsService) {

  //  $scope.text111 = "0800加工视屏类";
    $scope.search = {"area":"","approvalYear":"","classification":""};
    $scope.searchEnt = {"area":"","approvalYear":"","classification":""};
    $scope.resultMap = {"queryResult":{"map":{"rows":"","totalPages":"","total":"","histogramList_area":"","histogramList_count":"","pieArea_area":"","pieArea_name_key":"","lineChar":"","lineCharDate":""}}};
    $scope.records = [];
    $scope.currPageNo = 1;
    $scope.firstDot = true;//前面有点
    $scope.lastDot = true;//后面有点
    $scope.approvalYear = null;
    $scope.classification = null;
    $scope.approvalYearEnt = null;
    $scope.classificationEnt = null;
    var charts = [];
    var chart1 = echarts.init(document.getElementById("pieChart"));
    var chart2 = echarts.init(document.getElementById("Histogram"));
    var chart3 = echarts.init(document.getElementById("pieArea"));
    var chart4 = echarts.init(document.getElementById("lineChartByYear"));
    var chart5 = echarts.init(document.getElementById("HistogramEnt"));
    var chart6 = echarts.init(document.getElementById("pieAreaEnt"));
    var chart7 = echarts.init(document.getElementById("lineChartByYearEnt"));
    var pieChartOption = null;
    var optionHistogram = null;



    $scope.productNum =null;
    $scope.enterprise =null;
    $scope.getCountNum = function(){
        statisticsService.getCountNum().success(function (response) {
            console.log(response);
            $scope.productNum = response.queryResult.map.productNum;
            $scope.enterprise = response.queryResult.map.entNum;
        });
    };






    $scope.getPieChart = function () {
        statisticsService.getPieChart().success(
            function (response) {
                var data = [
                    {name:'省级',value:response.queryResult.map.pov.length},
                    {name:'地市级',value:response.queryResult.map.city.length},
                    {name:'区县级',value:response.queryResult.map.country.length}
                    ];
                pieChartOption = showPieChart(data)
                chart1.setOption(pieChartOption);
            }
        );
    };

    //获取方块数据
    $scope.getBlock = function(){
        /*  方块图数据  */
        statisticsService.getBlockShuju().success(
            function (response) {
                var fangkuaiOption = response.queryResult.map;
                showBlock(fangkuaiOption);
            }
        );
    };

    //获取柱状图横线
    $scope.getOptionHistogram = function(xdata,ydata,charts){
        showHistogram(xdata,ydata,charts);
       // var optionHistogram =
       // chart2.setOption(optionHistogram);
    };

    //获取面积的饼状图
    $scope.getPieArea = function(xdata,ydata,charts){
        showPieArea(xdata,ydata,charts);
        /*var pieAreaOption =
        chart3.setOption(pieAreaOption);*/
    };
    //获取折线图
    $scope.getLineChartByYearOption = function(xdata,ydata,charts){
        getLineChartByYearOption(xdata,ydata,charts);
        /*var lineChartByYearOption =
        chart4.setOption(lineChartByYearOption);*/
    };


    $scope.getHistogramEnt = function(xdata,ydata,charts){
        /*  横线柱状图  */
        if(xdata == 0 || xdata ==null || xdata == '' ||  ydata ==0 || ydata==null || ydata == ''){
            $("#HistogramEnt").html('<div id="chart3-nodata" style="text-align: center;font-weight: bold;line-height: 140px">暂无数据</div>');
            $('#HistogramEnt').removeAttr('_echarts_instance_');
        }else{
            showHistogramEnt(xdata,ydata,charts);
        }
    };

    $scope.getPieAreaEnt = function(xdata,ydata,charts){
        if(xdata == 0 || xdata ==null || xdata == '' ){
            $("#pieAreaEnt").html('<div id="chart3-nodata" style="text-align: center;font-weight: bold;line-height: 140px">暂无数据</div>');
            $('#pieAreaEnt').removeAttr('_echarts_instance_');
        }else{
            showPieAreaEnt(xdata,ydata,charts);
        }
    };

    $scope.getLineChartByYearEnt = function(xdata,ydata,charts){
        if( xdata == 0 || xdata ==null || xdata == '' ){
            $("#lineChartByYearEnt").html('<div id="chart3-nodata" style="text-align: center;font-weight: bold;line-height: 140px">暂无数据</div>');
            $('#lineChartByYearEnt').removeAttr('_echarts_instance_');
        }else{
            getLineChartByYearEnt(xdata,ydata,charts);
        }
        /*var lineChartByYearOptionEnt =
        chart7.setOption(lineChartByYearOptionEnt);*/
    }

     charts.push(chart1);
     charts.push(chart2);
     charts.push(chart3);
     charts.push(chart4);
     charts.push(chart5);
     charts.push(chart6);
     charts.push(chart7);
    //tab切换后加载指定的图标
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        if(e.target.innerHTML=="地标产品统计"){
            statisticsService.secondTabInit().success(
                function (response) {
                    //初始化select
                    init_ztree(response.queryResult.map.select);
                    //初始化年度
                    $scope.approvalYear = response.queryResult.map.approvalYear;
                    //初始化产品分类
                    $scope.classification = response.queryResult.map.classifications;
                }
            ).then(
                $scope.secondTableSearchController()
            );
            charts[1].resize();
            charts[2].resize();
            charts[3].resize();
        }else if(e.target.innerHTML=="用标企业统计"){
            statisticsService.thridTabInit().success(
                function (response) {
                    //初始化select
                    init_ztreeEnt(response.queryResult.map.select);
                    //初始化年度
                    $scope.approvalYearEnt = response.queryResult.map.approvalYear;
                    //初始化产品分类
                    $scope.classificationEnt = response.queryResult.map.classifications;
                }
            ).then(
                $scope.thridTableSearchController()
            );
            charts[4].resize();
            charts[5].resize();
            charts[6].resize();
        }
    });

    //监听 批准年度 选中的变化
    $scope.$watch('search.approvalYear',function (newValue,oldValue) {
         if($scope.search.approvalYear == null){
            $scope.search.approvalYear = '全部';
         }
         if(  $scope.search.approvalYear!='' ){
             $scope.secondTableSearchController();
         }
    });
    //监听分类 选中的变化
    $scope.$watch('search.classification',function (newValue,oldValue) {
        if($scope.search.classification == null){
            $scope.search.classification = '全部';
        }
        if(  $scope.search.classification!='' ){
            $scope.secondTableSearchController();
        }
    });
    //行政区域 选中的变化
    $scope.$watch('search.area',function (newValue,oldValue) {
        if(  $scope.search.area!=''  ){
            $scope.secondTableSearchController();
        }
    });

    $scope.secondTableSearchController = function () {
        statisticsService.secondTableSearch($scope.search).success(
            function (response) {
                console.log(response);
                $scope.records = response.queryResult.map.rows;
                $scope.resultMap = response;
                if($scope.records == 0 || $scope.records ==null || $scope.records == '' ){
                    //document.getElementById("Histogram").html('<div id="chart3-nodata" style="text-align: center;font-weight: bold;line-height: 140px">暂无数据</div>');
                    $("#Histogram").html('<div id="chart3-nodata" style="text-align: center;font-weight: bold;line-height: 140px">暂无数据</div>');
                    $('#Histogram').removeAttr('_echarts_instance_');
                    $("#pieArea").html('<div id="chart3-nodata" style="text-align: center;font-weight: bold;line-height: 140px">暂无数据</div>');
                    $('#pieArea').removeAttr('_echarts_instance_');
                    $("#lineChartByYear").html('<div id="chart3-nodata" style="text-align: center;font-weight: bold;line-height: 140px">暂无数据</div>');
                    $('#lineChartByYear').removeAttr('_echarts_instance_');
                }else{
                    //刷新图表
                    $scope.getOptionHistogram(response.queryResult.map.histogramList_area,response.queryResult.map.histogramList_count,charts);
                    $scope.getPieArea(response.queryResult.map.pieArea_area,response.queryResult.map.pieArea_name_key,charts);
                    $scope.getLineChartByYearOption(response.queryResult.map.lineChar,response.queryResult.map.lineCharDate,charts);
                    //$scope.records = response.queryResult.map.rows;
                }
                buildPageLabel();
            }
        );
    }
    
    $scope.thridTableSearchController = function () {
        statisticsService.thridTableSearch($scope.searchEnt).success(
            function (response) {
                $scope.getHistogramEnt(response.queryResult.map.histogramListEnt_area,response.queryResult.map.histogramListEnt_count,charts);
                $scope.getPieAreaEnt(response.queryResult.map.pirAreaxdata,response.queryResult.map.pirAreaydata,charts);
                $scope.getLineChartByYearEnt(response.queryResult.map.lineCharEnt,response.queryResult.map.lineCharDateEnt,charts);
            }
        );
    }
    //监听 企业批准年度 选中的变化
    $scope.$watch('searchEnt.approvalYear',function (newValue,oldValue) {
        if($scope.searchEnt.approvalYear == null){
            $scope.searchEnt.approvalYear = '全部';
        }
        if(  $scope.searchEnt.approvalYear != ""   ){
            $scope.thridTableSearchController()
        }

    });
    //监听分类 选中的变化
    $scope.$watch('searchEnt.classification',function (newValue,oldValue) {
        if($scope.searchEnt.classification == null){
            $scope.searchEnt.classification = '全部';
        }
        if(  $scope.searchEnt.classification != ""  ){
            $scope.thridTableSearchController()
        }
    });
    //行政区域 选中的变化
    $scope.$watch('searchEnt.area',function (newValue,oldValue) {
        if(  newValue != "" ){
            $scope.thridTableSearchController()
        }
    });

    //分页
    buildPageLabel = function () {
        $scope.pageLabel = [];
        var maxPageNo = $scope.resultMap.queryResult.map.totalPages;//最后页码
        var firstPage = 1;//开始页码
        var lastPage = maxPageNo;//截止页码
        $scope.firstDot = true;//前面有点
        $scope.lastDot = true;//后面有点
        if($scope.resultMap.totalPages > 5){//如果总页数大于5
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
        for(var i = firstPage;i <=lastPage; i++){
            $scope.pageLabel.push(i);
        }
    };

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
        if($scope.resultMap.totalPages == $scope.currPageNo){
            return true;
        }else{
            return false;
        }
    };
    
    //刷新列表
    $scope.queryByPage = function (pageNo) {
        //页码验证
        if(pageNo < 1 || pageNo > $scope.resultMap.totalPages){
            return;
        }
        $scope.currPageNo = pageNo;
        $scope.flush();
    };

    $scope.flush = function () {

        var currPageNum = parseInt($scope.currPageNo);
        statisticsService.getSecondList(currPageNum,$scope.search ).success(
            function(response){
                $scope.resultMap=response;//搜索返回的结果
                $scope.records = response.queryResult.map.rows;
                buildPageLabel();
            }
        );
    }

});