$(function () {
    $.getJSON('http://www.hcharts.cn/datas/jsonp.php?filename=aapl-c.json&callback=?', function (data) {
        // Create the chart
        $('#chart1').highcharts('StockChart', {
			rangeSelector: {
                selected: 1
            },

            title: {
                text: 'AAPL Stock Price'
            },

            series: [{
                name: 'AAPL',
                data: data,
                tooltip: {
                    valueDecimals: 2
                }
            }]
        });
    });

});