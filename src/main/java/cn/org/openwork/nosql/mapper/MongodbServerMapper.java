package cn.org.openwork.nosql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.org.openwork.nosql.bean.MongodbServer;
import cn.org.openwork.nosql.bean.MongodbServerExample;

@Mapper
public interface MongodbServerMapper {
    int countByExample(MongodbServerExample example);

    int deleteByExample(MongodbServerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MongodbServer record);

    int insertSelective(MongodbServer record);

    List<MongodbServer> selectByExample(MongodbServerExample example);

    MongodbServer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MongodbServer record, @Param("example") MongodbServerExample example);

    int updateByExample(@Param("record") MongodbServer record, @Param("example") MongodbServerExample example);

    int updateByPrimaryKeySelective(MongodbServer record);

    int updateByPrimaryKey(MongodbServer record);
}