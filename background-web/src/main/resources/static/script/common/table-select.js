
jQuery(function ($) {
    //.wrap("<div class='dataTables_borderWrap' />")   //if you are applying horizontal scrolling (sScrollX)
//        var oTable1 =
//                $('#index-first-table').dataTable( {
//                            bAutoWidth: false,
//                            "aoColumns": [
//                                { "bSortable": false },
//                                null, null,null, null, null,
//                                { "bSortable": false }
//                            ],
//                            "aaSorting": [],
//
//                            //,
//                            //"sScrollY": "200px",
//                            //"bPaginate": false,
//
//                            //"sScrollX": "100%",
//                            //"sScrollXInner": "120%",
//                            //"bScrollCollapse": true,
//                            //Note: if you are applying horizontal scrolling (sScrollX) on a ".table-bordered"
//                            //you may want to wrap the table inside a "div.dataTables_borderWrap" element
//
//                            //"iDisplayLength": 50
//                        } );

    var myTable =
        $('#index-first-table')
//                        .dataTable({
        .DataTable({
//                            "sort": false,
//                            bAutoWidth: false,//for better responsiveness
//                            aoColumns: [
//                                {"bSortable": false},
//                                null, null, null, null, null,
//                                {"bSortable": false}
//                            ],

            paging: true,//分页
            ordering: true,//是否启用排序
            searching: true,//搜索
            language: {
                lengthMenu: '<select class="form-control input-xsmall">' + '<option value="1">1</option>' + '<option value="10">10</option>' + '<option value="20">20</option>' + '<option value="30">30</option>' + '<option value="40">40</option>' + '<option value="50">50</option>' + '</select>条记录',//左上角的分页大小显示。
                search: '<span class="label label-success">搜索：</span>',//右上角的搜索文本，可以写html标签

                paginate: {//分页的样式内容。
                    previous: "上一页",
                    next: "下一页",
                    first: "第一页",
                    last: "最后"
                },

                zeroRecords: "没有内容",//table tbody内容为空时，tbody的内容。
                //下面三者构成了总体的左下角的内容。
                info: "总共_PAGES_ 页，显示第_START_ 到第 _END_ ，筛选之后得到 _TOTAL_ 条，初始_MAX_ 条 ",//左下角的信息显示，大写的词为关键字。
                infoEmpty: "0条记录",//筛选为空时左下角的显示。
                infoFiltered: ""//筛选之后的左下角筛选提示，
            },
            paging: true,
            pagingType: "full_numbers",//分页样式的类型
        });
//        myTable.$('tr',{'search':'applied'}).css('backgroundColor', 'red');
    $("#index-first-table tbody tr").click(function(event){
        var $this = $(this);
        //alert($this.data("selectrow"));
   //     $(this).data("selectrow","selected");
        $(this).attr("data-selectrow","selected");
        //alert($this.data("selectrow"));
        //$this.addClass("click-active").siblings("tr").removeClass("click-active");
        //var obj = $("tr").data("selectrow")
        //.addClass("click-active");
        $("[data-selectrow = 'selected']").addClass("click-active");
    });
})
