package cn.org.openwork.nosql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.org.openwork.nosql.bean.RedisCluster;
import cn.org.openwork.nosql.bean.RedisClusterExample;

@Mapper
public interface RedisClusterMapper {
    int countByExample(RedisClusterExample example);

    int deleteByExample(RedisClusterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RedisCluster record);

    int insertSelective(RedisCluster record);

    List<RedisCluster> selectByExample(RedisClusterExample example);

    RedisCluster selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RedisCluster record, @Param("example") RedisClusterExample example);

    int updateByExample(@Param("record") RedisCluster record, @Param("example") RedisClusterExample example);

    int updateByPrimaryKeySelective(RedisCluster record);

    int updateByPrimaryKey(RedisCluster record);
}