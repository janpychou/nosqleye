package cn.org.openwork.nosql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.org.openwork.nosql.bean.RedisStatusHistory;
import cn.org.openwork.nosql.bean.RedisStatusHistoryExample;

@Mapper
public interface RedisStatusHistoryMapper {
    int countByExample(RedisStatusHistoryExample example);

    int deleteByExample(RedisStatusHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RedisStatusHistory record);

    int insertSelective(RedisStatusHistory record);

    List<RedisStatusHistory> selectByExample(RedisStatusHistoryExample example);

    RedisStatusHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RedisStatusHistory record, @Param("example") RedisStatusHistoryExample example);

    int updateByExample(@Param("record") RedisStatusHistory record, @Param("example") RedisStatusHistoryExample example);

    int updateByPrimaryKeySelective(RedisStatusHistory record);

    int updateByPrimaryKey(RedisStatusHistory record);
}