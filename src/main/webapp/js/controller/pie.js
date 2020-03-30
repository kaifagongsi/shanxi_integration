function text() {
    alert("111111111111111");
}
function showPieChart(data) {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('pieChart'));

    var pieChartOption = {
        title: {
            text: '陕西省地理标志产品保护地域层级',
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
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'right',
            align:'left',
            y: 'center',
            padding:[20,100,20,20],
            data:['省级','地市级','区县级']

        },
        series: [
            {
                name:'',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: data
            }
        ]
    };
// 使用刚指定的配置项和数据显示图表。
    myChart.setOption(pieChartOption);
    return pieChartOption
}
