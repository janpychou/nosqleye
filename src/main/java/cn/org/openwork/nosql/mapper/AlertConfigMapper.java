package cn.org.openwork.nosql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.org.openwork.nosql.bean.AlertConfig;
import cn.org.openwork.nosql.bean.AlertConfigExample;

@Mapper
public interface AlertConfigMapper {
    int countByExample(AlertConfigExample example);

    int deleteByExample(AlertConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlertConfig record);

    int insertSelective(AlertConfig record);

    List<AlertConfig> selectByExample(AlertConfigExample example);

    AlertConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlertConfig record, @Param("example") AlertConfigExample example);

    int updateByExample(@Param("record") AlertConfig record, @Param("example") AlertConfigExample example);

    int updateByPrimaryKeySelective(AlertConfig record);

    int updateByPrimaryKey(AlertConfig record);
}