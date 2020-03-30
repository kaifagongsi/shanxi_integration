function showPieAreaEnt(xdata,ydata) {
    var   pieAreaOptionEnt = {
        title : {
            text: '各类地标产品专用标志使用情况统计',
            subtext: '',
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
            },
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x : 'center',
            y : 'bottom',
            data:xdata
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                //dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel']
                }
               // restore : {show: true},
               // saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'产品分类',
                type:'pie',
                radius : [20, 110],
                center : ['50%', '50%'],
                roseType : 'radius',
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                lableLine: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:ydata
            }

        ]
    };
    var myChartLineChartByYear = echarts.init(document.getElementById('pieAreaEnt'));
    myChartLineChartByYear.setOption(pieAreaOptionEnt);
    return pieAreaOptionEnt;
}