/*
 @TableName("model")
@Data
public class model {
    private Long id;
    private String name;

}
 */
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;