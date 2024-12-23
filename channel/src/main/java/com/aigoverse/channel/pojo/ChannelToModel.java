package com.aigoverse.channel.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("`channel_to_model`")
@Data
public class ChannelToModel {
    Long id;
    Long channelId;
    Long modelId;
}
