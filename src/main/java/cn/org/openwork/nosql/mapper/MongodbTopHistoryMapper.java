package cn.org.openwork.nosql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.org.openwork.nosql.bean.MongodbTopHistory;
import cn.org.openwork.nosql.bean.MongodbTopHistoryExample;

@Mapper
public interface MongodbTopHistoryMapper {
    int countByExample(MongodbTopHistoryExample example);

    int deleteByExample(MongodbTopHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MongodbTopHistory record);

    int insertSelective(MongodbTopHistory record);

    List<MongodbTopHistory> selectByExample(MongodbTopHistoryExample example);

    MongodbTopHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MongodbTopHistory record, @Param("example") MongodbTopHistoryExample example);

    int updateByExample(@Param("record") MongodbTopHistory record, @Param("example") MongodbTopHistoryExample example);

    int updateByPrimaryKeySelective(MongodbTopHistory record);

    int updateByPrimaryKey(MongodbTopHistory record);
}