package com.aigoverse.channel.mapper;

import com.aigoverse.channel.pojo.Model;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ModelMapper extends BaseMapper<Model> {
    @Select("select model.id,model.name from model join channel_to_model ctm on model.id = ctm.model_id where ctm.channel_id = #{id}")
    List<Model> selectListByChannelId(Long id);
}
