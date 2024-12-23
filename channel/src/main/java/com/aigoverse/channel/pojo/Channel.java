package com.aigoverse.channel.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("`channel`")
@Data
public class Channel {
    private Long id;
    private String name;
    private String type;
    private Integer priority;
    private Integer weight;
    private Integer retry;
    private String secret;
    private String endpoint;
    private String mapper;
    private Boolean state;
    private String proxy;
    private Integer proxy_type;
    private String username;
    private String password;
}
