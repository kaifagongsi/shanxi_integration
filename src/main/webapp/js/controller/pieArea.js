function showPieArea(xdata,ydata) {
    /*  饼状面积图数据 */
    var pieAreaOption = {
        title : {
            text: '陕西省地标产品分类统计',
            subtext: '',
            x:'center',
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
        tooltip : {
            trigger: 'item',
            formatter:function(data){
                console.log(data)
                return data.seriesName + "<br/>"+ data.name+ " : " + data.value + " ("+data.percent.toFixed(1)+"%)";
            }
        },
        legend: {
            padding:[40,50,0,0],
            x : 'left',
            orient: 'vertical',
           // y : 'left',
            //type: "scroll",
            data:xdata
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
               // dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel']
                },
                //restore : {show: true},
                //saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'陕西省地标产品分类统计',
                type:'pie',
                radius : [50, 110],
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
                data: ydata
            }

        ]
    };
    var myChartLineChartByYear = echarts.init(document.getElementById('pieArea'));
    myChartLineChartByYear.setOption(pieAreaOption);
    return pieAreaOption;
}