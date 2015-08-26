/**
 * 
 */
$(function () {
    $('#container').highcharts({
        title: {
            text: 'The frequency of evens',
            x: -20 //center
        },
        subtitle: {
            text: 'Source: WorldClimate.com',
            x: -20
        },
        xAxis: {
            categories: ['1 - 10','11 - 20','21 - 30','31 - 40','41 - 50','51 - 60','61 - 70','71 - 80','81 - 90','91 - 100']
        },
        yAxis: {
            title: {
                text: 'count (em)'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '%'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'A',
            data: [30.44 , 39.61 , 31.95 , 13.29 , 48.04 , 14.31 , 48.25 , 13.02 , 22.24 , 5.59]
        }, {
            name: 'B',
            data: [4.64 , 5.49 , 25.28 , 13.51 , 7.26  ,0.21 , 4.24 , 19.57 , 3.73 , 8.84]
        }, {
            name: 'C',
            data: [1.94 , 40.78 , 47.95 , 19.57 , 18.15 , 26.48 , 46.72 , 42.68 , 38.35 , 14.49]
        }, {
            name: 'D',
            data: [9.36 , 19.77 , 4.62  ,12.32  ,7.23  , 7.48 , 9.46 , 14.66 , 49.05 , 43.36]
        }]
    });
});
