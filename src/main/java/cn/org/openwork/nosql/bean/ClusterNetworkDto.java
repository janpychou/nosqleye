/**  
 * All rights Reserved, Designed By www.mycat.io
 * @Title:  ClusterNetWorkDto.java   
 * @Package io.mycat.eye.agent.dto   
 * @Description:    集群拓扑节点数据对象
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年8月16日 下午2:39:15   
 * @version V1.0 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.bean;

import java.util.List;


/**   
 * @ClassName:  ClusterNetWorkDto   
 * @Description:集群拓扑节点数据对象
 * @author: 李平(360841519@qq.com)
 * @date:   2017年8月16日 下午2:39:15   
 *     
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved. 
 */
public class ClusterNetworkDto
{
    private List<RedisServerStatus> redisServerStatus;
    private List<Relation> relations;
    /**
     * @return the redisServerStatus
     */
    public List<RedisServerStatus> getRedisServerStatus()
    {
        return redisServerStatus;
    }
    /**
     * @param redisServerStatus the redisServerStatus to set
     */
    public void setRedisServerStatus(List<RedisServerStatus> redisServerStatus)
    {
        this.redisServerStatus = redisServerStatus;
    }
    /**
     * @return the relations
     */
    public List<Relation> getRelations()
    {
        return relations;
    }
    /**
     * @param relations the relations to set
     */
    public void setRelations(List<Relation> relations)
    {
        this.relations = relations;
    }
}
