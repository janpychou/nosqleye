package cn.org.openwork.nosql.bean;

public class RedisDataTypeSet implements RedisDataType
{
    private String value;

    
    public RedisDataTypeSet(String value)
    {
        super();
        this.value = value;
    }

    /**
     * @return the value
     */
    public String getValue()
    {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value)
    {
        this.value = value;
    }
}
