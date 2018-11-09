
CREATE TABLE siyue_sms (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  cellphone varchar(50)  COMMENT '手机号码',
  content text  COMMENT '发送内容',
  status tinyint(1)  DEFAULT '0' COMMENT '状态',
  type varchar(20)  COMMENT '类型',
  create_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (id)
) COMMENT='短信表';

CREATE TABLE siyue_sms_type (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  platform varchar(50) COMMENT '平台code',
  name varchar(50) COMMENT '平台名',
  content text  COMMENT '短信内容',
  type tinyint(1)  COMMENT '类型',
  create_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (id)
) COMMENT='短信类型表';






