package com.kingge.rtm.mapper;

import com.kingge.rtm.pojo.TKMessage;
import com.kingge.rtm.pojo.TKMessageExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TKMessageMapper {
    int countByExample(TKMessageExample example);

    int deleteByExample(TKMessageExample example);

    int deleteByPrimaryKey(String msgId);

    int insert(TKMessage record);

    int insertSelective(TKMessage record);

    List<TKMessage> selectByExample(TKMessageExample example);

    List<TKMessage> pageByExample(TKMessageExample example);

    TKMessage selectByPrimaryKey(String msgId);

    int updateByExampleSelective(@Param("record") TKMessage record, @Param("example") TKMessageExample example);

    int updateByExample(@Param("record") TKMessage record, @Param("example") TKMessageExample example);

    int updateByPrimaryKeySelective(TKMessage record);

    int updateByPrimaryKey(TKMessage record);
}