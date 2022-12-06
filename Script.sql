insert into users(id,first_name,last_name,username,password,email,status,created_by,created_at) values(1,'Super','Administrateur','admin','admin','admin@gmail.com','ACTIVE',1,CURRENT_TIMESTAMP);

insert into collections(id,name,type,created_by,created_at) values(1,'users','table',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(2,'collections','table',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(3,'parametre_systeme','menu',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(4,'gestion_acces','menu',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(5,'roles','table',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(6,'permissions','table',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(7,'sessions','table',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(8,'menus','table',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(9,'menu_items','table',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(10,'gestion_sites','menu',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(11,'filiales','table',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(12,'unites','table',1,CURRENT_TIMESTAMP);
insert into collections(id,name,type,created_by,created_at) values(13,'fret_centres','table',1,CURRENT_TIMESTAMP);

insert into activities(action,collection_id,item_id,created_by,created_at) values('add',1,1,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,1,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,2,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,3,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,4,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,5,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,6,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,7,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,8,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,9,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,10,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,11,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,12,1,CURRENT_TIMESTAMP);
insert into activities(action,collection_id,item_id,created_by,created_at) values('add',2,13,1,CURRENT_TIMESTAMP);



ALTER TABLE users modify `first_name` varchar(50) NOT NULL after `id`; 
ALTER TABLE users modify `last_name` varchar(50) NOT NULL after `first_name`; 
ALTER TABLE users modify `username` varchar(50) NOT NULL after `last_name`; 
ALTER TABLE users modify `password` varchar(100) NOT NULL after `username`;
ALTER TABLE users modify `email` varchar(50) NOT NULL after `password`;
ALTER TABLE users modify `status` varchar(50) NOT NULL after `email`;
ALTER TABLE users modify `unite_id` bigint(20) DEFAULT NULL after `status`;
ALTER TABLE users modify `fret_centre_id` bigint(20) DEFAULT NULL after `unite_id`;
ALTER TABLE users modify `avatar` varchar(50) DEFAULT NULL after `fret_centre_id`;
ALTER TABLE users modify `last_access` datetime(6) DEFAULT NULL after `avatar`;
ALTER TABLE users modify `last_page` varchar(100) DEFAULT NULL after `last_access`;
ALTER TABLE users modify `theme` varchar(50) DEFAULT NULL after `last_page`;
ALTER TABLE users modify `created_at` datetime(6) NOT NULL after `theme`;
ALTER TABLE users modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE users modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE users modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE users modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE users modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE users modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`;


ALTER TABLE roles modify `name` varchar(50) NOT NULL after `id`;
ALTER TABLE roles modify `display_name` varchar(50) NOT NULL after `name`;
ALTER TABLE roles modify `admin_access` bit(1) NOT NULL after `display_name`;
ALTER TABLE roles modify `guard_name` varchar(50) NOT NULL after `admin_access`;
ALTER TABLE roles modify `created_at` datetime(6) NOT NULL after `guard_name`;
ALTER TABLE roles modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE roles modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE roles modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE roles modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE roles modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE roles modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`;


ALTER TABLE permissions modify `action` varchar(50) NOT NULL after `id`;
ALTER TABLE permissions modify `name` varchar(50) DEFAULT NULL after `action`;
ALTER TABLE permissions modify `collection_id` bigint(20) DEFAULT NULL after `name`;
ALTER TABLE permissions modify `guard_name` varchar(50) NOT NULL after `collection_id`;
ALTER TABLE permissions modify `created_at` datetime(6) NOT NULL after `guard_name`;
ALTER TABLE permissions modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE permissions modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE permissions modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE permissions modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE permissions modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE permissions modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`;


ALTER TABLE collections modify `name` varchar(50) NOT NULL after `id`;
ALTER TABLE collections modify `type` varchar(50) NOT NULL after `name`;
ALTER TABLE collections modify `created_at` datetime(6) NOT NULL after `type`;
ALTER TABLE collections modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE collections modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE collections modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE collections modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE collections modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE collections modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`; 


ALTER TABLE menus modify `name` varchar(50) NOT NULL after `id`;
ALTER TABLE menus modify `created_at` datetime(6) NOT NULL after `name`;
ALTER TABLE menus modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE menus modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE menus modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE menus modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE menus modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE menus modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`;
  
  
ALTER TABLE menu_items modify `menu_id` bigint(20) DEFAULT NULL after `id`;
ALTER TABLE menu_items modify `title` varchar(100) NOT NULL after `menu_id`;
ALTER TABLE menu_items modify `parent` bigint(20) DEFAULT NULL after `title`;
ALTER TABLE menu_items modify `order` int(11) NOT NULL after `parent`;
ALTER TABLE menu_items modify `permission_id` bigint(20) DEFAULT NULL after `order`;
ALTER TABLE menu_items modify `icon` varchar(100) DEFAULT NULL after `permission_id`;
ALTER TABLE menu_items modify `url` varchar(100) DEFAULT NULL after `icon`;
ALTER TABLE menu_items modify `created_at` datetime(6) NOT NULL after `url`;
ALTER TABLE menu_items modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE menu_items modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE menu_items modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE menu_items modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE menu_items modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE menu_items modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`;


ALTER TABLE activities modify `action` varchar(50) NOT NULL after `id`;
ALTER TABLE activities modify `collection_id` bigint(20) DEFAULT NULL after `action`;
ALTER TABLE activities modify `item_id` bigint(20) DEFAULT NULL after `collection_id`;
ALTER TABLE activities modify `created_at` datetime(6) NOT NULL after `item_id`;
ALTER TABLE activities modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE activities modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE activities modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE activities modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE activities modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE activities modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`;


ALTER TABLE sessions modify `token` varchar(100) NOT NULL after `id`;
ALTER TABLE sessions modify `expires` datetime(6) NOT NULL after `token`;
ALTER TABLE sessions modify `ip` varchar(50) DEFAULT NULL after `expires`;
ALTER TABLE sessions modify `user_agent` varchar(50) DEFAULT NULL after `ip`;
ALTER TABLE sessions modify `created_at` datetime(6) NOT NULL after `user_agent`;
ALTER TABLE sessions modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE sessions modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE sessions modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE sessions modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE sessions modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE sessions modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`;


ALTER TABLE filiales modify `code` varchar(50) NOT NULL after `id`;
ALTER TABLE filiales modify `name` varchar(50) NOT NULL after `code`;
ALTER TABLE filiales modify `created_at` datetime(6) NOT NULL after `name`;
ALTER TABLE filiales modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE filiales modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE filiales modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE filiales modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE filiales modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE filiales modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`;

ALTER TABLE unites modify `code` varchar(50) NOT NULL after `id`;
ALTER TABLE unites modify `name` varchar(50) NOT NULL after `code`;
ALTER TABLE unites modify `created_at` datetime(6) NOT NULL after `name`;
ALTER TABLE unites modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE unites modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE unites modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE unites modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE unites modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE unites modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`;

ALTER TABLE fretcentres modify `code` varchar(50) NOT NULL after `id`;
ALTER TABLE fretcentres modify `name` varchar(50) NOT NULL after `code`;
ALTER TABLE fretcentres modify `created_at` datetime(6) NOT NULL after `name`;
ALTER TABLE fretcentres modify `created_by` bigint(20) NOT NULL after `created_at`;
ALTER TABLE fretcentres modify `updated_at` datetime(6) DEFAULT NULL after `created_by`;
ALTER TABLE fretcentres modify `updated_by` bigint(20) DEFAULT NULL after `updated_at`;
ALTER TABLE fretcentres modify `deleted_at` datetime(6) DEFAULT NULL after `updated_by`;
ALTER TABLE fretcentres modify `deleted_by` bigint(20) DEFAULT NULL after `deleted_at`;
ALTER TABLE fretcentres modify `deleted_for` varchar(150) DEFAULT NULL after `deleted_by`;
  
  
  
  
  
  
  
  