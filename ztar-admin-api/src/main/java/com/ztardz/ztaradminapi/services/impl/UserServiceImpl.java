package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.*;
import com.ztardz.ztaradminapi.repositories.*;
import com.ztardz.ztaradminapi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PermissionRepository permissionRepository;

    private ActivityRepository activityRepository;

    private CollectionRepository collectionRepository;

    private CollectionEntity collection;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository, ActivityRepository activityRepository, CollectionRepository collectionRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.activityRepository = activityRepository;
        this.collectionRepository = collectionRepository;
        this.collection = collectionRepository.findByName("users");
    }

    @Override
    public List<UserEntity> browseAllUsers(UserEntity createdBy) {
        List<UserEntity> users = userRepository.findAll();
        ActivityEntity activity = new ActivityEntity("browse",collection,null,createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return users;
    }

    @Override
    public UserEntity readUserByUsername(String username,UserEntity createdBy) {
        UserEntity user = userRepository.findByUsername(username);

        if((username == "admin")&&(createdBy == null)) {
            ActivityEntity activity = new ActivityEntity("read", collection, user.getId(), user);
            activityRepository.save(activity);
        }else{
            ActivityEntity activity = new ActivityEntity("read", collection, user.getId(), createdBy);
            activityRepository.save(activity);
        }
        return user;
    }

    @Override
    public UserEntity editUser(UserEntity userToEdit,UserEntity createdBy) {
        userToEdit.setUpdatedAt(new Date());
        userToEdit.setUpdatedBy(createdBy);
        UserEntity user = userRepository.save(userToEdit);
        ActivityEntity activity = new ActivityEntity("edit", collection, user.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return user;
    }

    @Override
    public UserEntity addNewUser(UserEntity userToAdd,UserEntity createdBy) {
        userToAdd.setCreatedBy(createdBy);
        UserEntity user = userRepository.save(userToAdd);
        ActivityEntity activity = new ActivityEntity("add", collection, user.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return user;
    }

    @Override
    public void deleteUser(UserEntity userToDelete,UserEntity createdBy, String motif) {
        userToDelete.setDeletedAt(new Date());
        userToDelete.setDeletedBy(createdBy);
        userToDelete.setDeletedFor(motif);
        UserEntity user = userRepository.save(userToDelete);
        ActivityEntity activity = new ActivityEntity("delete", collection, user.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
    }

    @Override
    public void addRoleToUser(String roleName, String userName,UserEntity createdBy) {
        /*userRepository.findAll().forEach(user->{
            System.out.println(user.getUsername());
            user.getRoles().forEach(role->{
                System.out.println(role.getName());
            });
        });*/
        RoleEntity role = roleRepository.findByName(roleName);
        UserEntity user = userRepository.findByUsername(userName);
        user.addRole(role);
        ActivityEntity activity = new ActivityEntity("action03", collection, user.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        //user.getRoles().add(role);
        /*List<RoleEntity> roles =  user.getRoles();
        System.out.println(roles.size());
        /*try {
            user.getRoles().forEach(r->{
                System.out.println(r.getName());
            });
        }catch (Exception e){
            System.out.println(e.getMessage());
        }*/
    }

    @Override
    public void addPermissionToUser(String permissionName, String userName,UserEntity createdBy) {
        PermissionEntity permission = permissionRepository.findByName(permissionName);
        UserEntity user = userRepository.findByUsername(userName);
        user.addPermission(permission);
        ActivityEntity activity = new ActivityEntity("action04", collection, user.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        //System.out.println(user.getUsername());
        //UserEntity userCreation = user.getCreatedBy();
        //System.out.println(userCreation.getUsername());

        //user.getPermissions().add(permission);
    }
}
