/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  MongoDBService.java   
 * @Package cn.org.openwork.nosql.service   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月7日 下午1:47:32   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.service;

import java.util.List;

import cn.org.openwork.nosql.bean.MongodbHostInfoDto;
import cn.org.openwork.nosql.bean.MongodbListDatabasesDto;
import cn.org.openwork.nosql.bean.MongodbOverviewDto;
import cn.org.openwork.nosql.bean.MongodbServer;
import cn.org.openwork.nosql.bean.MongodbServerDto;
import cn.org.openwork.nosql.bean.MongodbTopHistory;
import cn.org.openwork.nosql.bean.PagedDto;
import cn.org.openwork.nosql.bean.RestResponse;

/**   
 * @ClassName:  MongoDBService   
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date:   2017年7月7日 下午1:47:32   
 *     
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
public interface MongodbService {
    /**
     * 获取mongodb列表
     * @Title: getMongodbList   
     * @param draw
     * @param startIndex
     * @param pageSize
     * @return        
     * @throws
     */
    public PagedDto<MongodbServerDto> getMongodbList(int draw, int startIndex, int pageSize);
    
    /**
     * 删除mongodb节点
     * @Title: deleteMongodb   
     * @param id
     * @return        
     * @throws
     */
    public RestResponse<String> deleteMongodb(Long id);
    
    /**
     * 保存mongodb节点信息
     * @Title: saveMongodb   
     * @param id
     * @param host
     * @param port
     * @param username
     * @param password
     * @param tags
     * @return        
     * @throws
     */
    public RestResponse<String> saveMongodb(Long id,String host,String port,String username,String password, String tags);
    
    /**
     * 获取mongodb节点数量
     * @Title: countMongodb   
     * @return        
     * @throws
     */
    public RestResponse<Integer> countMongodb();
    
    /**
     * 获取mongodb节点信息
     * @Title: getMongodb   
     * @param id
     * @return        
     * @throws
     */
    public RestResponse<MongodbServer> getMongodb(Long id);
    
    /**
     * 获取mongodb基础信息
     * @Title: getMongodbOverview   
     * @param id
     * @return        
     * @throws
     */
    public PagedDto<MongodbOverviewDto> getMongodbOverview(Long id);
    
    /**
     * 获取mongodb top命令名称空间
     * @Title: getMongodbTopNs   
     * @param id
     * @return        
     * @throws
     */
    public List<String> getMongodbTopNs(Long id);
    
    /**
     * 获取top命令指标
     * @Title: getMongodbTopHistory   
     * @param id
     * @param ns
     * @return        
     * @throws
     */
    public PagedDto<MongodbTopHistory> getMongodbTopHistory(Long id,String ns);
    
    /**
     * 获取mongodb数据库列表
     * @Title: getMongodbListDatabases   
     * @param id
     * @return        
     * @throws
     */
    public PagedDto<MongodbListDatabasesDto> getMongodbListDatabases(Long id);
    
    /**
     * 获取mongodb服务器信息
     * @Title: getMongodbHostInfo   
     * @param id
     * @return        
     * @throws
     */
    public PagedDto<MongodbHostInfoDto> getMongodbHostInfo(Long id);
    /**
     * 获取复制状态
     * @Title: getMongodbReplSetGetStatus   
     * @param id
     * @return        
     * @throws
     */
    public Object getMongodbReplSetGetStatus(Long id);
    
    /**
     * 获取复制配置
     * @Title: getMongodbReplSetGetConfig   
     * @param id
     * @return        
     * @throws
     */
    public Object getMongodbReplSetGetConfig(Long id);
    /**
     * 获取锁信息
     * @Title: getMongodbLockInfo   
     * @param id
     * @return        
     * @throws
     */
    public Object getMongodbLockInfo(Long id);
}
