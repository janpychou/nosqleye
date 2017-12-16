//定义获取地址栏参数的函数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数
	if (r != null)
		return unescape(r[2]);
	return null; // 返回参数值
}
// 定义获取指定毫秒前的时间
var getMillisecondAgoFormatDate = function(millisecond) {
	Date
	curDate = new Date();
	var date = new Date(curDate.getTime() - millisecond);
	var seperator1 = "/";
	var seperator2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var strHours = date.getHours();
	var strMinutes = date.getMinutes();
	var strSeconds = date.getSeconds();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	if (strHours >= 0 && strHours <= 9) {
		strHours = "0" + strHours;
	}
	if (strMinutes >= 0 && strMinutes <= 9) {
		strMinutes = "0" + strMinutes;
	}
	if (strSeconds >= 0 && strSeconds <= 9) {
		strSeconds = "0" + strSeconds;
	}
	var currentdate = date.getFullYear() + seperator1 + month + seperator1
			+ strDate + " " + strHours + seperator2 + strMinutes + seperator2
			+ strSeconds;
	return currentdate;
}
// 获取参数id的值
var id = getUrlParam("id");
//初始化时间范围，根据时间范围开始绘图
$(document).ready(
		function() {
			var now = getMillisecondAgoFormatDate(0);
			var halfAnHourAgo = getMillisecondAgoFormatDate(30 * 60 * 1000);
			var timeRange=halfAnHourAgo + " - " + now;
			startChart(timeRange);
			$("#reservationtime").val(timeRange);
			$('#reservationtime').daterangepicker(
					{
						timePicker : true,
						timePickerIncrement : 1,
						format : 'YYYY/MM/DD HH:mm:ss'
					},
					function(start, end, label) {
						timeRange=$("#reservationtime").val();
						startChart(timeRange);
					});
});

// 加载redis信息表格
var table = $('#infoTable').DataTable({
	"bLengthChange" : false,
	"paging" : false,
	"bFilter" : false,
	"ordering" : false,
	"info" : false,
	"processing" : true,
	"serverSide" : true,
	"iDisplayLength" : 10,
	"ajax" : "/api/get-redis-detail?id=" + id,
	"columns" : [ {
		"data" : "host"
	}, {
		"data" : "port"
	}, {
		"data" : "redisVersion"
	}, {
		"data" : "redisMode"
	}, {
		"data" : "processId"
	}, {
		"data" : "uptimeInDays"
	}, {
		"data" : "role"
	}, {
		"data" : "connectedSlaves"
	}, {
		"data" : "aofEnabled"
	}, {
		"data" : "clusterEnabled"
	}, {
		"data" : "aofLastWriteStatus"
	} ]

});

// 加载实时监控数据
var monitoringTable = $('#monitoringTable').DataTable({
	"bLengthChange" : false,
	"paging" : false,
	"bFilter" : false,
	"ordering" : false,
	"info" : false,
	"processing" : false,
	"serverSide" : true,
	"iDisplayLength" : 10,
	"ajax" : "/api/get-redis-monitoring?id=" + id,
	"columns" : [ null, {
		"data" : "connectedClients"
	}, {
		"data" : "blockedClients"
	}, {
		"data" : "usedMemoryHuman"
	}, {
		"data" : "usedMemoryRssHuman"
	}, {
		"data" : "memFragmentationRatio"
	}, {
		"data" : "instantaneousOpsPerSec"
	}, {
		"data" : "keyspace"
	} ],
	"columnDefs" : [ {
		"targets" : [ 0 ], // 目标列位置，下标从0开始
		"data" : "createTime", // 数据列名
		"render" : function(data, type, full) { // 返回自定义内容
			var html = getDate(full.createTime);
			return html;
		}
	} ],
	"createdRow" : function(row, data, index) {
		if (index == 0) {
			$('td', row).each(function(i) {
				$('td', row).eq(i).addClass('highlight');
			});
		}
	}
});
// 定时刷新表格数据
window.setInterval("monitoringTable.ajax.reload()", 3000);
// 格式化日期
function add0(m) {
	return m < 10 ? '0' + m : m
};
function getDate(timestamp) {
	var time = new Date(timestamp);
	var y = time.getFullYear();
	var m = time.getMonth() + 1;
	var d = time.getDate();
	var h = time.getHours();
	var mm = time.getMinutes();
	var s = time.getSeconds();
	return add0(m) + '-' + add0(d) + ' ' + add0(h) + ':' + add0(mm) + ':'
			+ add0(s);
};

// 开始绘制图表
var startChart = function(timeRange) {
	// 开始加载数据，显示loading图标
	$("body").mLoading({
		mask : false
	// 是否显示遮罩效果，默认显示
	});
	// 通过ajax获取数据
	$.getJSON("/api/get-redis-status-history-chart?id=" + id, {
		timeRange : timeRange
	},
			function(json) {
				var _xAxis = json.xAxis;
				var _seriesQps = json.seriesQps;
				var _seriesKeys = json.seriesKeys;
				var _seriesExpires = json.seriesExpires;
				var _seriesExpiredKeys = json.seriesExpiredKeys;
				var _seriesUsedMemory = json.seriesUsedMemory;
				var _seriesTotalMemory = json.seriesTotalMemory;
				var _seriesUsedPeakMemory = json.seriesUsedPeakMemory;
				var _seriesUsedRssMemory = json.seriesUsedRssMemory;
				var _seriesCpuSys = json.seriesCpuSys;
				var _seriesCpuUser = json.seriesCpuUser;
				var _seriesConnectedClients = json.seriesConnectedClients;
				var _seriesBlockedClients = json.seriesBlockedClients;
				var xAxis = [];
				var seriesQps = [];
				var seriesKeys = [];
				var seriesExpires = [];
				var seriesExpiredKeys = [];
				var seriesUsedMemory = [];
				var seriesTotalMemory = [];
				var seriesUsedPeakMemory = [];
				var seriesUsedRssMemory = [];
				var seriesCpuSys = [];
				var seriesCpuUser = [];
				var seriesConnectedClients = [];
				var seriesBlockedClients = [];
				// 一次将值填入数组
				for (var i = 0; i < _xAxis.length; i++) {
					xAxis.push(_xAxis[i]);
					seriesKeys.push(_seriesKeys[i]);
					seriesQps.push(_seriesQps[i]);
					seriesExpires.push(_seriesExpires[i]);
					seriesExpiredKeys.push(_seriesExpiredKeys[i]);
					seriesUsedMemory.push(_seriesUsedMemory[i]);
					seriesTotalMemory.push(_seriesTotalMemory[i]);
					seriesUsedPeakMemory.push(_seriesUsedPeakMemory[i]);
					seriesUsedRssMemory.push(_seriesUsedRssMemory[i]);
					seriesCpuSys.push(_seriesCpuSys[i]);
					seriesCpuUser.push(_seriesCpuUser[i]);
					seriesConnectedClients.push(_seriesConnectedClients[i]);
					seriesBlockedClients.push(_seriesBlockedClients[i]);
				}
				// 各图表绘制
				startQpsChart(xAxis, seriesQps);
				startKeysChart(xAxis, seriesKeys);
				startExpiresChart(xAxis, seriesExpires);
				startExpiredKeysChart(xAxis, seriesExpiredKeys);
				startUsedMemoryChart(xAxis, seriesUsedMemory,
						seriesTotalMemory, seriesUsedPeakMemory,
						seriesUsedRssMemory);
				startCpuUsageChart(xAxis, seriesCpuSys, seriesCpuUser);
				startConnCountChart(xAxis, seriesConnectedClients,
						seriesBlockedClients);
				// 加载数据完毕关闭loading图标
				$("body").mLoading("hide");
			});
}
// 开始绘制QPS图表
var startQpsChart = function(xAxis, seriesQps) {
	var colors = [ '#5793f3' ];
	// 加载QPS图表数据
	var qpsChart = echarts.init(document.getElementById('qpsChart'));
	// 指定图表的配置项和数据
	var optionQps = {
		color : colors,
		legend : {
			data : [ 'QPS' ]
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross',
				animation : false,
				label : {
					backgroundColor : '#505765'
				}
			}
		},
		grid : {
			left : '5%',
			right : '4%',
			bottom : 80
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : xAxis
		} ],
		yAxis : [ {
			name : 'QPS',
			type : 'value'
		} ],
		series : [ {
			name : 'QPS',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesQps
		}

		]
	};
	// 使用刚指定的配置项和数据显示图表。
	qpsChart.setOption(optionQps);
}
// 开始绘制Keys图表
var startKeysChart = function(xAxis, seriesKeys) {
	// 加载Keys图表数据
	var keysChart = echarts.init(document.getElementById('keysChart'));
	var colors = [ '#5793f3' ];
	// 指定图表的配置项和数据
	var optionKeys = {
		color : colors,
		legend : {
			data : [ 'Keys' ]
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross',
				animation : false,
				label : {
					backgroundColor : '#505765'
				}
			}
		},
		grid : {
			left : '5%',
			right : '4%',
			bottom : 80
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : xAxis
		} ],
		yAxis : [ {
			name : 'Keys',
			type : 'value'
		} ],
		series : [ {
			name : 'Keys',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesKeys
		}

		]
	};
	// 使用刚指定的配置项和数据显示图表。
	keysChart.setOption(optionKeys);
}
// 开始绘制Expires图表
var startExpiresChart = function(xAxis, seriesExpires) {
	// 加载Expires图表数据
	var expiresChart = echarts.init(document.getElementById('expiresChart'));
	var colors = [ '#5793f3' ];
	// 指定图表的配置项和数据
	var optionExpires = {
		color : colors,
		legend : {
			data : [ 'Expires' ]
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross',
				animation : false,
				label : {
					backgroundColor : '#505765'
				}
			}
		},
		grid : {
			left : '5%',
			right : '4%',
			bottom : 80
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : xAxis
		} ],
		yAxis : [ {
			name : 'Expires',
			type : 'value'
		} ],
		series : [ {
			name : 'Expires',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesExpires
		}

		]
	};
	// 使用刚指定的配置项和数据显示图表。
	expiresChart.setOption(optionExpires);
}
// 开始绘制ExpiredKeys图表
var startExpiredKeysChart = function(xAxis, seriesExpiredKeys) {
	// 加载ExpiredKeys图表数据
	var expiredKeysChart = echarts.init(document
			.getElementById('expiredKeysChart'));
	var colors = [ '#5793f3' ];
	// 指定图表的配置项和数据
	var optionExpiredKeys = {
		color : colors,
		legend : {
			data : [ 'ExpiredKeys' ]
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross',
				animation : false,
				label : {
					backgroundColor : '#505765'
				}
			}
		},
		grid : {
			left : '5%',
			right : '4%',
			bottom : 80
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : xAxis
		} ],
		yAxis : [ {
			name : 'ExpiredKeys',
			type : 'value'
		} ],
		series : [ {
			name : 'ExpiredKeys',
			type : 'line',
			stack : '',
			smooth : true,
			data : seriesExpiredKeys
		}

		]
	};
	// 使用刚指定的配置项和数据显示图表。
	expiredKeysChart.setOption(optionExpiredKeys);
}
// 开始绘制UsedMemory图表
var startUsedMemoryChart = function(xAxis, seriesUsedMemory, seriesTotalMemory,
		seriesUsedPeakMemory, seriesUsedRssMemory) {
	// 加载内存图表数据
	var usedMemoryChart = echarts.init(document.getElementById('usedMemory'));
	// 指定图表的配置项和数据
	var optionUsedMemory = {
		legend : {
			data : [ 'used_memory', 'used_memory_rss', 'used_memory_peak',
					'total_system_memory' ]
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross',
				animation : false,
				label : {
					backgroundColor : '#505765'
				}
			}
		},
		grid : {
			left : '5%',
			right : '4%',
			bottom : 80
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : xAxis
		} ],
		yAxis : [ {
			name : '内存占用(MB)',
			type : 'value'
		} ],

		series : [ {
			name : 'used_memory',
			type : 'line',
			smooth : true,
			data : seriesUsedMemory
		}, {
			name : 'used_memory_rss',
			type : 'line',
			smooth : true,
			data : seriesUsedRssMemory
		}, {
			name : 'used_memory_peak',
			type : 'line',
			smooth : true,
			data : seriesUsedPeakMemory
		}, {
			name : 'total_system_memory',
			showSymbol : false,
			type : 'line',
			smooth : true,
			data : seriesTotalMemory
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	usedMemoryChart.setOption(optionUsedMemory);
}
// 开始绘制CpuUsage图表
var startCpuUsageChart = function(xAxis, seriesCpuSys, seriesCpuUser) {
	// 加载内存图表数据
	var cpuUsageChart = echarts.init(document.getElementById('cpuUsage'));
	// 指定图表的配置项和数据
	var optionCpuUsage = {
		legend : {
			data : [ 'used_cpu_sys', 'used_cpu_user' ]
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross',
				animation : false,
				label : {
					backgroundColor : '#505765'
				}
			}
		},
		grid : {
			left : '5%',
			right : '4%',
			bottom : 80
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : xAxis
		} ],
		yAxis : [ {
			name : 'CpuUsage',
			type : 'value'
		} ],

		series : [ {
			name : 'used_cpu_sys',
			type : 'line',
			smooth : true,
			data : seriesCpuSys
		}, {
			name : 'used_cpu_user',
			type : 'line',
			smooth : true,
			data : seriesCpuUser
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	cpuUsageChart.setOption(optionCpuUsage);
}
// 开始绘制ConnCount图表
var startConnCountChart = function(xAxis, seriesConnectedClients,
		seriesBlockedClients) {
	// 加载内存图表数据
	var connCountChart = echarts.init(document.getElementById('connCount'));
	// 指定图表的配置项和数据
	var optionConnCount = {
		legend : {
			data : [ 'connected_clients', 'blocked_clients' ]
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : {
				type : 'cross',
				animation : false,
				label : {
					backgroundColor : '#505765'
				}
			}
		},
		grid : {
			left : '5%',
			right : '4%',
			bottom : 80
		},
		xAxis : [ {
			type : 'category',
			boundaryGap : false,
			data : xAxis
		} ],
		yAxis : [ {
			name : 'ConnCount',
			type : 'value'
		} ],

		series : [ {
			name : 'connected_clients',
			type : 'line',
			smooth : true,
			data : seriesConnectedClients
		}, {
			name : 'blocked_clients',
			type : 'line',
			smooth : true,
			data : seriesBlockedClients
		} ]
	};

	// 使用刚指定的配置项和数据显示图表。
	connCountChart.setOption(optionConnCount);
}
