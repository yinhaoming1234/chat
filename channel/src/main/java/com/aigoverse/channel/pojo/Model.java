package com.aigoverse.channel.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("model")
@Data
public class Model {
    private Long id;
    private String name;

}
