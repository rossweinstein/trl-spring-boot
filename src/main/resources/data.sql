
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `textbook_rental_library`.`patron`;
TRUNCATE `textbook_rental_library`.`copy`;
TRUNCATE `textbook_rental_library`.`copies_out`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `textbook_rental_library`.`copy`
(`copy_id`, `isbn`, `author_first`, `author_last`, `genre`,
 `publisher`, `sub_title`, `title`, `due_date`, `last_to_check_out`)
VALUES
  (null, '9780954657673', 'Robin', 'Price', 'FICTION',
   'Mogzilla', 'A Spartapuss Tale', 'Die Clawdius', null, '0');

INSERT INTO `textbook_rental_library`.`copy`
(`copy_id`, `isbn`, `author_first`, `author_last`, `genre`,
 `publisher`, `sub_title`, `title`, `due_date`, `last_to_check_out`)
VALUES
  (null, '9781617290657', 'Paul', 'Chiusano', 'TECHNOLOGY',
   'Manning', '', 'Functional Programming in Scala', null, '0');

INSERT INTO `textbook_rental_library`.`copy`
(`copy_id`, `isbn`, `author_first`, `author_last`, `genre`,
 `publisher`, `sub_title`, `title`, `due_date`, `last_to_check_out`)
VALUES
  (null, '9780140455250', '', 'Xenophon', 'PHILOSOPHY',
   'Penguin', 'Penguin Classics', 'Hiero the Tyrant and Other Treatises', null, '0');

INSERT INTO `textbook_rental_library`.`patron`
(`patron_id`, `email`, `local_address_city`, `local_address_line1`, `local_address_line2`,
 `local_address_state`, `local_address_zip_code`, `first_name`, `last_name`, `middle_name`,
 `permanent_address_city`, `permanent_address_line1`, `permanent_address_line2`, `permanent_address_state`,
 `permanent_address_zip_code`, `number`, `type`)
VALUES
  (1, 'linus_dog@gmail.com', '', '', '', 'MN', '', 'Linus', 'Weinstein', 'Dog', 'Some City',
   '1234 Arbor Lane', 'Apt 232', 'MN', '55123', '6511234567', 'UNDERGRAD_STUDENT');

INSERT INTO `textbook_rental_library`.`patron`
(`patron_id`, `email`, `local_address_city`, `local_address_line1`, `local_address_line2`,
 `local_address_state`, `local_address_zip_code`, `first_name`, `last_name`, `middle_name`,
 `permanent_address_city`, `permanent_address_line1`, `permanent_address_line2`, `permanent_address_state`,
 `permanent_address_zip_code`, `number`, `type`)
VALUES
  (null, 'newt_kitty@gmail.com', 'Other City', '5856 Newton Lane', 'Apt. 94', 'MN', '55418', 'Newt',
         'Weinstein', 'Kitty', 'Some City', '1234 King Ave', '', 'MN', '55436', '6517654321', 'STAFF');

