function showHistogramEnt( xdata,ydata) {

    var optionHistogramEnt   = {
        title: {
            text: '陕西省地标产品专用标志使用地域统计',
            left: 'center',
            textStyle:{
                //文字颜色
                //color:'#ccc',
                //字体风格,'normal','italic','oblique'
                //fontStyle:'normal',
                //字体粗细 'normal','bold','bolder','lighter',100 | 200 | 300 | 400...
                fontWeight:'normal',
                //字体系列
                //fontFamily:'sans-serif',
                //字体大小
                //fontSize:18
            }

        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: '数量'
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
           // name:'专用标志使用企业数量',
            type: 'value',
            boundaryGap: [0, 0.01]
           // nameLocation:'start'
        },
        yAxis: {
            type: 'category',
            data: xdata
        },
        series: [
            {
                name: '2019年',
                type: 'bar',
                data: ydata,
                itemStyle : {
                    normal :{
                        color: function(params) {
                            //注意，如果颜色太少的话，后面颜色不会自动循环，最好多定义几个颜色
                            //var colorList = [     ];
                            var colorList = ["#c4ccd3","#546570","#6e7074","#bda29a","#ca8622","#749f83","#91c7ae","#d48265","#61a0a8", "#2f4554","#c23531"    ];
                            return colorList[params.dataIndex]
                        }

                    }
                }
            }
        ]
    };
    // 基于准备好的dom，初始化echarts实例
    var myChartHistogramEnt = echarts.init(document.getElementById('HistogramEnt'));
    // 使用刚指定的配置项和数据显示图表。
    myChartHistogramEnt.setOption(optionHistogramEnt);
    return optionHistogramEnt;
}