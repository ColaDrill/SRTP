/**
 * 这组数据库里的数据是这样的。。
 **********************************
时间戳         在该时间点上发生的事件数
1411660366 : 1
1411661231 : 8
1411661233 : 2
1411661234 : 2
1411661475 : 1
1411661615 : 1
1411662474 : 1
1411663415 : 1
 **********************************
 */
$(function () {
    $('#container').highcharts({
        chart: {
            type: 'line',
            zoomType: 'x',
            panning: true,
            panKey: 'shift'
        },

        title: {
            text: 'eventCountOntimeLine'
        },

        subtitle: {
            text: null
        },

        xAxis: {
            categories: ['1411660366','1411661231','1411661233','1411661234','1411661475','1411661615','1411662474','1411663415']
        },

        series: [{
            data: [1,8,2,2,1,1,1,1]
        }]
    });
});