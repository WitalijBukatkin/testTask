use heroku_c15afcbc95bd973;
drop table if exists parts;
create table parts(
	id int primary key auto_increment,
	type  varchar(100) not null,
    model  varchar(100) not null,
    count int not null,
    need bit(1) not null
) charset='utf8';

INSERT INTO `parts` VALUES (null, 'Материнская плата',	'Gigabyte XZ Speed','12', b'1');
INSERT INTO `parts` VALUES (null, 'Звуковая карта', 'Intel HD Audio','10', b'0');
INSERT INTO `parts` VALUES (null, 'Процессор', 'Intel Core i7 Skylake', '3', b'1');
INSERT INTO `parts` VALUES (null, 'Подсветка корпуса', 'Светодиодная лента Deepcool RGB 380', '3', b'0');
INSERT INTO `parts` VALUES (null, 'HDD диск', 'Жесткий диск Western Digital WD Blue Desktop 1 TB (WD10EZRZ)', '2', b'0');
INSERT INTO `parts` VALUES (null, 'Корпус', 'Корпус NZXT H200 Black/Red', '4', b'1');
INSERT INTO `parts` VALUES (null, 'Память', 'Patriot Memory PSD22G8002S', '9', b'1');
INSERT INTO `parts` VALUES (null, 'SSD диск', 'Samsung SSD 850 120GB', '16', b'1');
INSERT INTO `parts` VALUES (null, 'Видеокарта', 'NVIDIA GeForce GTX 1060', '5', b'1');
INSERT INTO `parts` VALUES (null, 'Охлаждение процессора', 'ID-COOLING SE-214', '6', b'1');
INSERT INTO `parts` VALUES (null, 'Мышь', 'A4Tech X-710BK Black USB', '4', b'1');
INSERT INTO `parts` VALUES (null, 'Коврик для мыши', 'HyperX Fury S Pro Medium (HX-MPFS-M)', '9', b'0');
INSERT INTO `parts` VALUES (null, 'Клавиатура', 'Genius Scorpion K9 Black USB', '12', b'1');
INSERT INTO `parts` VALUES (null, 'Монитор', 'Samsung C27F591FDI', '14', b'1');

INSERT INTO `parts` VALUES (null, 'Материнская плата',	'Supermicro C7Z270-CG','25', b'1');
INSERT INTO `parts` VALUES (null, 'Звуковая карта', 'ORICO SC1','24', b'0');
INSERT INTO `parts` VALUES (null, 'Процессор', 'Intel Core i5 Coffee Lake', '5', b'1');
INSERT INTO `parts` VALUES (null, 'Подсветка корпуса', 'Светодиодная лента Deepcool RGB 430', '6', b'0');
INSERT INTO `parts` VALUES (null, 'HDD диск', 'Western Digital WD Purple 1 TB (WD10PURZ)', '12', b'0');
INSERT INTO `parts` VALUES (null, 'Корпус', ' GameMax StarLight White/green', '9', b'1');
INSERT INTO `parts` VALUES (null, 'Память', 'Kingston KVR16S11/8', '18', b'1');
INSERT INTO `parts` VALUES (null, 'SSD диск', 'Western Digital WD BLUE 3D NAND SATA SSD 250 GB (WDS250G2B0A)', '3', b'1');
INSERT INTO `parts` VALUES (null, 'Видеокарта', 'NVIDIA GeForce GTX 1070 Ti', '4', b'1');
INSERT INTO `parts` VALUES (null, 'Охлаждение процессора', 'Deepcool NEPTWIN V2', '8', b'1');
INSERT INTO `parts` VALUES (null, 'Мышь', 'Logitech M170 Wireless Mouse Black-Grey USB', '2', b'1');
INSERT INTO `parts` VALUES (null, 'Коврик для мыши', 'HyperX Fury S Pro Large (HX-MPFS-L)', '6', b'0');
INSERT INTO `parts` VALUES (null, 'Клавиатура', 'Logitech G G213 Prodigy RGB Gaming Keyboard Black USB', '1', b'1');
INSERT INTO `parts` VALUES (null, 'Монитор', 'Philips 246E9QDSB', '3', b'1');

INSERT INTO `parts` VALUES (null, 'Материнская плата',	'MSI B450 TOMAHAWK','9', b'1');
INSERT INTO `parts` VALUES (null, 'Звуковая карта', 'Creative Sound Blaster Play! 3','6', b'0');
INSERT INTO `parts` VALUES (null, 'Процессор', 'Intel Core i3 Kaby Lake', '7', b'1');
INSERT INTO `parts` VALUES (null, 'Подсветка корпуса', 'Светодиодная лента Deepcool RGB 500', '13', b'0');
INSERT INTO `parts` VALUES (null, 'HDD диск', 'Western Digital WD Blue Desktop 2 TB (WD20EZRZ)', '14', b'0');
INSERT INTO `parts` VALUES (null, 'Корпус', 'AeroCool V2X Red Edition Red', '2', b'1');
INSERT INTO `parts` VALUES (null, 'Память', 'Hynix DDR3 1600 DIMM 4Gb', '9', b'1');
INSERT INTO `parts` VALUES (null, 'SSD диск', 'Kingston SA400S37/120G', '6', b'1');
INSERT INTO `parts` VALUES (null, 'Видеокарта', 'NVIDIA GeForce GTX 1050 Ti', '15', b'1');
INSERT INTO `parts` VALUES (null, 'Охлаждение процессора', 'PCcooler GI-X6R', '4', b'1');
INSERT INTO `parts` VALUES (null, 'Мышь', 'A4Tech N-70FX Black USB', '6', b'1');
INSERT INTO `parts` VALUES (null, 'Коврик для мыши', 'HAMA 00053231', '1', b'0');
INSERT INTO `parts` VALUES (null, 'Клавиатура', 'DELL KB216 Black USB', '2', b'1');
INSERT INTO `parts` VALUES (null, 'Монитор', 'ASUS VP228DE', '5', b'1');
select * from parts;