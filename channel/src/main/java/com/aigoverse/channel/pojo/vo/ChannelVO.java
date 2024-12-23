package com.aigoverse.channel.pojo.vo;

import lombok.Data;
import com.aigoverse.channel.pojo.Proxy;

import java.util.List;

/*
export type Channel = {
  id: number;
  name: string;
  type: string;
  models: string[];
  priority: number;
  weight: number;
  retry: number;
  secret: string;
  endpoint: string;
  com.aigoverse.channel.mapper: string;
  state: boolean;
  group?: string[];
  proxy?: {
    proxy: string;
    proxy_type: number;
    username: string;
    password: string;
  };
};
 */
@Data
public class ChannelVO {
    private Long id;
    private String name;
    private String type;
    private List<String> models;
    private Integer priority;
    private Integer weight;
    private Integer retry;
    private String secret;
    private String endpoint;
    private String mapper;
    private Boolean state;
    private List<String>group;
    private Proxy proxy;


}
