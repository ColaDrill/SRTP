/**
 * ����һ�������ļ�
 */
$(function () { 
    $('#container').highcharts({                   //ͼ��չʾ��������div��id����һ��
        chart: {
            type: 'column'                         //ָ��ͼ������ͣ�Ĭ��������ͼ��line��
        },
        title: {
            text: 'My first Highcharts chart'      //ָ��ͼ�����
        },
        xAxis: {
            categories: ['my', 'first', 'chart']   //ָ��x�����
        },
        yAxis: {
            title: {
                text: 'something'                  //ָ��y��ı���
            }
        },
        series: [{                                 //ָ��������
            name: 'Jane',                          //��������
            data: [1, 0, 4]                        //����
        }, {
            name: 'John',
            data: [5, 7, 3]
        }]
    });
});