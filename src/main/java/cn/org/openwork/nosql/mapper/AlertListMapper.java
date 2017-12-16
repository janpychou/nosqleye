package cn.org.openwork.nosql.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.org.openwork.nosql.bean.AlertList;
import cn.org.openwork.nosql.bean.AlertListExample;

@Mapper
public interface AlertListMapper {
    int countByExample(AlertListExample example);

    int deleteByExample(AlertListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlertList record);

    int insertSelective(AlertList record);

    List<AlertList> selectByExample(AlertListExample example);

    AlertList selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlertList record, @Param("example") AlertListExample example);

    int updateByExample(@Param("record") AlertList record, @Param("example") AlertListExample example);

    int updateByPrimaryKeySelective(AlertList record);

    int updateByPrimaryKey(AlertList record);
}