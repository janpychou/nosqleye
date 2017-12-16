/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  MongodbDbDto.java   
 * @Package cn.org.openwork.nosql.bean   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月7日 下午5:51:37   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.bean;

/**
 * @ClassName: MongodbDbDto
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年7月7日 下午5:51:37
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class MongodbDbDto {
    private String db;
    private String collections;
    private String indexes;
    private String indexSize;
    private String dataSize;

    /**
     * @return the db
     */
    public String getDb() {
	return db;
    }

    /**
     * @param db
     *            the db to set
     */
    public void setDb(String db) {
	this.db = db;
    }

    /**
     * @return the collections
     */
    public String getCollections() {
	return collections;
    }

    /**
     * @param collections
     *            the collections to set
     */
    public void setCollections(String collections) {
	this.collections = collections;
    }

    /**
     * @return the indexes
     */
    public String getIndexes() {
	return indexes;
    }

    /**
     * @param indexes
     *            the indexes to set
     */
    public void setIndexes(String indexes) {
	this.indexes = indexes;
    }

    /**
     * @return the indexSize
     */
    public String getIndexSize() {
	return indexSize;
    }

    /**
     * @param indexSize
     *            the indexSize to set
     */
    public void setIndexSize(String indexSize) {
	this.indexSize = indexSize;
    }

    /**
     * @return the dataSize
     */
    public String getDataSize() {
	return dataSize;
    }

    /**
     * @param dataSize
     *            the dataSize to set
     */
    public void setDataSize(String dataSize) {
	this.dataSize = dataSize;
    }
}
