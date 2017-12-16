$(function($) {
	loadAlertList();
});

// 加载报警记录数据
var loadAlertList = function() {
	var url = "/api/get-alert-list";
	$('#tableAlertList')
			.DataTable(
					{
						"bLengthChange" : false,
						"bFilter" : true,
						"bSort" : false,
						"processing" : true,
						"bProcessing" : true,
						"serverSide" : true,
						"iDisplayLength" : 10,
						"pagingType" : "simple",
						"oLanguage" : {
							"sLengthMenu" : "每页显示 _MENU_ 条记录",
							"sZeroRecords" : "对不起，查询不到任何相关数据",
							"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
							"sInfoEmtpy" : "找不到相关数据",
							"sInfoFiltered" : "数据表中共为 _MAX_ 条记录)",
							"sProcessing" : "<br/><br/><br/><img src=\"img/loading.gif\" />",
							"sLoadingRecords" : "Loading...",
							"sSearch" : "主机搜索",
							"sUrl" : "", // 多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
							"oPaginate" : {
								"sFirst" : "第一页",
								"sPrevious" : " 上一页 ",
								"sNext" : " 下一页 ",
								"sLast" : " 最后一页 "
							}

						},
						"ajax" : url,
						"columns" : [ {
							"data" : null
						}, {
							"data" : "host"
						}, {
							"data" : "port"
						}, {
							"data" : "alertContent"
						}, {
							"data" : "createTime"
						} ],
						"columnDefs" : [ {
							"targets" : [ 0 ], // 目标列位置，下标从0开始
							"data" : "alertLevel", // 数据列名
							"render" : function(data, type, full) { // 返回自定义内容
								var html = "";
								var alertLevel = full.alertLevel;
								switch (alertLevel) {
								case "INFO":
									html += "<span class=\"label label-info\">"
											+ alertLevel + "</span>";
									break;
								case "WARN":
									html += "<span class=\"label label-warning\">"
											+ alertLevel + "</span>";
									break;
								case "ERROR":
									html += "<span class=\"label label-danger\">"
											+ alertLevel + "</span>";
									break;
								default:
									html += "<span class=\"label label-primary\">"
											+ alertLevel + "</span>";
								}
								return html;
							}
						} ]
					});
}