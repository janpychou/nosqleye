//点击查询按钮执行keys查询
$(function($) {
	$("#btQuery").click(function() {
		queryKeys();
	});
});
// 响应回车键查询
$(window).keydown(function(event) {
	if (event.keyCode == 13) {
		queryKeys();
	}
});
// 查询redis key
var queryKeys = function() {
	//获取db的索引号并验证
	var dbIndex = $("#dbIndex").val();
	var regu = /^\d+$/;
	if (!regu.test(dbIndex)) {
		$("#alert").text("DB Index必须为非负整数");
		$("#alert").show();
		return;
	}
	var sKeyPattern = $("#queryKey").val();
	var id = getUrlParam("id");
	var url = "/api/query-redis-keys?id=" + id + "&dbIndex=" + dbIndex
			+ "&keyPattern=" + sKeyPattern;
	$.getJSON(url, function(json) {
		$("#tbodyKeys").empty();
		if (json.length == 0) {
			$("#alert").text("未查询到相关的key，你可以使用通配符*扩大查询的范围");
			$("#alert").show();
		} else {
			$("#alert").hide();
		}
		var html = "";
		$.each(json, function(i, value) {
			html += "<tr>";
			//key通过base64加密，避免key参数存在特殊字符
			html += "<td><a href=\"javascript:queryKeyValue(" + dbIndex + ",'"
					+ BASE64.encoder(value.key) + "','" + value.type + "')\">";
			html += value.key;
			html += "</a></td>";
			html += "<td><span class=\"label label-success\">";
			html += value.type;
			html += "</span></td>";
			html += "<td>";
			html += value.size;
			html += "</td>";
			html += "<td>";
			html += value.expires;
			html += "</td>";
			html += "</tr>";
		});
		$("#tbodyKeys").append(html);
	});
}

//根据key查询对应的value
var queryKeyValue = function(dbIndex, key, type) {
	switch (type) {
	case "string":
		showStringQueryResult(dbIndex, key, type);
		break;
	case "zset":
		showZsetQueryResult(dbIndex, key, type);
		break;
	case "list":
		showListQueryResult(dbIndex, key, type);
		break;
	case "hash":
		showHashQueryResult(dbIndex, key, type);
		break;
	case "set":
		showSetQueryResult(dbIndex, key, type);
		break;
	default:
		break;
	}
}
// 显示string类型查询结果
var showStringQueryResult = function(dbIndex, key, type) {
	var id = getUrlParam("id");
	var url = "/api/query-redis-value-by-key";
	var ajaxUrl = url + "?id=" + id + "&dbIndex=" + dbIndex + "&key=" + key
			+ "&type=" + type;
	$.get(ajaxUrl, function(data) {
		bootbox.alert(data);
	});
}
// 显示hash类型查询结果
var showHashQueryResult = function(dbIndex, key, type) {
	// 将各查询结果表格置空并隐藏
	destroyAndHideResultTable();
	
	var table=$('#hashTable');
	var columns=[ {"data" : "key"}, {"data" : "value"} ];
	loadDataTable(table,columns,dbIndex, key, type);
	// 显示hash查询结果
	$("#hashTable").show();
	$('#resultModal').modal('show');
}
// 显示set类型查询结果
var showSetQueryResult = function(dbIndex, key, type) {
	// 将各查询结果表格置空并隐藏
	destroyAndHideResultTable();
	
	var table=$('#setTable');
	var columns=[ {"data" : "value"} ];
	loadDataTable(table,columns,dbIndex, key, type);
	// 显示list查询结果
	$("#setTable").show();
	$('#resultModal').modal('show');
}
// 显示list类型查询结果
var showListQueryResult = function(dbIndex, key, type) {
	// 将各查询结果表格置空并隐藏
	destroyAndHideResultTable();
	
	var table=$('#listTable');
	var columns=[ {"data" : "value"} ];
	loadDataTable(table,columns,dbIndex, key, type);
	// 显示list查询结果
	$("#listTable").show();
	$('#resultModal').modal('show');
}
// 显示zset类型的查询信息
var showZsetQueryResult = function(dbIndex, key, type) {
	// 将各查询结果表格置空并隐藏
	destroyAndHideResultTable();
	
	var table=$('#zsetTable');
	var columns=[ {"data" : "element"},{"data" : "score"} ];
	loadDataTable(table,columns,dbIndex, key, type);
	// 显示zset查询结果
	$("#zsetTable").show();
	$('#resultModal').modal('show');
}
//加载指定表格数据
var loadDataTable=function(table,columns,dbIndex, key, type){
	var id = getUrlParam("id");
	var url = "/api/query-redis-value-by-key";
	table.DataTable(
			{
				"bLengthChange" : false,
				"bFilter" : true,
				"bSort" : true,
				"processing" : false,
				"serverSide" : false,
				"iDisplayLength" : 10,
				"pagingType" : "simple",
				"oLanguage" : {
					"sLengthMenu" : "每页显示 _MENU_ 条记录",
					"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
					"sInfoEmtpy" : "找不到相关数据",
					"sInfoFiltered" : "数据表中共为 _MAX_ 条记录",
					"sSearch" : "搜索",
					"sUrl" : "", // 多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
					"oPaginate" : {
						"sFirst" : "第一页",
						"sPrevious" : " 上一页 ",
						"sNext" : " 下一页 ",
						"sLast" : " 最后一页 "
					}

				},
				"ajax" : url + "?id=" + id + "&dbIndex=" + dbIndex + "&key="
						+ key + "&type=" + type,
				"columns" : columns
			});
}
//将各查询结果表格置空并隐藏
var destroyAndHideResultTable=function(){
	$(".queryResult").each(function() {
		$(this).DataTable().destroy();
	});
	$(".queryResult").hide();
}
