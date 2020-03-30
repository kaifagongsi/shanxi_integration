function getLineChartByYearOption(xdata,ydata) {
    /* 折线图数据  */
    var lineChartByYearOption = {
        xAxis: {
            name:'年份',
            type: 'category',
            data: xdata
        },
        yAxis: {
            name:'数量',
            type: 'value',
            nameLocation:'end'
        },
        title:{
            text:'陕西省地标产品批准年度统计',
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
        series: [{
            data: ydata,
            type: 'line',
            symbol: 'triangle',
            symbolSize: 20,
            lineStyle: {
                normal: {
                    color: 'green',
                    width: 4,
                    type: 'dashed'
                }
            },
            itemStyle: {
                normal: {
                    borderWidth: 3,
                    borderColor: 'yellow',
                    color: 'blue'
                }
            }
        }]
    };
    // 基于准备好的dom，初始化echarts实例
    var myChartLineChartByYear = echarts.init(document.getElementById('lineChartByYear'));
    // 使用刚指定的配置项和数据显示图表。
    myChartLineChartByYear.setOption(lineChartByYearOption);
    return lineChartByYearOption;
}