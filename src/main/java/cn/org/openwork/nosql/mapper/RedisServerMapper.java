package cn.org.openwork.nosql.mapper;

import cn.org.openwork.nosql.bean.RedisServer;
import cn.org.openwork.nosql.bean.RedisServerExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RedisServerMapper {
    int countByExample(RedisServerExample example);

    int deleteByExample(RedisServerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RedisServer record);

    int insertSelective(RedisServer record);

    List<RedisServer> selectByExample(RedisServerExample example);

    RedisServer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RedisServer record, @Param("example") RedisServerExample example);

    int updateByExample(@Param("record") RedisServer record, @Param("example") RedisServerExample example);

    int updateByPrimaryKeySelective(RedisServer record);

    int updateByPrimaryKey(RedisServer record);
}