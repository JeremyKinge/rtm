package com.kingge.rtm.mapper;

import com.kingge.rtm.pojo.TKDeadMessage;
import com.kingge.rtm.pojo.TKDeadMessageExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TKDeadMessageMapper {
    int countByExample(TKDeadMessageExample example);

    int deleteByExample(TKDeadMessageExample example);

    int deleteByPrimaryKey(String msgId);

    int insert(TKDeadMessage record);

    int insertSelective(TKDeadMessage record);

    List<TKDeadMessage> selectByExample(TKDeadMessageExample example);

    TKDeadMessage selectByPrimaryKey(String msgId);

    int updateByExampleSelective(@Param("record") TKDeadMessage record, @Param("example") TKDeadMessageExample example);

    int updateByExample(@Param("record") TKDeadMessage record, @Param("example") TKDeadMessageExample example);

    int updateByPrimaryKeySelective(TKDeadMessage record);

    int updateByPrimaryKey(TKDeadMessage record);
}