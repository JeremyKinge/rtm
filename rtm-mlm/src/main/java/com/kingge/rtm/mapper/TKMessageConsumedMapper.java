package com.kingge.rtm.mapper;

import com.kingge.rtm.pojo.TKMessageConsumed;
import com.kingge.rtm.pojo.TKMessageConsumedExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TKMessageConsumedMapper {
    int countByExample(TKMessageConsumedExample example);

    int deleteByExample(TKMessageConsumedExample example);

    int deleteByPrimaryKey(String msgId);

    int insert(TKMessageConsumed record);

    int insertSelective(TKMessageConsumed record);

    List<TKMessageConsumed> selectByExample(TKMessageConsumedExample example);

    TKMessageConsumed selectByPrimaryKey(String msgId);

    int updateByExampleSelective(@Param("record") TKMessageConsumed record, @Param("example") TKMessageConsumedExample example);

    int updateByExample(@Param("record") TKMessageConsumed record, @Param("example") TKMessageConsumedExample example);

    int updateByPrimaryKeySelective(TKMessageConsumed record);

    int updateByPrimaryKey(TKMessageConsumed record);
}