CREATE TABLE IF NOT EXISTS `patron` (
  `patron_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `local_address_city` varchar(255) DEFAULT NULL,
  `local_address_line1` varchar(255) DEFAULT NULL,
  `local_address_line2` varchar(255) DEFAULT NULL,
  `local_address_state` varchar(255) DEFAULT NULL,
  `local_address_zip_code` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `permanent_address_city` varchar(255) DEFAULT NULL,
  `permanent_address_line1` varchar(255) DEFAULT NULL,
  `permanent_address_line2` varchar(255) DEFAULT NULL,
  `permanent_address_state` varchar(255) DEFAULT NULL,
  `permanent_address_zip_code` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`patron_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `copy` (
  `copy_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) DEFAULT NULL,
  `author_first` varchar(255) DEFAULT NULL,
  `author_last` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `due_date` tinyblob,
  `last_to_check_out` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`copy_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `copies_out` (
  `check_out_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `patron_id` bigint(20) NOT NULL,
  `copy_id` bigint(20) NOT NULL,
  PRIMARY KEY (`check_out_id`),
  UNIQUE KEY `UK_3al8262x1exf5b1fhwlat8qd0` (`copy_id`),
  UNIQUE KEY `patron_id_UNIQUE` (`patron_id`),
  KEY `FKrhb9a2xrih0jsyo1h0dhgeib3` (`patron_id`),
  CONSTRAINT `FKrhb9a2xrih0jsyo1h0dhgeib3` FOREIGN KEY (`patron_id`) REFERENCES `patron` (`patron_id`),
  CONSTRAINT `FKv5etuq7qk7j5dsskkd1s7jen` FOREIGN KEY (`copy_id`) REFERENCES `copy` (`copy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;






