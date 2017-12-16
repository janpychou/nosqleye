package cn.org.openwork.nosql.bean;

public class RedisDataTypeList implements RedisDataType
{
    private String value;

    
    public RedisDataTypeList(String value)
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
