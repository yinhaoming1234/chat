package com.aigoverse.channel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.aigoverse.channel.mapper")
public class ChannelBoot {

    public static void main(String[] args) {
        //springboot启动
        SpringApplication.run(ChannelBoot.class, args);

    }
}
