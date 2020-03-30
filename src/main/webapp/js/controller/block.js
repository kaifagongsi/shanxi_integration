function showBlock(fangkuaiOption) {

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('fangkuai'));

    //myChart.showLoading();

    function convert(source, target, basePath) {
        for (var key in source) {
            //var path = basePath ? (basePath + '.' + key) : key;
            var path = key;
            if (key.match(/^\$/)) {

            }
            else {
                target.children = target.children || [];
                var child = {
                    name: path
                };
                target.children.push(child);
                convert(source[key], child, path);
            }
        }

        if (!target.children) {
            target.value = source.$count || 1;
        }
        else {
            target.children.push({
                name: basePath,
                value: source.$count
            });
        }
    }

    var data = [];
    convert(fangkuaiOption, data, '');
    console.log(data);
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option = {
        title: {
            text: '陕西省地理标志产品专用标志使用情况图',
            subtext: '',
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
        tooltip: {},
        series: [{
            name: '产品',
            type: 'treemap',
            visibleMin: 300,
            data: data.children,
            leafDepth: 1,
            levels: [
                {
                    itemStyle: {
                        normal: {
                            borderColor: '#ffffff',
                            borderWidth: 4,
                            gapWidth: 4
                        }
                    }
                },
                {

                    colorSaturation: [0.3, 0.6],
                    itemStyle: {
                        normal: {
                            borderColorSaturation: 0.7,
                            gapWidth: 2,
                            borderWidth: 2
                        }
                    }
                },
                {
                    colorSaturation: [0.3, 0.5],
                    itemStyle: {
                        normal: {
                            borderColorSaturation: 0.6,
                            gapWidth: 1
                        }
                    }
                },
                {
                    colorSaturation: [0.3, 0.5]
                }
            ]
        }]
    });
}