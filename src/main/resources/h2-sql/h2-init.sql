

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增长',
  `name`varchar(20) NOT NULL COMMENT '姓名',
  `age`varchar(20) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`),
);

INSERT into test set name = 'maple' , age = '20';
INSERT into test set name = 'struy' , age = '21';
INSERT into test set name = 'ever' , age = '22';

