var table;
// DOM加载完成后执行
$()
		.ready(
				function() {
					//加载redis集群列表
					loadRedisClusters();
					// 提交redis信息
					$("#submit").click(
							function() {
								var id = $("#id").val();
								var name = $("#name").val();
								if (name == "") {
									$("#alert").text("请填写集群名称");
									$("#alert").show();
									return;
								}
								url = "/api/save-redis-cluster?id=" + id + "&name="
										+ name
								$.getJSON(url, function(json) {
									if (json.code == "200") {
										$('#myModal').modal('hide');
										// 新增完成后，重新加载留言信息
										$("#id").val("0");
										$("#name").val("");
										$("#alert").hide();
										loadRedisClusters();
									} else {
										$("#alert").text(json.message);
										$("#alert").show();
									}
								});
							});
				});
//加载redis集群列表数据
var loadRedisClusters=function(){
	$.getJSON("api/get-redis-clusters", function(json){
		$("#tbody").empty();
		$.each( json, function(index, content)
		{ 
			var html="";
			html+="<tr>";
			html+="<td>"+content.id+"</td>";
			html+="<td>"+content.name+"</td>";
			var operate="<div class='dropdown'><button class='btn btn-default dropdown-toggle' type='button' id='dropdownMenu"
										+ content.id
										+ "' data-toggle='dropdown' aria-haspopup='true' aria-expanded='true'>操作<span class='caret'></span></button><ul class='dropdown-menu' aria-labelledby='dropdownMenu"
										+ content.name
										+ "'><li><a  href=javascript:editRedisCluster("
										+ content.id
										+ ",'"
										+ content.name
										+ "')>编辑</a></li><li><a  href=javascript:deleteRedisCluster("
										+ content.id
										+ ",'"
										+ content.name
										+ "')>删除</a></li></ul></div>";
			html+="<td>"+operate+"</td>";
			$("#tbody").append(html);
		});
	});
}
// 删除redis集群
var deleteRedisCluster = function(id, name) {
	bootbox.setLocale("zh_CN");
	bootbox.confirm("你确认删除" + name + "这个Redis集群信息吗？", function(
			result) {
		if (result) {
			$.getJSON("/api/delete-redis-cluster?id=" + id, function(json) {
				loadRedisClusters();
			});
		}
	});
}

// 编辑redis集群
var editRedisCluster = function(id,name) {
	$('#myModal').modal('show');
	$("#alert").text("");
	$("#alert").hide();
	$("#id").val(id);
	$("#name").val(name);
}

// 打开模态窗口
var openModal = function() {
	$('#myModal').modal('show');
	$("#id").val("0");
	$("#name").val("");
	$("#alert").text("");
	$("#alert").hide();
}
