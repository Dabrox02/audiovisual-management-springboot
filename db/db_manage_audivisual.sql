CREATE TABLE `tbl_user` (
  `id_user` int PRIMARY KEY AUTO_INCREMENT,
  `name_user` varchar(50) UNIQUE NOT NULL,
  `email_user` varchar(100) UNIQUE NOT NULL,
  `password` varchar(255) NOT NULL
);

CREATE TABLE `tbl_content` (
  `id_content` int PRIMARY KEY AUTO_INCREMENT,
  `name_content` varchar(100),
  `status_display` ENUM ('pending', 'watching', 'finished', 'abandoned', 'on pause') NOT NULL,
  `id_type_content` int NOT NULL,
  `id_platform` int NOT NULL,
  `gender1` int NOT NULL,
  `gender2` int,
  `qualification` decimal(5,1),
  `comment` varchar(500),
  `id_user` int NOT NULL
);

CREATE TABLE `tbl_gender` (
  `id_gender` int PRIMARY KEY AUTO_INCREMENT,
  `name_gender` varchar(50) NOT NULL
);

CREATE TABLE `tbl_type_content` (
  `id_type_content` int PRIMARY KEY AUTO_INCREMENT,
  `name_type_content` varchar(60) NOT NULL
);

CREATE TABLE `tbl_platform` (
  `id_platform` int PRIMARY KEY AUTO_INCREMENT,
  `name_platform` varchar(100) NOT NULL,
  `id_type_content` int NOT NULL
);

ALTER TABLE `tbl_content` ADD FOREIGN KEY (`id_user`) REFERENCES `tbl_user` (`id_user`);

ALTER TABLE `tbl_content` ADD FOREIGN KEY (`gender1`) REFERENCES `tbl_gender` (`id_gender`);

ALTER TABLE `tbl_content` ADD FOREIGN KEY (`gender2`) REFERENCES `tbl_gender` (`id_gender`);

ALTER TABLE `tbl_content` ADD FOREIGN KEY (`id_type_content`) REFERENCES `tbl_type_content` (`id_type_content`);

ALTER TABLE `tbl_content` ADD FOREIGN KEY (`id_platform`) REFERENCES `tbl_platform` (`id_platform`);
