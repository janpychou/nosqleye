$(document).ready(function() {
	// 定义获取地址栏参数的函数
	function getUrlParam(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
		var r = window.location.search.substr(1).match(reg); // 匹配目标参数
		if (r != null)
			return unescape(r[2]);
		return null; // 返回参数值
	}
	// 获取参数id的值
	var id = getUrlParam("id");
	
	// 加载mongodb基础信息表格
	var mongodbOverviewTable = $('#mongodbOverviewTable').DataTable({
		"bLengthChange" : false,
		"paging" : false,
		"bFilter" : false,
		"ordering" : false,
		"info" : false,
		"processing" : true,
		"serverSide" : true,
		"iDisplayLength" : 10,
		"ajax" : "/api/get-mongodb-overview?id=" + id,
		"columns" : [ {
			"data" : "host"
		}, {
			"data" : "port"
		}, {
			"data" : "version"
		}, {
			"data" : "pid"
		}, {
			"data" : "uptime"
		}, {
			"data" : "isMaster"
		} ]

	});
	
	$.getJSON("api/get-mongodb-top-ns?id=" + id,
			function(data) {
				$.each(data, function(index, content) {
					$("#top_ns").append(
							"<option value='"+content+"'>"
									+ content + "</option>");
				});
			});
	
	
	var ns = null;
	// 加载指标数据
	var mongodbTopHistoryTable = $(
			'#mongodbTopHistoryTable')
			.DataTable(
					{
						"bLengthChange" : false,
						"paging" : false,
						"bFilter" : false,
						"ordering" : false,
						"info" : false,
						"processing" : false,
						"serverSide" : true,
						"iDisplayLength" : 10,
						"ajax" : "/api/get-mongodb-top-history?id="
								+ id + "&ns=" + ns,
						"columns" : [
								{
									"data" : "createTime"
								},
								{
									"data" : "ns"
								},
								{
									"data" : "totalCountPersecond"
								},
								{
									"data" : "readLockCountPersecond"
								},
								{
									"data" : "insertCountPersecond"
								},
								{
									"data" : "updateCountPersecond"
								},
								{
									"data" : "removeCountPersecond"
								} ],
						"createdRow" : function(row,
								data, index) {
							if (index == 0) {
								$('td', row)
										.each(
												function(
														i) {
													$(
															'td',
															row)
															.eq(
																	i)
															.addClass(
																	'highlight');
												});
							}
						},
						"columnDefs" : [ {
							"targets" : [ 0 ], // 目标列位置，下标从0开始
							"data" : "id", // 数据列名
							"render" : function(data,
									type, full) { // 返回自定义内容
								var html = formatDate(full.createTime);
								return html;
							}
						} ]
					});
	// 选择名称空间，刷新指标数据
	$("#top_ns").change(
			function() {
				ns = $("#top_ns").find(
						"option:selected").text();
				mongodbTopHistoryTable.ajax.url(
						"/api/get-mongodb-top-history?id="
								+ id + "&ns=" + ns)
						.load();
				mongodbTopHistoryTable.ajax.reload();
			});
	// 定时刷新
	setInterval(function() {
		mongodbTopHistoryTable.ajax.reload();
	}, 3000);
	
	var mongodbListDatabasesTable = $('#mongodbListDatabasesTable').DataTable({
		"bLengthChange" : false,
		"paging" : false,
		"bFilter" : false,
		"ordering" : false,
		"info" : false,
		"processing" : true,
		"serverSide" : true,
		"iDisplayLength" : 10,
		"ajax" : "/api/get-mongodb-listdatabases?id=" + id,
		"columns" : [ {
			"data" : "name"
		}, {
			"data" : "sizeOnDisk"
		} ]

	});

	var mongodbHostInfoTable = $('#mongodbHostInfoTable').DataTable({
		"bLengthChange" : false,
		"paging" : false,
		"bFilter" : false,
		"ordering" : false,
		"info" : false,
		"processing" : true,
		"serverSide" : true,
		"iDisplayLength" : 10,
		"ajax" : "/api/get-mongodb-hostinfo?id=" + id,
		"columns" : [ {
			"data" : "osName"
		}, {
			"data" : "osVersion"
		}, {
			"data" : "cpuNumCores"
		}, {
			"data" : "memSizeMB"
		}, {
			"data" : "numaEnabled"
		}, {
			"data" : "currentTime"
		} ]

	});

	$.get("api/get-mongodb-replsetgetstatus?id=" + id, function(data) {
		$("#replSetGetStatus").JSONView(data);
	});

	$.get("api/get-mongodb-replsetgetconfig?id=" + id, function(data) {
		$("#replSetGetConfig").JSONView(data);
	});

	$.get("api/get-mongodb-lockinfo?id=" + id, function(data) {
		$("#lockInfo").JSONView(data);
	});
});

// 格式化时间
function formatDate(date) {     
	var newDate = new Date(date)
	return newDate.pattern("MM-dd hh:mm:ss");    
	}
// 格式化函数
Date.prototype.pattern=function(fmt) {           
    var o = {           
    "M+" : this.getMonth()+1, // 月份
    "d+" : this.getDate(), // 日
    "h+" : this.getHours()%24 == 0 ? 12 : this.getHours()%24, // 小时
    "H+" : this.getHours(), // 小时
    "m+" : this.getMinutes(), // 分
    "s+" : this.getSeconds(), // 秒
    "q+" : Math.floor((this.getMonth()+3)/3), // 季度
    "S" : this.getMilliseconds() // 毫秒
    };           
    var week = {           
    "0" : "/u65e5",           
    "1" : "/u4e00",           
    "2" : "/u4e8c",           
    "3" : "/u4e09",           
    "4" : "/u56db",           
    "5" : "/u4e94",           
    "6" : "/u516d"          
    };           
    if(/(y+)/.test(fmt)){           
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));           
    }           
    if(/(E+)/.test(fmt)){           
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);           
    }           
    for(var k in o){           
        if(new RegExp("("+ k +")").test(fmt)){           
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));           
        }           
    }           
    return fmt;           
} 
