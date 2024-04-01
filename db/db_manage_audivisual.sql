CREATE TABLE `tbl_user` (
  `user_id` int PRIMARY KEY AUTO_INCREMENT,
  `name_user` varchar(50) UNIQUE NOT NULL,
  `email_user` varchar(100) UNIQUE NOT NULL,
  `password` varchar(255) NOT NULL
);

CREATE TABLE `tbl_content` (
  `content_id` int PRIMARY KEY AUTO_INCREMENT,
  `name_content` varchar(100) NOT NULL,
  `status_display` ENUM ('pending', 'watching', 'finished', 'abandoned', 'on pause') NOT NULL,
  `type_content_id` int NOT NULL,
  `platform_id` int NOT NULL,
  `gender1` int NOT NULL,
  `gender2` int,
  `qualification` decimal(5,1),
  `comment` varchar(500),
  `user_id` int NOT NULL
);

CREATE TABLE `tbl_gender` (
  `gender_id` int PRIMARY KEY AUTO_INCREMENT,
  `name_gender` varchar(50) UNIQUE NOT NULL
);

CREATE TABLE `tbl_type_content` (
  `type_content_id` int PRIMARY KEY AUTO_INCREMENT,
  `name_type_content` varchar(60) UNIQUE NOT NULL
);

CREATE TABLE `tbl_platform` (
  `platform_id` int PRIMARY KEY AUTO_INCREMENT,
  `name_platform` varchar(100) NOT NULL
);

CREATE TABLE `tbl_platform_type_content` (
  `platform_id` int NOT NULL,
  `type_content_id` int NOT NULL
);

ALTER TABLE `tbl_content` ADD FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`);

ALTER TABLE `tbl_content` ADD FOREIGN KEY (`gender1`) REFERENCES `tbl_gender` (`gender_id`);

ALTER TABLE `tbl_content` ADD FOREIGN KEY (`gender2`) REFERENCES `tbl_gender` (`gender_id`);

ALTER TABLE `tbl_content` ADD FOREIGN KEY (`type_content_id`) REFERENCES `tbl_type_content` (`type_content_id`);

ALTER TABLE `tbl_content` ADD FOREIGN KEY (`platform_id`) REFERENCES `tbl_platform` (`platform_id`);

ALTER TABLE `tbl_platform_type_content` ADD FOREIGN KEY (`platform_id`) REFERENCES `tbl_platform` (`platform_id`);

ALTER TABLE `tbl_platform_type_content` ADD FOREIGN KEY (`type_content_id`) REFERENCES `tbl_type_content` (`type_content_id`);
