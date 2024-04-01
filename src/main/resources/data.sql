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

INSERT INTO `db_manage_audiovisual`.`tbl_platform`(`platform_id`,`type_content_id`,`name_platform`)
VALUES
(NULL, 1, "netflix"),
(NULL, 1, "hbo max"),
(NULL, 1, "disney plus"),
(NULL, 1, "star plus"),
(NULL, 2, "netflix"),
(NULL, 2, "hbo max"),
(NULL, 2, "disney plus"),
(NULL, 2, "star plus"),
(NULL, 3, "physical"),
(NULL, 3, "e-book"),
(NULL, 4, "spotify"),
(NULL, 4, "youtube"),
(NULL, 4, "deezer"),
(NULL, 4, "google podcasts"),
(NULL, 5, "steam"),
(NULL, 5, "epicgames"),
(NULL, 5, "origin"),
(NULL, 5, "blizzard");

