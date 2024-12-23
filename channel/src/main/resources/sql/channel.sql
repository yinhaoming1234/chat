/*
 package com.aigoverse.channel.pojo;

import lombok.Data;


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
    private String channel;
    private Boolean state;
    private String proxy;
    private Integer proxy_type;
    private String username;
    private String password;
}
 */

use chatai;
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `retry` int(11) DEFAULT NULL,
  `secret` varchar(255) DEFAULT NULL,
  `endpoint` varchar(255) DEFAULT NULL,
  `mapper` varchar(255) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `proxy` varchar(255) DEFAULT NULL,
  `proxy_type` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;