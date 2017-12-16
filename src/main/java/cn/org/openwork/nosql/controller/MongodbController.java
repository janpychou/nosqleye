/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  MongoDBController.java   
 * @Package cn.org.openwork.nosql.controller   
 * @Description:    MondoDB Controller
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月7日 下午1:46:04   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.org.openwork.nosql.service.MongodbService;

/**
 * @ClassName: MongoDBController
 * @Description:MondoDB Controller
 * @author: 李平(360841519@qq.com)
 * @date: 2017年7月7日 下午1:46:04
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
@RestController
@RequestMapping(value = "/api")
public class MongodbController
{
    @Resource
    private MongodbService mongodbService;
    
    /**
     * 获取MongoDB服务器列表
     * @Title: getMongodbList   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-mongodb-list")
    public Object getMongodbList(HttpServletRequest request, HttpServletResponse response)
    {
        int draw = Integer.parseInt(request.getParameter("draw"));
        int startIndex = Integer.parseInt(request.getParameter("start"));
        int pageSize = Integer.parseInt(request.getParameter("length"));
        return mongodbService.getMongodbList(draw, startIndex, pageSize);
    }
    
    /**
     * 删除MongoDB服务器
     * @Title: deleteMongodb   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/delete-mongodb")
    public Object deleteMongodb(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return mongodbService.deleteMongodb(id);
    }
    
    /**
     * 获取MongoDB服务器数量
     * @Title: countMongodb   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/count-mongodb")
    public Object countMongodb(HttpServletRequest request, HttpServletResponse response)
    {
        return mongodbService.countMongodb();
    }
    
    /**
     * 保存MongoDB服务器信息
     * @Title: saveMongodb   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/save-mongodb")
    public Object saveMongodb(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        String host = request.getParameter("host");
        String port = request.getParameter("port");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tags = request.getParameter("tags");
        return mongodbService.saveMongodb(id, host, port, username, password, tags);
    }
    
    /**
     * 获取MongoDB服务器信息
     * @Title: getMongodb   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-mongodb")
    public Object getMongodb(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return mongodbService.getMongodb(id);
    }
    
    /**
     * 获取MongoDB服务器概要信息
     * @Title: getMongodbOverview   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-mongodb-overview")
    public Object getMongodbOverview(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return mongodbService.getMongodbOverview(id);
    }
    
    /**
     * 获取MongoDB运行状态指标
     * @Title: getMongodbTopNs   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-mongodb-top-ns")
    public Object getMongodbTopNs(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return mongodbService.getMongodbTopNs(id);
    }
    
    /**
     * 获取MongoDB指定名称空间的运行状态历史记录
     * @Title: getMongodbTopHistory   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-mongodb-top-history")
    public Object getMongodbTopHistory(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        String ns = request.getParameter("ns");
        return mongodbService.getMongodbTopHistory(id, ns);
    }
    
    /**
     * 获取MongoDB数据库列表
     * @Title: getMongodbListDatabases   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-mongodb-listdatabases")
    public Object getMongodbListDatabases(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return mongodbService.getMongodbListDatabases(id);
    }
    
    /**
     * 获取MongoDB 主机信息
     * @Title: getMongodbHostInfo   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-mongodb-hostinfo")
    public Object getMongodbHostInfo(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return mongodbService.getMongodbHostInfo(id);
    }
    
    /**
     * 获取MongoDB复制状态信息
     * @Title: getMongodbReplSetGetStatus   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-mongodb-replsetgetstatus")
    public Object getMongodbReplSetGetStatus(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return mongodbService.getMongodbReplSetGetStatus(id);
    }
    
    /**
     * 获取MongoDB复制配置
     * @Title: getMongodbReplSetGetConfig   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-mongodb-replsetgetconfig")
    public Object getMongodbReplSetGetConfig(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return mongodbService.getMongodbReplSetGetConfig(id);
    }
    
    /**
     * 获取MongoDB锁信息
     * @Title: getMongodbLockInfo   
     * @param request
     * @param response
     * @return        
     * @throws
     */
    @RequestMapping(value = "/get-mongodb-lockinfo")
    public Object getMongodbLockInfo(HttpServletRequest request, HttpServletResponse response)
    {
        Long id = Long.valueOf(request.getParameter("id"));
        return mongodbService.getMongodbLockInfo(id);
    }
}
