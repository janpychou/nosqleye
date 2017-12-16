/**  
 * All rights Reserved, Designed By www.openwork.org.cn
 * @Title:  MongodbListDatabases.java   
 * @Package cn.org.openwork.nosql.bean   
 * @Description:    TODO 
 * @author: 李平(360841519@qq.com)    
 * @date:   2017年7月11日 下午4:54:22   
 * @version V1.0 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved. 
 */
package cn.org.openwork.nosql.bean;

/**
 * @ClassName: MongodbListDatabases
 * @Description:TODO
 * @author: 李平(360841519@qq.com)
 * @date: 2017年7月11日 下午4:54:22
 * 
 * @Copyright: 2017 www.openwork.org.cn Inc. All rights reserved.
 */
public class MongodbListDatabasesDto {
    private String name;
    private String sizeOnDisk;

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the sizeOnDisk
     */
    public String getSizeOnDisk() {
	return sizeOnDisk;
    }

    /**
     * @param sizeOnDisk
     *            the sizeOnDisk to set
     */
    public void setSizeOnDisk(String sizeOnDisk) {
	this.sizeOnDisk = sizeOnDisk;
    }

}
