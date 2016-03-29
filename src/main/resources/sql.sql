use train;
DROP TABLE IF EXISTS `t_station_train`;
CREATE TABLE `t_station_train` (
  `id_` int(11) NOT NULL auto_increment,
  `file_id_` varchar(255) default NULL,
  `date_` datetime default NULL,
  `serial_num_` varchar(255) default NULL,
  `train_num_` varchar(255) default NULL,
  `train_type_` varchar(255) default NULL,
  `change_long_` double default NULL,
  `self_weight_` double default NULL,
  `load_weight_` double default NULL,
  `goods_name_` varchar(255) default NULL,
  `from_station_` varchar(255) default NULL,
  `to_station_` varchar(255) default NULL,
  `from_bureau_` varchar(255) default NULL,
  `to_bureau_` varchar(255) default NULL,
  `consignee_` varchar(255) default NULL,
  PRIMARY KEY  (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_source_file`;
CREATE TABLE `t_source_file` (
  `id_` int(11) NOT NULL auto_increment,
  `file_id_` varchar(255) default NULL,
  `file_name_` varchar(255) default NULL,
  `file_path_` varchar(255) default NULL,
  `md5_` varchar(255) default NULL,
  `upload_time_` datetime default NULL,
  PRIMARY KEY  (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_result_file`;
CREATE TABLE `t_result_file` (
  `id_` int(11) NOT NULL auto_increment,
  `src_file_id_` varchar(255) default NULL,
  `file_path_` varchar(255) default NULL,
  `file_name_` varchar(255) default NULL,
  `create_time_` datetime default NULL,
  PRIMARY KEY  (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `t_from_filter`;
CREATE TABLE `t_from_filter` (
  `id_` int(11) NOT NULL auto_increment,
  `code_` varchar(255) default NULL,
  `create_time_` datetime default NULL,
  PRIMARY KEY  (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;








