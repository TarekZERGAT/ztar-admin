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
            /*UserEntity user1 = new UserEntity("Super","Administrateur","admin","admin@gmail.com", "admin");
            user1.setCreatedBy(user1);
            userService.addNewUser(user1);
            CollectionEntity colUsers = new CollectionEntity("users","table",adminUser);
            collectionService.addNewCollection(colUsers);
            CollectionEntity col = new CollectionEntity("collections","table",null);
            col.setCreatedBy(user1);
            collectionService.addNewCollection(col);
            CollectionEntity usersCollection = collectionService.readCollectionByName("users");
            activityService.addNewActivity(new ActivityEntity("add",usersCollection,adminUser.getId(),adminUser));
            activityService.addNewActivity(new ActivityEntity("read",usersCollection,adminUser.getId(),adminUser));
            CollectionEntity collectionsCollection = collectionService.readCollectionByName("collections");
            activityService.addNewActivity(new ActivityEntity("add",collectionsCollection,colUsers.getId()),user1);
            activityService.addNewActivity(new ActivityEntity("add",collectionsCollection,collectionsCollection.getId()),user1);
            activityService.addNewActivity(new ActivityEntity("read",collectionsCollection,collectionsCollection.getId()),user1);
            */

            UserEntity adminUser = userService.readUserByUsername("admin",null);

            UserEntity managerUser = new UserEntity("Sites","Manger01","sites_manager01","sites_manager01@gmail.com", "123");
            userService.addNewUser(managerUser,adminUser);

            Stream.of(new RoleEntity("admin","Administrateur Role",true),
                    new RoleEntity("sites_manager","Sites Manager Role",false)).forEach(role->{
                        roleService.addNewRole(role,adminUser);
                    });

            userService.addRoleToUser("admin","admin",adminUser);
            userService.addRoleToUser("sites_manager","sites_manager01",adminUser);

            CollectionEntity usersCollection = collectionService.readCollectionByName("users",adminUser);
            CollectionEntity collectionsCollection = collectionService.readCollectionByName("collections",adminUser);
            CollectionEntity parametreSystemeCollection = collectionService.readCollectionByName("parametre_systeme",adminUser);
            CollectionEntity gestionAccesCollection = collectionService.readCollectionByName("gestion_acces",adminUser);
            CollectionEntity rolesCollection = collectionService.readCollectionByName("roles",adminUser);
            CollectionEntity permissionsCollection = collectionService.readCollectionByName("permissions",adminUser);
            CollectionEntity sessionsCollection = collectionService.readCollectionByName("sessions",adminUser);
            CollectionEntity menusCollection = collectionService.readCollectionByName("menus",adminUser);
            CollectionEntity menu_itemsCollection = collectionService.readCollectionByName("menu_items",adminUser);
            CollectionEntity gestion_sitesCollection = collectionService.readCollectionByName("gestion_sites",adminUser);
            CollectionEntity filialesCollection = collectionService.readCollectionByName("filiales",adminUser);
            CollectionEntity unitesCollection = collectionService.readCollectionByName("unites",adminUser);
            CollectionEntity fretCentresCollection = collectionService.readCollectionByName("fret_centres",adminUser);

            Stream.of(new PermissionEntity("browse","browse_parametre_systeme",parametreSystemeCollection),
                    new PermissionEntity("browse","browse_gestion_acces",gestionAccesCollection),
                    new PermissionEntity("browse","browse_users",usersCollection),
                    new PermissionEntity("read","read_user",usersCollection),
                    new PermissionEntity("edit","edit_user",usersCollection),
                    new PermissionEntity("add","add_user",usersCollection),
                    new PermissionEntity("delete","delete_user",usersCollection),
                    new PermissionEntity("action01","desactivate_user",usersCollection),
                    new PermissionEntity("action02","init_password",usersCollection),
                    new PermissionEntity("action03","add_role_user",usersCollection),
                    new PermissionEntity("action04","add_permission_user",usersCollection),
                    new PermissionEntity("action05",null,usersCollection),
                    new PermissionEntity("browse","browse_roles",rolesCollection),
                    new PermissionEntity("read","read_role",rolesCollection),
                    new PermissionEntity("edit","edit_role",rolesCollection),
                    new PermissionEntity("add","add_role",rolesCollection),
                    new PermissionEntity("delete","delete_role",rolesCollection),
                    new PermissionEntity("action01","add_permission_role",rolesCollection),
                    new PermissionEntity("action02",null,rolesCollection),
                    new PermissionEntity("action03",null,rolesCollection),
                    new PermissionEntity("action04",null,rolesCollection),
                    new PermissionEntity("action05",null,rolesCollection),
                    new PermissionEntity("browse","browse_permissions",permissionsCollection),
                    new PermissionEntity("read","read_permission",permissionsCollection),
                    new PermissionEntity("edit","edit_permission",permissionsCollection),
                    new PermissionEntity("add","add_permission",permissionsCollection),
                    new PermissionEntity("delete","delete_permission",permissionsCollection),
                    new PermissionEntity("action01",null,permissionsCollection),
                    new PermissionEntity("action02",null,permissionsCollection),
                    new PermissionEntity("action03",null,permissionsCollection),
                    new PermissionEntity("action04",null,permissionsCollection),
                    new PermissionEntity("action05",null,permissionsCollection),
                    new PermissionEntity("browse","browse_sessions",sessionsCollection),
                    new PermissionEntity("read","read_session",sessionsCollection),
                    new PermissionEntity("edit","edit_session",sessionsCollection),
                    new PermissionEntity("'add","add_session",sessionsCollection),
                    new PermissionEntity("delete","delete_session",sessionsCollection),
                    new PermissionEntity("action01",null,sessionsCollection),
                    new PermissionEntity("action02",null,sessionsCollection),
                    new PermissionEntity("action03",null,sessionsCollection),
                    new PermissionEntity("action04",null,sessionsCollection),
                    new PermissionEntity("action05",null,sessionsCollection),
                    new PermissionEntity("browse","browse_menus",menusCollection),
                    new PermissionEntity("read","read_menu",menusCollection),
                    new PermissionEntity("edit","edit_menu",menusCollection),
                    new PermissionEntity("add","add_menu",menusCollection),
                    new PermissionEntity("delete","delete_menu",menusCollection),
                    new PermissionEntity("action01",null,menusCollection),
                    new PermissionEntity("action02",null,menusCollection),
                    new PermissionEntity("action03",null,menusCollection),
                    new PermissionEntity("action04",null,menusCollection),
                    new PermissionEntity("action05",null,menusCollection),
                    new PermissionEntity("browse","browse_menu_items",menu_itemsCollection),
                    new PermissionEntity("read","read_menu_item",menu_itemsCollection),
                    new PermissionEntity("edit","edit_menu_item",menu_itemsCollection),
                    new PermissionEntity("add","add_menu_item",menu_itemsCollection),
                    new PermissionEntity("delete","delete_menu_item",menu_itemsCollection),
                    new PermissionEntity("action01",null,menu_itemsCollection),
                    new PermissionEntity("action02",null,menu_itemsCollection),
                    new PermissionEntity("action03",null,menu_itemsCollection),
                    new PermissionEntity("action04",null,menu_itemsCollection),
                    new PermissionEntity("action05",null,menu_itemsCollection),
                    new PermissionEntity("browse","browse_collections",collectionsCollection),
                    new PermissionEntity("read","read_collection",collectionsCollection),
                    new PermissionEntity("edit","edit_collection",collectionsCollection),
                    new PermissionEntity("add","add_collection",collectionsCollection),
                    new PermissionEntity("delete","delete_collection",collectionsCollection),
                    new PermissionEntity("action01",null,collectionsCollection),
                    new PermissionEntity("action02",null,collectionsCollection),
                    new PermissionEntity("action03",null,collectionsCollection),
                    new PermissionEntity("action04",null,collectionsCollection),
                    new PermissionEntity("action05",null,collectionsCollection),
                    new PermissionEntity("browse","browse_gestion_sites",gestion_sitesCollection),
                    new PermissionEntity("browse","browse_filiales",filialesCollection),
                    new PermissionEntity("read","read_filiale",filialesCollection),
                    new PermissionEntity("edit","edit_filiale",filialesCollection),
                    new PermissionEntity("add","add_filiale",filialesCollection),
                    new PermissionEntity("delete","delete_filiale",filialesCollection),
                    new PermissionEntity("action01",null,filialesCollection),
                    new PermissionEntity("action02",null,filialesCollection),
                    new PermissionEntity("action03",null,filialesCollection),
                    new PermissionEntity("action04",null,filialesCollection),
                    new PermissionEntity("action05",null,filialesCollection),
                    new PermissionEntity("browse","browse_unites",unitesCollection),
                    new PermissionEntity("read","read_unite",unitesCollection),
                    new PermissionEntity("edit","edit_unite",unitesCollection),
                    new PermissionEntity("add","add_unite",unitesCollection),
                    new PermissionEntity("delete","delete_unite",unitesCollection),
                    new PermissionEntity("action01",null,unitesCollection),
                    new PermissionEntity("action02",null,unitesCollection),
                    new PermissionEntity("action03",null,unitesCollection),
                    new PermissionEntity("action04",null,unitesCollection),
                    new PermissionEntity("action05",null,unitesCollection),
                    new PermissionEntity("browse","browse_fret_centres",fretCentresCollection),
                    new PermissionEntity("read","read_fret_centre",fretCentresCollection),
                    new PermissionEntity("edit","edit_fret_centre",fretCentresCollection),
                    new PermissionEntity("add","add_fret_centre",fretCentresCollection),
                    new PermissionEntity("delete","delete_fret_centre",fretCentresCollection),
                    new PermissionEntity("action01",null,fretCentresCollection),
                    new PermissionEntity("action02",null,fretCentresCollection),
                    new PermissionEntity("action03",null,fretCentresCollection),
                    new PermissionEntity("action04",null,fretCentresCollection),
                    new PermissionEntity("action05",null,fretCentresCollection)
                    ).forEach(permission -> {
                        permissionService.addNewPermission(permission,adminUser);
                    });

            roleService.addPermissionToRole("browse_gestion_sites","sites_manager",adminUser);
            roleService.addPermissionToRole("browse_filiales","sites_manager",adminUser);
            roleService.addPermissionToRole("read_filiale","sites_manager",adminUser);
            roleService.addPermissionToRole("edit_filiale","sites_manager",adminUser);
            roleService.addPermissionToRole("add_filiale","sites_manager",adminUser);
            roleService.addPermissionToRole("delete_filiale","sites_manager",adminUser);
            roleService.addPermissionToRole("browse_unites","sites_manager",adminUser);
            roleService.addPermissionToRole("read_unite","sites_manager",adminUser);
            roleService.addPermissionToRole("edit_unite","sites_manager",adminUser);
            roleService.addPermissionToRole("add_unite","sites_manager",adminUser);
            roleService.addPermissionToRole("delete_unite","sites_manager",adminUser);
            roleService.addPermissionToRole("browse_fret_centres","sites_manager",adminUser);
            roleService.addPermissionToRole("read_fret_centre","sites_manager",adminUser);
            roleService.addPermissionToRole("edit_fret_centre","sites_manager",adminUser);
            roleService.addPermissionToRole("add_fret_centre","sites_manager",adminUser);
            roleService.addPermissionToRole("delete_fret_centre","sites_manager",adminUser);

            userService.addPermissionToUser("browse_parametre_systeme","sites_manager01",adminUser);
            userService.addPermissionToUser("browse_gestion_acces","sites_manager01",adminUser);
            userService.addPermissionToUser("browse_users","sites_manager01",adminUser);
            userService.addPermissionToUser("read_user","sites_manager01",adminUser);

            Stream.of(new MenuEntity("admin")).forEach(menu -> {
                menuService.addNewMenu(menu,adminUser);
            });

            MenuEntity menuAdmin = menuService.readMenuByName("admin",adminUser);
            PermissionEntity parametresSystemePermission = permissionService.readPermissionByName("browse_parametre_systeme",adminUser);
            PermissionEntity gestionSitesPermission = permissionService.readPermissionByName("browse_gestion_sites",adminUser);
            Stream.of(new MenuItemEntity("Paramètres Système",null,1,menuAdmin,parametresSystemePermission),
                    new MenuItemEntity("Gestion des Sites",null,2,menuAdmin,gestionSitesPermission)).forEach(menuItem -> {
                menuItemService.addNewMenuItem(menuItem,adminUser);
            });

            MenuItemEntity parametresSystemeMenuItem = menuItemService.readMenuItemByTitle("Paramètres Système",adminUser);
            MenuItemEntity gestionSitesMenuItem = menuItemService.readMenuItemByTitle("Gestion des Sites",adminUser);
            PermissionEntity gestionAccesPermission = permissionService.readPermissionByName("browse_gestion_acces",adminUser);
            PermissionEntity menusPermission = permissionService.readPermissionByName("browse_menus",adminUser);
            PermissionEntity menuItemsPermission = permissionService.readPermissionByName("browse_menu_items",adminUser);
            PermissionEntity collectionsPermission = permissionService.readPermissionByName("browse_collections",adminUser);
            PermissionEntity filialesPermission = permissionService.readPermissionByName("browse_filiales",adminUser);
            PermissionEntity unitesPermission = permissionService.readPermissionByName("browse_unites",adminUser);
            PermissionEntity centresFretPermission = permissionService.readPermissionByName("browse_fret_centres",adminUser);
            Stream.of(new MenuItemEntity("Gestion des Accès",parametresSystemeMenuItem,1,menuAdmin,gestionAccesPermission),
                    new MenuItemEntity("Gestion des Menus",parametresSystemeMenuItem,2,menuAdmin,menusPermission),
                    new MenuItemEntity("Gestion des Eléments Menu",parametresSystemeMenuItem,3,menuAdmin,menuItemsPermission),
                    new MenuItemEntity("Gestion des Collections",parametresSystemeMenuItem,4,menuAdmin,collectionsPermission),
                    new MenuItemEntity("Table des Filiales",gestionSitesMenuItem,1,menuAdmin,filialesPermission),
                    new MenuItemEntity("Table des Unités",gestionSitesMenuItem,2,menuAdmin,unitesPermission),
                    new MenuItemEntity("Table des Centres de fret",gestionSitesMenuItem,3,menuAdmin,centresFretPermission)).forEach(menuItem -> {
                menuItemService.addNewMenuItem(menuItem,adminUser);
            });

            MenuItemEntity gestionAccesMenuItem = menuItemService.readMenuItemByTitle("Gestion des Accès",adminUser);
            PermissionEntity usersPermission = permissionService.readPermissionByName("browse_users",adminUser);
            PermissionEntity rolesPermission = permissionService.readPermissionByName("browse_roles",adminUser);
            PermissionEntity permissionsPermission = permissionService.readPermissionByName("browse_permissions",adminUser);
            PermissionEntity sessionsPermission = permissionService.readPermissionByName("browse_sessions",adminUser);
            Stream.of(new MenuItemEntity("Gestion des Utilisateurs",gestionAccesMenuItem,1,menuAdmin,usersPermission),
                    new MenuItemEntity("Gestion des Roles",gestionAccesMenuItem,2,menuAdmin,rolesPermission),
                    new MenuItemEntity("Gestion des Permissions",gestionAccesMenuItem,3,menuAdmin,permissionsPermission),
                    new MenuItemEntity("Les Sessions Utilisateurs",gestionAccesMenuItem,4,menuAdmin,sessionsPermission)).forEach(menuItem -> {
                menuItemService.addNewMenuItem(menuItem,adminUser);
            });

            /*userService.browseAllUsers().forEach(user-> System.out.println(user.getUsername()));

            roleService.browseAllRoles().forEach(role-> System.out.println(role.getName()));

            collectionService.browseAllCollections().forEach(collection-> System.out.println(collection.getName()));

            permissionService.browseAllPermissions().forEach(permission-> System.out.println(permission.getName()));*/
        };
    }

}
