package cn.org.openwork.nosql.bean;

public class RedisKeysDto implements RedisDataType
{
    private String key;
    private String type;
    private String size;
    private String expires;
    
    public RedisKeysDto(String key, String type, String size, String expires)
    {
        super();
        this.key = key;
        this.type = type;
        this.size = size;
        this.expires = expires;
    }
    /**
     * @return the key
     */
    public String getKey()
    {
        return key;
    }
    /**
     * @param key the key to set
     */
    public void setKey(String key)
    {
        this.key = key;
    }
    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }
    /**
     * @return the size
     */
    public String getSize()
    {
        return size;
    }
    /**
     * @param size the size to set
     */
    public void setSize(String size)
    {
        this.size = size;
    }
    /**
     * @return the expires
     */
    public String getExpires()
    {
        return expires;
    }
    /**
     * @param expires the expires to set
     */
    public void setExpires(String expires)
    {
        this.expires = expires;
    }
    
}
