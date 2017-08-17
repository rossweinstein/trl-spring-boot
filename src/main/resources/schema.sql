CREATE TABLE IF NOT EXISTS `patron` (
  `patron_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `middle_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL,
  `contact` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`patron_id`),
  KEY `contact_id_idx` (`contact`),
  KEY `contact_idx` (`contact`),
  CONSTRAINT `contact` FOREIGN KEY (`contact`) REFERENCES `contact` (`contact_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `copy` (
  `copy_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(255) DEFAULT NULL,
  `author_first` varchar(255) DEFAULT NULL,
  `author_last` varchar(255) DEFAULT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `publisher` bigint(20) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `due_date` tinyblob,
  `last_to_check_out` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`copy_id`),
  KEY `publisher_idx` (`publisher`),
  KEY `last_to_check_out_idx` (`last_to_check_out`),
  CONSTRAINT `last_to_check_out` FOREIGN KEY (`last_to_check_out`) REFERENCES `patron` (`patron_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `publisher` FOREIGN KEY (`publisher`) REFERENCES `publisher` (`publisher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


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

CREATE TABLE IF NOT EXISTS `contact` (
  `contact_id` bigint(20) NOT NULL,
  `address_line1` varchar(255) NOT NULL,
  `address_line2` varchar(255) DEFAULT NULL,
  `address_city` varchar(255) NOT NULL,
  `address_state` varchar(255) NOT NULL,
  `address_zip_code` varchar(255) NOT NULL,
  `phone_number` varchar(255) NOT NULL,
  `email_address` varchar(255) NOT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `publisher` (
  `publisher_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `contact` bigint(20) NOT NULL,
  PRIMARY KEY (`publisher_id`),
  KEY `contact_id_idx` (`contact`),
  CONSTRAINT `contact_id` FOREIGN KEY (`contact`) REFERENCES `contact` (`contact_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





