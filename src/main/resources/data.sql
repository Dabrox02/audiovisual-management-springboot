INSERT INTO `db_manage_audiovisual`.`tbl_gender` (`gender_id`, `name_gender`)
VALUES 
(NULL, "action"),
(NULL, "adventure"),
(NULL, "science fiction"),
(NULL, "comedy"),
(NULL, "drama"),
(NULL, "fantasy"),
(NULL, "documentary"),
(NULL, "musical"),
(NULL, "horror"),
(NULL, "thriller");

INSERT INTO `db_manage_audiovisual`.`tbl_type_content`(`type_content_id`,`name_type_content`)
VALUES
(NULL,"serie"),
(NULL,"movie"),
(NULL,"book"),
(NULL,"podcast"),
(NULL,"videogame");

INSERT INTO `db_manage_audiovisual`.`tbl_platform`(`platform_id`,`name_platform`)
VALUES
(NULL, "netflix"),
(NULL, "hbo max"),
(NULL, "physical"),
(NULL, "e-book"),
(NULL, "spotify"),
(NULL, "youtube"),
(NULL, "steam"),
(NULL, "epicgames");

INSERT INTO `db_manage_audiovisual`.`tbl_platform_type_content`(`platforms_platform_id`,`type_contents_type_content_id`)
VALUES
(1,1),
(1,2),
(2,1),
(2,2),
(3,3),
(3,5),
(4,3),
(5,4),
(6,4),
(7,5),
(8,5);

INSERT INTO `db_manage_audiovisual`.`tbl_user`(`user_id`,`name_user`,`email_user`,`password`)
VALUES
(NULL,'jaider','jaider@email.com','$2a$10$hzR3/55Gwt7GzfDs54MzguYVr3JDCdFw0JktkQDSQy89GFJLgxGmu');