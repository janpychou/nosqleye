/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  MongoDBUtil.java   
 * @Package cn.org.openwork.nosql.util   
 * @Description:    mongodb工具类
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月7日 上午9:28:28   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import cn.org.openwork.nosql.bean.MongodbServer;

/**   
 * @ClassName:  MongoDBUtil   
 * @Description:mongodb工具类
 * @author: 李平(360841519@qq.com)
 * @date:   2017年7月7日 上午9:28:28   
 *     
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
public class MongodbUtil
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MongodbUtil.class);
    
    /**
     * 获取命令结果集
     * @Title: getMongodbCommandResult   
     * @param mongodbServer
     * @param dbObject
     * @return        
     * @throws
     */
    public JSONObject getMongodbCommandResult(MongodbServer mongodbServer, DBObject dbObject)
    {
        String host = mongodbServer.getHost();
        String port = mongodbServer.getPort();
        String username = mongodbServer.getUsername();
        String password = mongodbServer.getPassword();
        return getMongodbCommandResult(host, port, username, password, dbObject);
    }
    
    /**
     * 获取命令结果集
     * @Title: getMongodbCommandResult   
     * @param host
     * @param port
     * @param username
     * @param password
     * @param dbObject
     * @return        
     * @throws
     */
    public JSONObject getMongodbCommandResult(String host, String port, String username, String password,
        DBObject dbObject)
    {
        String sURI = "";
        if ((username == null || username.isEmpty()) && (password == null || password.isEmpty()))
        {
            sURI = String.format("mongodb://" + host + ":" + port);
        }
        else
        {
            sURI = String.format("mongodb://" + username + ":" + password + "@" + host + ":" + port);
        }
        DB db = null;
        MongoClient mongoClient = null;
        JSONObject jsonObject = null;
        try
        {
            MongoClientURI uri = new MongoClientURI(sURI);
            mongoClient = new MongoClient(uri);
            // 设置连接超时时间
            List<String> databaseNames = mongoClient.getDatabaseNames();
            if (!databaseNames.isEmpty())
            {
                //      db = mongoClient.getDB(databaseNames.get(0));
                db = mongoClient.getDB("admin");
                CommandResult commandResult = db.command(dbObject);
                String json = commandResult.toJson();
                jsonObject = JSONObject.parseObject(json);
            }
        }
        catch (Exception e)
        {
            LOGGER.error(e.getMessage());
        }
        finally
        {
            mongoClient.close();
        }
        return jsonObject;
    }
}
