/*
 @Data
public class ChannelToModel {
    Long id;
    Long channelId;
    Long modelId;
}

 */

DROP TABLE IF EXISTS `channel_to_model`;
CREATE TABLE `channel_to_model` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_id` bigint(20) DEFAULT NULL,
  `model_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;