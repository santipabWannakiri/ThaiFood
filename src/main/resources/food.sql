
insert into `role` (`role_id`, `role`) values('1','ROLE_ADMIN');

insert into `user` (`active`, `email`, `last_name`, `name`, `password`) values('','admin@gmail.com','wannakiri','santipab','$2a$10$LFmZyfEbe4v7rldEAwNW3uJICCATlV3IEGGwpedKJ.agTo851GYXm');

insert into `user_role` (`user_id`, `role_id`) values('1','1');



insert into `food` (`pic_cover`, `active`, `create_date`, `detail`, `discount`, `last_update`, `name`, `price`, `promotion_code`, `create_by`) values('/ImageFood/tom-yum-goong.png','','2017-04-24 00:51:52','This Thai masterpiece soup is teeming with shrimp, mushrooms, tomatoes, lemongrass, galangal and kaffir lime leaves. ','20',NULL,'Tom Yum Gung','20','BXCCD','1');
insert into `food` (`pic_cover`, `active`, `create_date`, `detail`, `discount`, `last_update`, `name`, `price`, `promotion_code`, `create_by`) values('/ImageFood/Thai-Green-Curry-Chicken-3.jpg','','2017-04-24 00:54:36','One of the most famous and sought after Thai dishes is Thai green curry. Green curry paste, coconut milk, bamboo shoots, chicken, Thai basil,','20',NULL,'Gang Keow Wan','20','BCVVv','1');
insert into `food` (`pic_cover`, `active`, `create_date`, `detail`, `discount`, `last_update`, `name`, `price`, `promotion_code`, `create_by`) values('/ImageFood/Yam-Khor-Moo-Yang-Thailand-famous-dish.jpg','','2017-04-24 00:56:00','This prized meat salad consists of dripping and tender pork cutlets, grilled and sliced then mixed with lemon juice, parsley, sweet onions and a copious amount of fiery chilies.','30',NULL,'Yam Khor Moo Yang','30','HDFSDF','1');
insert into `food` (`pic_cover`, `active`, `create_date`, `detail`, `discount`, `last_update`, `name`, `price`, `promotion_code`, `create_by`) values('/ImageFood/thai-chicken-basil-recipe-4-X3.jpg','','2017-04-24 00:57:26','If a local Thai doesn\'t know what to order, it almost certainly comes down to pad ga pow. A stir fried dish that can be trusted to turn out delicious and satisfying every time and at almost every eatery.','10',NULL,'Pad Ga Pow Moo Kai Dow','10','SDVCD','1');

insert into `images` (`pathimage`, `food_id`) values('/ImageFood/tom-yum-goong.png','1');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','1');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','1');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','1');

insert into `images` (`pathimage`, `food_id`) values('/ImageFood/Thai-Green-Curry-Chicken-3.jpg','2');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','2');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','2');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','2');

insert into `images` (`pathimage`, `food_id`) values('/ImageFood/Yam-Khor-Moo-Yang-Thailand-famous-dish.jpg','3');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','3');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','3');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','3');

insert into `images` (`pathimage`, `food_id`) values('/ImageFood/thai-chicken-basil-recipe-4-X3.jpg','4');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','4');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','4');
insert into `images` (`pathimage`, `food_id`) values('/ImageSystem/no-image.png','4');



