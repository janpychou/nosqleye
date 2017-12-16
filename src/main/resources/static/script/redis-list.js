var table;
// DOM加载完成后执行
$()
		.ready(
				function() {
					// 获取节点个数
					countRedis();
					// 加载留言信息
					table = $('#example')
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
											"sSearch" : "标签搜索",
											"sUrl" : "", // 多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
											"oPaginate" : {
												"sFirst" : "第一页",
												"sPrevious" : " 上一页 ",
												"sNext" : " 下一页 ",
												"sLast" : " 最后一页 "
											}

										},
										"ajax" : "/api/get-redis-list",
										"columns" : [ {
											"data" : "host"
										}, {
											"data" : "port"
										}, {
											"data" : "tags"
										}, {
											"data" : "status"
										}, {
											"data" : "role"
										}, {
											"data" : "master"
										}, {
											"data" : "keyspace"
										}, {
											"data" : "memory"
										}, {
											"data" : "uptime"
										} ],
										"columnDefs" : [ {
											"targets" : [ 9 ], // 目标列位置，下标从0开始
											"data" : "id", // 数据列名
											"render" : function(data, type,
													full) { // 返回自定义内容
												var html = "<div class='dropdown'><button class='btn btn-default dropdown-toggle' type='button' id='dropdownMenu"
														+ full.id
														+ "' data-toggle='dropdown' aria-haspopup='true' aria-expanded='true'>操作<span class='caret'></span></button><ul class='dropdown-menu' aria-labelledby='dropdownMenu"
														+ full.id
														+ "'><li><a  href='redis-detail.html?id="
														+ full.id
														+ "' >监控</a></li><li><a  href='redis-query.html?id="
														+ full.id
														+ "' >查询数据</a></li><li><a  href=javascript:editRedis("
														+ full.id
														+ ",'"
														+ full.host
														+ "','"
														+ full.port
														+ "')>编辑</a></li><li><a  href=javascript:saveRedis("
														+ full.id
														+ ",'"
														+ full.host
														+ "','"
														+ full.port
														+ "')>备份</a></li><li><a  href=javascript:alertConfig("
														+ full.id
														+ ",'"
														+ full.host
														+ "','"
														+ full.port
														+ "')>配置报警</a></li><li><a  href=javascript:deleteRedis("
														+ full.id
														+ ",'"
														+ full.host
														+ "','"
														+ full.port
														+ "')>删除</a></li></ul></div>";

												return html;
											}
										} ]
									});

					// 提交redis信息
					$("#submit").click(
							function() {
								var id = $("#id").val();
								var host = $("#host").val();
								var port = $("#port").val();
								var password = $("#password").val();
								var tags = $("#tags").val();
								if (host == "" || port == "") {
									$("#alert").text("请填写完整,主机和端口不能为空");
									$("#alert").show();
									return;
								}
								var selectedRedisClusterId=$("#defaultClusterId").val();
								url = "/api/save-redis?id=" + id + "&host="
										+ host + "&port=" + port + "&password="
										+ password + "&tags=" + tags+"&clusterId="+selectedRedisClusterId;
								$.getJSON(url, function(json) {
									if (json.code == "200") {
										$('#myModal').modal('hide');
										// 新增完成后，重新加载信息
										table.ajax.reload();
										$("#id").val("0");
										$("#host").val("");
										$("#password").val("");
										$("#tags").val("");
										$("#alert").text("");
										$("#alert").hide();
										countRedis();
									} else {
										$("#alert").text(json.message);
										$("#alert").show();
									}
								});
							});
				});
// 删除redis节点
var deleteRedis = function(id, host, port) {
	bootbox.setLocale("zh_CN");
	bootbox.confirm("你确认删除" + host + ":" + port + "这个Redis节点吗？", function(
			result) {
		if (result) {
			$.getJSON("/api/delete-redis?id=" + id, function(json) {
				table.ajax.reload();
				countRedis();
			});
		}
	});
}
// 备份redis
var saveRedis = function(id, host, port) {
	bootbox.setLocale("zh_CN");
	bootbox.confirm("采用异步方式备份，备份文件保存在Redis数据目录下，确认备份" + host + ":" + port
			+ "吗？", function(result) {
		if (result) {
			$.getJSON("/api/backup-redis?id=" + id, function(json) {
				bootbox.alert("备份成功");
			});
		}
	});
}
// 编辑redis节点
var editRedis = function(id) {
	$('#myModal').modal('show');
	$("#alert").text("");
	$("#alert").hide();
	url = "/api/get-redis?id=" + id;
	$.getJSON(url, function(json) {
		if (json.code == "200") {
			$("#id").val(json.data.id);
			$("#host").val(json.data.host);
			$("#port").val(json.data.port);
			$("#password").val(json.data.password);
			$("#tags").val(json.data.tags);
			initRedisCluster(json.data.clusterId);
		} else {
			$("#alert").text(json.message);
			$("#alert").show();
		}
	});
}

// 配置报警
var alertConfig = function(id, host, port) {
	// ajax获取报警手机号码
	$
			.getJSON(
					"/api/get-alert-phonenumbers?serverType=redis&serverId="
							+ id,
					function(json) {
						var alertPhoneNumbers = json.data;
						// 弹出窗口，输入手机号码
						bootbox.setLocale("zh_CN");
						bootbox
								.prompt({
									title : host + ":" + port
											+ "如发生异常，短信通知以下手机号码(多个手机号以英文逗号分隔)",
									inputType : 'textarea',
									value : alertPhoneNumbers,
									callback : function(result) {
										if (result == null) {
											return;
										} else {
											var alertPhoneNumbers = result;
											var url = "/api/save-alert-phonenumbers?serverType=redis&serverId="
													+ id
													+ "&phoneNumbers="
													+ alertPhoneNumbers;
											$.getJSON(url, function(json) {
												if (json.code != "200") {
													bootbox.alert({
														message : "保存手机号码出现异常",
														backdrop : true
													});
												}
											});
										}
									}
								});
					});
}

// 打开模态窗口
var openModal = function() {
	$('#myModal').modal('show');
	$("#id").val("0");
	$("#host").val("");
	$("#password").val("");
	$("#port").val("6379");
	$("#tags").val("");
	$("#alert").text("");
	$("#alert").hide();
	//初始化redis集群下拉菜单
	initRedisCluster(0);
}
// 获取redis节点数量
var countRedis = function() {
	url = "/api/count-redis";
	$.getJSON(url, function(json) {
		if (json.code == "200") {
			$("#count").text(json.data);
		}
	});
}

//初始化“选择集群”下拉菜单
var initRedisCluster=function(id){
	//如果id为0，则为新增，不为0则为编辑需要初始化集群名称
	if(id==0){
		$("#defaultCluster").text("选择集群");
		$("#defaultClusterId").val("0");
	}
	$("#clusterUl").empty();
	$.getJSON("api/get-redis-clusters", function(data) {
		//初始化集群下拉菜单
		var li = "";
		$.each(data, function(n, value) {
			//当集群id和传入的id相等时，表示“编辑”，则初始化当前集群名称，id
			if(value.id==id){
				$("#defaultCluster").text(value.name);
				$("#defaultClusterId").val(value.id);
			}
			li += "<li><a href='javascript:selectRedisCluster(" + value.id + ",\""
					+ value.name + "\")'>" + value.name + "</a></li>";
		});
		if (li == "") {
			li = "<li><a href='javascript:void(0)'>暂未添加任何节点</a></li>";
		}
		$("#clusterUl").append(li);
	});
}

var selectRedisCluster=function(id,name){
	$("#defaultCluster").text(name);
	$("#defaultClusterId").val(id);
}

