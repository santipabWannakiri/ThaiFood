insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`) values('1','','2017-02-18 22:28:16','Healthy Origins, Razberi-K, Raspberry Ketones, 100 mg, 60 Capsules','0','Healthy Origins','12','B5518647');
insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`) values('2','','2017-02-18 22:29:37','Life Extension, Super R-Lipoic Acid, 240 mg, 60 Veggie Caps','36','Life Extension','80','B5514567');
insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`) values('3','','2017-02-18 22:30:12','Doctor Best, Stabilized R-Lipoic Acid, 100 mg, 60 Veggie Caps','15','Doctor Best','80','B4475424');

insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`, image) values('1','','2017-02-18 22:28:16','Healthy Origins, Razberi-K, Raspberry Ketones, 100 mg, 60 Capsules','0','Healthy Origins','12','B5518647','https://www.images-iherb.com/v/HOG-74746-10.jpg');
insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`, image) values('2','','2017-02-18 22:29:37','Life Extension, Super R-Lipoic Acid, 240 mg, 60 Veggie Caps','36','Life Extension','80','B5514567','https://www.images-iherb.com/v/LEX-12086-5.jpg');
insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`, image) values('3','','2017-02-18 22:30:12','Doctor Best, Stabilized R-Lipoic Acid, 100 mg, 60 Veggie Caps','15','Doctor Best','80','B4475424','https://www.images-iherb.com/v/DRB-00123-7.jpg');
insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`, image) values('4','','2017-02-18 22:31:45','Nature Way, Fenugreek Seed, 610 mg, 180 Veggie Caps','10','Nature Way','70','B753456','https://www.images-iherb.com/v/NWY-14610-10.jpg');
insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`, image) values('5','','2017-02-18 22:21:06','ต้มยำกุ้ง เมนูอาหารยอดนิยม สุดยอดเมนูอาหารไทย ยอดนิยม ดังกระฉ่อนโลก ของคนไทย ทำต้มยำกุ้งนั้นไม่ยากเลย','20','ต้มยำกุ้ง','120','B7864596','http://khao-lak-magazine.com/wp-content/uploads/2013/09/pad-krapow-muu-2.jpg');
insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`, image) values('6','','2017-02-18 22:21:50','ปลาช่อนลุยสวน เมนูปลาประเภทปลาทอด ปลาช่อนทอดจนกรอบ ราดด้วยน้ำยำปรุงรสเด็ด พร้อมทั้งสมุนไพรหลากหลายชนิดไม่ว่าจะเป็นใบสะระแหน่ ตะไคร้ หอมแดง ได้ประโยชน์คุณค่าโปรตีนจากปลา และวิตามินจากสมุนไพรไทย','10','ปลาช่อนลุยสวน','130','B786455','http://khao-lak-magazine.com/wp-content/uploads/2013/09/pad-krapow-muu-2.jpg');
insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`, image) values('7','','2017-02-18 22:22:27','กุ้งอบหม้อดิน เมนูอาหารประเภทอบยอดนิยม วุ้นเส้นร้อนๆ อบพร้อมกับกุ้ง หอมกรุ่งเครื่องปรุงนานาชนิด รสชาติเข้มข้น ถึงใจ','10','กุ้งอบหม้อดิน','120','B78654','http://khao-lak-magazine.com/wp-content/uploads/2013/09/pad-krapow-muu-2.jpg');
insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`, image) values('8','','2017-02-18 22:23:06','ปลานิลนึ่งขิง เมนูอาหารประเภทปลานึ่ง เป็นอาหารที่เหมาะแก่การลดครอเลสเตอรอล มีโปรตีน เป็นอาหารที่ย่อยง่าย','0','ปลานิลนึ่งขิง','90','B8645658','http://khao-lak-magazine.com/wp-content/uploads/2013/09/pad-krapow-muu-2.jpg');
insert into `food` (`id`, `active`, `create_date`, `detail`, `discount`, `name`, `price`, `promotion_code`, image) values('9','','2017-02-18 22:23:33','ปลาเก๋าสามรส เมนูอาหารประเภทปลาทอด ปลาเก๋าทอดกรอบ ราดด้วยน้ำปรุงรสสูตรเด็ด เมนูยอดฮิตของคนไทย','5','ปลาเก๋าสามรส','90','B564896','http://khao-lak-magazine.com/wp-content/uploads/2013/09/pad-krapow-muu-2.jpg');


insert into `role` (`role_id`, `role`) values('1','ROLE_ADMIN');


insert into `user` (`user_id`, `active`, `email`, `last_name`, `name`, `password`) values('1','','admin@gmail.com','wannakiri','santipab','$2a$10$LFmZyfEbe4v7rldEAwNW3uJICCATlV3IEGGwpedKJ.agTo851GYXm');

insert into `user_role` (`user_id`, `role_id`) values('1','1');