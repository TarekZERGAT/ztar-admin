package com.ztardz.ztaradminapi;

import com.ztardz.ztaradminapi.models.*;
import com.ztardz.ztaradminapi.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ZtarAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZtarAdminApiApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            UserService userService,
            RoleService roleService,
            CollectionService collectionService,
            PermissionService permissionService,
            MenuService menuService,
            MenuItemService menuItemService,
            ActivityService activityService
            ){
        return args -> {
            UserEntity user1 = new UserEntity("Super","Administrateur","admin","admin@gmail.com", "admin",null,null,
                    "ACTIVE",null,null,null,null,null,null);
            user1.setCreatedBy(user1);
            userService.addNewUser(user1);
            CollectionEntity colUsers = new CollectionEntity("users","table",null);
            colUsers.setCreatedBy(user1);
            collectionService.addNewCollection(colUsers);
            CollectionEntity usersCollection = collectionService.readCollectionByName("users");
            activityService.addNewActivity(new ActivityEntity("add",usersCollection,user1.getId()),user1);

            CollectionEntity col = new CollectionEntity("collections","table",null);
            col.setCreatedBy(user1);
            collectionService.addNewCollection(col);
            CollectionEntity collectionsCollection = collectionService.readCollectionByName("collections");
            activityService.addNewActivity(new ActivityEntity("add",collectionsCollection,colUsers.getId()),user1);
            activityService.addNewActivity(new ActivityEntity("add",collectionsCollection,collectionsCollection.getId()),user1);
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,collectionsCollection.getId()),user1);

            Stream.of(new CollectionEntity("parametre_systeme","menu",null),
                    new CollectionEntity("gestion_acces","menu",null),
                    new CollectionEntity("roles","table",null),
                    new CollectionEntity("permissions","table",null),
                    new CollectionEntity("sessions","table",null),
                    new CollectionEntity("menus","table",null),
                    new CollectionEntity("menu_items","table",null),
                    new CollectionEntity("gestion_sites","menu",null),
                    new CollectionEntity("filiales","table",null),
                    new CollectionEntity("unites","table",null),
                    new CollectionEntity("centres_fret","table",null)).forEach(collection -> {
                collection.setCreatedBy(user1);
                collectionService.addNewCollection(collection);
                activityService.addNewActivity(new ActivityEntity("add",collectionsCollection,collection.getId()),user1);
            });

            CollectionEntity parametreSystemeCollection = collectionService.readCollectionByName("parametre_systeme");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,parametreSystemeCollection.getId()),user1);
            CollectionEntity gestionAccesCollection = collectionService.readCollectionByName("gestion_acces");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,gestionAccesCollection.getId()),user1);
            CollectionEntity rolesCollection = collectionService.readCollectionByName("roles");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,rolesCollection.getId()),user1);
            CollectionEntity permissionsCollection = collectionService.readCollectionByName("permissions");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,permissionsCollection.getId()),user1);
            CollectionEntity sessionsCollection = collectionService.readCollectionByName("sessions");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,sessionsCollection.getId()),user1);
            CollectionEntity menusCollection = collectionService.readCollectionByName("menus");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,menusCollection.getId()),user1);
            CollectionEntity menu_itemsCollection = collectionService.readCollectionByName("menu_items");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,menu_itemsCollection.getId()),user1);
            CollectionEntity gestion_sitesCollection = collectionService.readCollectionByName("gestion_sites");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,gestion_sitesCollection.getId()),user1);
            CollectionEntity filialesCollection = collectionService.readCollectionByName("filiales");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,filialesCollection.getId()),user1);
            CollectionEntity unitesCollection = collectionService.readCollectionByName("unites");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,unitesCollection.getId()),user1);
            CollectionEntity centres_fretCollection = collectionService.readCollectionByName("centres_fret");
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,centres_fretCollection.getId()),user1);


            UserEntity user2 = new UserEntity("Sites","Manger01","sites_manager01","admin@sites_manager01.com", "123",null,null,
                    "ACTIVE",null,null,null,null,null,null);
            user2.setCreatedBy(user1);
            userService.addNewUser(user2);
            activityService.addNewActivity(new ActivityEntity("add",usersCollection,user2.getId()),user1);

            Stream.of(new RoleEntity("admin","Administrateur Role","web",true,null,null),
                    new RoleEntity("sites_manager","Sites Manager Role","web",false,null,null)).forEach(role->{
                        role.setCreatedBy(user1);
                        roleService.addNewRole(role);
                        activityService.addNewActivity(new ActivityEntity("add",rolesCollection,role.getId()),user1);
                    });

            userService.addRoleToUser("admin","admin");
            userService.addRoleToUser("sites_manager","admin");
            userService.addRoleToUser("sites_manager","sites_manager01");



            Stream.of(new PermissionEntity("browse","browse_parametre_systeme","web",null,null,parametreSystemeCollection),
                    new PermissionEntity("browse","browse_gestion_acces","web",null,null,gestionAccesCollection),
                    new PermissionEntity("browse","browse_users","web",null,null,usersCollection),
                    new PermissionEntity("read","read_user","web",null,null,usersCollection),
                    new PermissionEntity("edit","edit_user","web",null,null,usersCollection),
                    new PermissionEntity("add","add_user","web",null,null,usersCollection),
                    new PermissionEntity("delete","delete_user","web",null,null,usersCollection),
                    new PermissionEntity("action01","desactivate_user","web",null,null,usersCollection),
                    new PermissionEntity("action02","init_password","web",null,null,usersCollection),
                    new PermissionEntity("action03",null,"web",null,null,usersCollection),
                    new PermissionEntity("action04",null,"web",null,null,usersCollection),
                    new PermissionEntity("action05",null,"web",null,null,usersCollection),
                    new PermissionEntity("browse","browse_roles","web",null,null,rolesCollection),
                    new PermissionEntity("read","read_role","web",null,null,rolesCollection),
                    new PermissionEntity("edit","edit_role","web",null,null,rolesCollection),
                    new PermissionEntity("add","add_role","web",null,null,rolesCollection),
                    new PermissionEntity("delete","delete_role","web",null,null,rolesCollection),
                    new PermissionEntity("action01",null,"web",null,null,rolesCollection),
                    new PermissionEntity("action02",null,"web",null,null,rolesCollection),
                    new PermissionEntity("action03",null,"web",null,null,rolesCollection),
                    new PermissionEntity("action04",null,"web",null,null,rolesCollection),
                    new PermissionEntity("action05",null,"web",null,null,rolesCollection),
                    new PermissionEntity("browse","browse_permissions","web",null,null,permissionsCollection),
                    new PermissionEntity("read","read_permission","web",null,null,permissionsCollection),
                    new PermissionEntity("edit","edit_permission","web",null,null,permissionsCollection),
                    new PermissionEntity("add","add_permission","web",null,null,permissionsCollection),
                    new PermissionEntity("delete","delete_permission","web",null,null,permissionsCollection),
                    new PermissionEntity("action01",null,"web",null,null,permissionsCollection),
                    new PermissionEntity("action02",null,"web",null,null,permissionsCollection),
                    new PermissionEntity("action03",null,"web",null,null,permissionsCollection),
                    new PermissionEntity("action04",null,"web",null,null,permissionsCollection),
                    new PermissionEntity("action05",null,"web",null,null,permissionsCollection),
                    new PermissionEntity("browse","browse_sessions","web",null,null,sessionsCollection),
                    new PermissionEntity("read","read_session","web",null,null,sessionsCollection),
                    new PermissionEntity("edit","edit_session","web",null,null,sessionsCollection),
                    new PermissionEntity("'add","add_session","web",null,null,sessionsCollection),
                    new PermissionEntity("delete","delete_session","web",null,null,sessionsCollection),
                    new PermissionEntity("action01",null,"web",null,null,sessionsCollection),
                    new PermissionEntity("action02",null,"web",null,null,sessionsCollection),
                    new PermissionEntity("action03",null,"web",null,null,sessionsCollection),
                    new PermissionEntity("action04",null,"web",null,null,sessionsCollection),
                    new PermissionEntity("action05",null,"web",null,null,sessionsCollection),
                    new PermissionEntity("browse","browse_menus","web",null,null,menusCollection),
                    new PermissionEntity("read","read_menu","web",null,null,menusCollection),
                    new PermissionEntity("edit","edit_menu","web",null,null,menusCollection),
                    new PermissionEntity("add","add_menu","web",null,null,menusCollection),
                    new PermissionEntity("delete","delete_menu","web",null,null,menusCollection),
                    new PermissionEntity("action01",null,"web",null,null,menusCollection),
                    new PermissionEntity("action02",null,"web",null,null,menusCollection),
                    new PermissionEntity("action03",null,"web",null,null,menusCollection),
                    new PermissionEntity("action04",null,"web",null,null,menusCollection),
                    new PermissionEntity("action05",null,"web",null,null,menusCollection),
                    new PermissionEntity("browse","browse_menu_items","web",null,null,menu_itemsCollection),
                    new PermissionEntity("read","read_menu_item","web",null,null,menu_itemsCollection),
                    new PermissionEntity("edit","edit_menu_item","web",null,null,menu_itemsCollection),
                    new PermissionEntity("add","add_menu_item","web",null,null,menu_itemsCollection),
                    new PermissionEntity("delete","delete_menu_item","web",null,null,menu_itemsCollection),
                    new PermissionEntity("action01",null,"web",null,null,menu_itemsCollection),
                    new PermissionEntity("action02",null,"web",null,null,menu_itemsCollection),
                    new PermissionEntity("action03",null,"web",null,null,menu_itemsCollection),
                    new PermissionEntity("action04",null,"web",null,null,menu_itemsCollection),
                    new PermissionEntity("action05",null,"web",null,null,menu_itemsCollection),
                    new PermissionEntity("browse","browse_collections","web",null,null,collectionsCollection),
                    new PermissionEntity("read","read_collection","web",null,null,collectionsCollection),
                    new PermissionEntity("edit","edit_collection","web",null,null,collectionsCollection),
                    new PermissionEntity("add","add_collection","web",null,null,collectionsCollection),
                    new PermissionEntity("delete","delete_collection","web",null,null,collectionsCollection),
                    new PermissionEntity("action01",null,"web",null,null,collectionsCollection),
                    new PermissionEntity("action02",null,"web",null,null,collectionsCollection),
                    new PermissionEntity("action03",null,"web",null,null,collectionsCollection),
                    new PermissionEntity("action04",null,"web",null,null,collectionsCollection),
                    new PermissionEntity("action05",null,"web",null,null,collectionsCollection),
                    new PermissionEntity("browse","browse_gestion_sites","web",null,null,gestion_sitesCollection),
                    new PermissionEntity("browse","browse_filialles","web",null,null,filialesCollection),
                    new PermissionEntity("read","read_filialle","web",null,null,filialesCollection),
                    new PermissionEntity("edit","edit_filialle","web",null,null,filialesCollection),
                    new PermissionEntity("add","add_filialle","web",null,null,filialesCollection),
                    new PermissionEntity("delete","delete_filialle","web",null,null,filialesCollection),
                    new PermissionEntity("action01",null,"web",null,null,filialesCollection),
                    new PermissionEntity("action02",null,"web",null,null,filialesCollection),
                    new PermissionEntity("action03",null,"web",null,null,filialesCollection),
                    new PermissionEntity("action04",null,"web",null,null,filialesCollection),
                    new PermissionEntity("action05",null,"web",null,null,filialesCollection),
                    new PermissionEntity("browse","browse_unites","web",null,null,unitesCollection),
                    new PermissionEntity("read","read_unite","web",null,null,unitesCollection),
                    new PermissionEntity("edit","edit_unite","web",null,null,unitesCollection),
                    new PermissionEntity("add","add_unite","web",null,null,unitesCollection),
                    new PermissionEntity("delete","delete_unite","web",null,null,unitesCollection),
                    new PermissionEntity("action01",null,"web",null,null,unitesCollection),
                    new PermissionEntity("action02",null,"web",null,null,unitesCollection),
                    new PermissionEntity("action03",null,"web",null,null,unitesCollection),
                    new PermissionEntity("action04",null,"web",null,null,unitesCollection),
                    new PermissionEntity("action05",null,"web",null,null,unitesCollection),
                    new PermissionEntity("browse","browse_centres_fret","web",null,null,centres_fretCollection),
                    new PermissionEntity("read","read_centre_fret","web",null,null,centres_fretCollection),
                    new PermissionEntity("edit","edit_centre_fret","web",null,null,centres_fretCollection),
                    new PermissionEntity("add","add_centre_fret","web",null,null,centres_fretCollection),
                    new PermissionEntity("delete","delete_centre_fret","web",null,null,centres_fretCollection),
                    new PermissionEntity("action01",null,"web",null,null,centres_fretCollection),
                    new PermissionEntity("action02",null,"web",null,null,centres_fretCollection),
                    new PermissionEntity("action03",null,"web",null,null,centres_fretCollection),
                    new PermissionEntity("action04",null,"web",null,null,centres_fretCollection),
                    new PermissionEntity("action05",null,"web",null,null,centres_fretCollection)
                    ).forEach(permission -> {
                        permission.setCreatedBy(user1);
                        permissionService.addNewPermission(permission);
                        activityService.addNewActivity(new ActivityEntity("add",permissionsCollection,permission.getId()),user1);
                    });

            roleService.addPermissionToRole("browse_gestion_sites","sites_manager");
            roleService.addPermissionToRole("browse_filialles","sites_manager");
            roleService.addPermissionToRole("read_filialle","sites_manager");
            roleService.addPermissionToRole("edit_filialle","sites_manager");
            roleService.addPermissionToRole("add_filialle","sites_manager");
            roleService.addPermissionToRole("delete_filialle","sites_manager");
            roleService.addPermissionToRole("browse_unites","sites_manager");
            roleService.addPermissionToRole("read_unite","sites_manager");
            roleService.addPermissionToRole("edit_unite","sites_manager");
            roleService.addPermissionToRole("add_unite","sites_manager");
            roleService.addPermissionToRole("delete_unite","sites_manager");
            roleService.addPermissionToRole("browse_centres_fret","sites_manager");
            roleService.addPermissionToRole("read_centre_fret","sites_manager");
            roleService.addPermissionToRole("edit_centre_fret","sites_manager");
            roleService.addPermissionToRole("add_centre_fret","sites_manager");
            roleService.addPermissionToRole("delete_centre_fret","sites_manager");

            userService.addPermissionToUser("browse_parametre_systeme","sites_manager01");
            userService.addPermissionToUser("browse_gestion_acces","sites_manager01");
            userService.addPermissionToUser("browse_users","sites_manager01");
            userService.addPermissionToUser("read_user","sites_manager01");

            Stream.of(new MenuEntity("admin",null)).forEach(menu -> {
                UserEntity user = userService.readUserByUsername("admin");
                menu.setCreatedBy(user);
                menuService.addNewMenu(menu);
                activityService.addNewActivity(new ActivityEntity("add",menusCollection,menu.getId()),user1);
            });

            MenuEntity menuAdmin = menuService.readMenuByName("admin");
            activityService.addNewActivity(new ActivityEntity("read",menusCollection,menuAdmin.getId()),user1);
            Stream.of(new MenuItemEntity("Paramètres Système",null,null,1,null,menuAdmin,null),
                    new MenuItemEntity("Gestion des Accès",null,null,1,null,menuAdmin,null),
                    new MenuItemEntity("Gestion des Utilisateurs",null,null,1,null,menuAdmin,null),
                    new MenuItemEntity("Gestion des Roles",null,null,2,null,menuAdmin,null),
                    new MenuItemEntity("Gestion des Permissions",null,null,3,null,menuAdmin,null),
                    new MenuItemEntity("Les Sessions Utilisateurs",null,null,4,null,menuAdmin,null),
                    new MenuItemEntity("Gestion des Menus",null,null,2,null,menuAdmin,null),
                    new MenuItemEntity("Gestion des Eléments Menu",null,null,3,null,menuAdmin,null),
                    new MenuItemEntity("Gestion des Collections",null,null,4,null,menuAdmin,null),
                    new MenuItemEntity("Gestion des Sites",null,null,2,null,menuAdmin,null),
                    new MenuItemEntity("Table des Filiales",null,null,1,null,menuAdmin,null),
                    new MenuItemEntity("Table des Unités",null,null,2,null,menuAdmin,null),
                    new MenuItemEntity("Table des Centres de fret",null,null,3,null,menuAdmin,null)).forEach(menuItem -> {
                UserEntity user = userService.readUserByUsername("admin");
                menuItem.setCreatedBy(user);
                menuItemService.addNewMenuItem(menuItem);
                activityService.addNewActivity(new ActivityEntity("add",menu_itemsCollection,menuItem.getId()),user1);
            });

            menuItemService.addParentToMenuItem("Paramètres Système","Gestion des Accès");
            menuItemService.addParentToMenuItem("Gestion des Accès","Gestion des Utilisateurs");
            menuItemService.addParentToMenuItem("Gestion des Accès","Gestion des Roles");
            menuItemService.addParentToMenuItem("Gestion des Accès","Gestion des Permissions");
            menuItemService.addParentToMenuItem("Gestion des Accès","Les Sessions Utilisateurs");
            menuItemService.addParentToMenuItem("Paramètres Système","Gestion des Menus");
            menuItemService.addParentToMenuItem("Paramètres Système","Gestion des Eléments Menu");
            menuItemService.addParentToMenuItem("Paramètres Système","Gestion des Collections");
            menuItemService.addParentToMenuItem("Gestion des Sites","Table des Filiales");
            menuItemService.addParentToMenuItem("Gestion des Sites","Table des Unités");
            menuItemService.addParentToMenuItem("Gestion des Sites","Table des Centres de fret");

            menuItemService.addPermissionToMenuItem("browse_parametre_systeme","Paramètres Système");
            menuItemService.addPermissionToMenuItem("browse_gestion_acces","Gestion des Accès");
            menuItemService.addPermissionToMenuItem("browse_users","Gestion des Utilisateurs");
            menuItemService.addPermissionToMenuItem("browse_roles","Gestion des Roles");
            menuItemService.addPermissionToMenuItem("browse_permissions","Gestion des Permissions");
            menuItemService.addPermissionToMenuItem("browse_sessions","Les Sessions Utilisateurs");
            menuItemService.addPermissionToMenuItem("browse_menus","Gestion des Menus");
            menuItemService.addPermissionToMenuItem("browse_menu_items","Gestion des Eléments Menu");
            menuItemService.addPermissionToMenuItem("browse_collections","Gestion des Collections");
            menuItemService.addPermissionToMenuItem("browse_gestion_sites","Gestion des Sites");
            menuItemService.addPermissionToMenuItem("browse_filialles","Table des Filiales");
            menuItemService.addPermissionToMenuItem("browse_unites","Table des Unités");
            menuItemService.addPermissionToMenuItem("browse_centres_fret","Table des Centres de fret");

            userService.browseAllUsers().forEach(user-> System.out.println(user.getUsername()));

            roleService.browseAllRoles().forEach(role-> System.out.println(role.getName()));

            collectionService.browseAllCollections().forEach(collection-> System.out.println(collection.getName()));

            permissionService.browseAllPermissions().forEach(permission-> System.out.println(permission.getName()));
        };
    }

}
