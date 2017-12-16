//加载mongodb列表表格
var table;
// DOM加载完成后执行
$()
		.ready(
				function() {
					// 获取节点个数
					countMongodb();
					// 加载留言信息
					table = $('#example')
							.DataTable(
									{
										"bLengthChange" : false,
										"bFilter" : false,
										"bSort" : false,
										"processing" : true,
										"serverSide" : true,
										"iDisplayLength" : 10,
										"pagingType" : "simple",
										"oLanguage" : {
											"sLengthMenu" : "每页显示 _MENU_ 条记录",
											"sZeroRecords" : "对不起，查询不到任何相关数据",
											"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
											"sInfoEmtpy" : "找不到相关数据",
											"sInfoFiltered" : "数据表中共为 _MAX_ 条记录)",
											"sProcessing" : "正在加载中...",
											"sSearch" : "搜索",
											"sUrl" : "", // 多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
											"oPaginate" : {
												"sFirst" : "第一页",
												"sPrevious" : " 上一页 ",
												"sNext" : " 下一页 ",
												"sLast" : " 最后一页 "
											}

										},
										"ajax" : "/api/get-mongodb-list",
										"columns" : [ {
											"data" : "host"
										}, {
											"data" : "port"
										}, {
											"data" : "tags"
										}, {
											"data" : "status"
										}, {
											"data" : "uptime"
										} ],
										"columnDefs" : [ {
											"targets" : [ 5 ], // 目标列位置，下标从0开始
											"data" : "id", // 数据列名
											"render" : function(data, type,
													full) { // 返回自定义内容
												var html = "";
												html += "<span style='color:red;margin:1px;'><a  href='mongodb-detail.html?id="
														+ full.id
														+ "'>【监控】</a></span>";
												html += "<span style='color:red;'><a  href=javascript:editMongodb("
														+ full.id
														+ ")>【编辑】</a></span>";

												html += "<span style='color:red;margin:1px;'><a  href=javascript:deleteMongodb("
														+ full.id
														+ ",'"
														+ full.host
														+ "','"
														+ full.port
														+ "')>【删除】</a></span>"
												return html;
											}
										} ]
									});

					// 提交mongodb信息
					$("#submit").click(
							function() {
								var id = $("#id").val();
								var host = $("#host").val();
								var port = $("#port").val();
								var username = $("#username").val();
								var password = $("#password").val();
								var tags = $("#tags").val();
								if (host == "" || port == "") {
									$("#alert").text("请填写完整,主机和端口不能为空");
									$("#alert").show();
									return;
								}
								url = "/api/save-mongodb?id=" + id + "&host="
										+ host + "&port=" + port + "&username="
										+ username + "&password=" + password
										+ "&tags=" + tags
								$.getJSON(url, function(json) {
									if (json.code == "200") {
										$('#myModal').modal('hide');
										// 新增完成后，重新加载留言信息
										table.ajax.reload();
										$("#id").val("0");
										$("#host").val("");
										$("#username").val("");
										$("#password").val("");
										$("#tags").val("");
										$("#alert").text("");
										$("#alert").hide();
										countMongodb();
									} else {
										$("#alert").text(json.message);
										$("#alert").show();
									}
								});
							});
				});
// 删除redis节点
var deleteMongodb = function(id, host, port) {
	bootbox.setLocale("zh_CN");
	bootbox.confirm("你确认删除" + host + ":" + port + "这个MongoDB节点吗？", function(
			result) {
		if (result) {
			$.getJSON("/api/delete-mongodb?id=" + id, function(json) {
				table.ajax.reload();
				countMongodb();
			});
		}
	});
}

// 编辑redis节点
var editMongodb = function(id) {
	$('#myModal').modal('show');
	$("#alert").text("");
	$("#alert").hide();
	url = "/api/get-mongodb?id=" + id;
	$.getJSON(url, function(json) {
		if (json.code == "200") {
			$("#id").val(json.data.id);
			$("#host").val(json.data.host);
			$("#port").val(json.data.port);
			$("#username").val(json.data.username);
			$("#password").val(json.data.password);
			$("#tags").val(json.data.tags);
		} else {
			$("#alert").text(json.message);
			$("#alert").show();
		}
	});
}

// 打开模态窗口
var openModal = function() {
	$('#myModal').modal('show');
	$("#id").val("0");
	$("#host").val("");
	$("#port").val("27017");
	$("#username").val("");
	$("#password").val("");
	$("#tags").val("");
	$("#alert").text("");
	$("#alert").hide();
}
// 获取redis节点数量
var countMongodb = function() {
	url = "/api/count-mongodb";
	$.getJSON(url, function(json) {
		if (json.code == "200") {
			$("#count").text(json.data);
		}
	});
}
