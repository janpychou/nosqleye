$(function($) {
	// 获取所有集群信息
	$.getJSON("api/get-redis-clusters", function(data) {
		//初始化集群下拉菜单
		var li = "";
		$.each(data, function(n, value) {
			if (n == 0) {
				$("#defaultCluster").text(value.name);
				// 保存当前clusterId
				$("#defaultClusterId").val(value.id);
			}
			li += "<li><a href='javascript:reloadNetwork(" + value.id + ",\""
					+ value.name + "\")'>" + value.name + "</a></li>";
		});
		if (li == "") {
			li = "<li><a href='javascript:void(0)'>暂未添加任何节点</a></li>";
		}
		$("#clusterUl").append(li);
		clusterId = $("#defaultClusterId").val();
		//加载集群拓扑图
		loadClusterNetwork(clusterId);
	});
});
//加载集群拓扑图
var loadClusterNetwork = function(clusterId) {
	// 开始加载数据，显示loading图标
	$("body").mLoading({
		mask : false
	// 是否显示遮罩效果，默认显示
	});
	$.getJSON("api/get-redis-cluster-network", {
		clusterId : clusterId
	}, function(data) {
		var redisServerStatus = data.redisServerStatus;
		var DIR = '/img/';
		nodesArray = [];
		$.each(redisServerStatus, function(n, value) {
			label = value.host + ":" + value.port + "(" + value.status + ")";
			nodesArray.push({
				id : value.id,
				label : label,
				image : DIR + 'redis.png',
				shape : 'image',
				physics : false
			});
		});
		edgesArray = [];
		var relations = data.relations;
		$.each(relations, function(n, value) {
			label = "Status:" + value.slaveStatus.masterLinkStatus;
			edgesArray.push({
				from : value.from.id,
				to : value.to.id,
				label : label,
				font : {
					align : 'left'
				},
				arrows : 'to',
				dashes : true
			});
		});

		startNetwork();
		// 加载数据完毕关闭loading图标
		$("body").mLoading("hide");
	});
}
// 构建拓扑图
function startNetwork() {
	shadowState = false;
	nodes = new vis.DataSet(nodesArray);
	edges = new vis.DataSet(edgesArray);

	var container = document.getElementById('mynetwork');
	var data = {
		nodes : nodes,
		edges : edges
	};
	var options = {
		layout : {
			hierarchical : {
				direction : "UD",
				sortMethod : "directed",
				levelSeparation : 300,
				nodeSpacing : 300
			}
		},
		interaction : {
			dragNodes : true,
			zoomView : false
		},
		physics : {
			enabled : true
		}
	};
	network = new vis.Network(container, data, options);
	// 双击节点，展示节点详细信息
	network.on("doubleClick", function(params) {
		params.event = "[original event]";
		if (params.nodes[0] != undefined) {
			showNodeMonitor(params.nodes[0]);
		}
	});
}
//重新加载拓扑图
var reloadNetwork = function(clusterId, clusterName) {
	$("#defaultCluster").text(clusterName);
	// 保存当前clusterId
	$("#defaultClusterId").val(clusterId);
	loadClusterNetwork(clusterId);
}
//跳转到节点监控页面
var showNodeMonitor = function(serverId) {
	$(location).attr('href', 'redis-detail.html?id=' + serverId);
}
