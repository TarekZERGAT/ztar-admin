package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.PermissionEntity;
import com.ztardz.ztaradminapi.models.RoleEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import com.ztardz.ztaradminapi.repositories.PermissionRepository;
import com.ztardz.ztaradminapi.repositories.RoleRepository;
import com.ztardz.ztaradminapi.repositories.UserRepository;
import com.ztardz.ztaradminapi.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PermissionRepository permissionRepository;

    @Override
    public List<UserEntity> browseAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity readUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity editUser(UserEntity user) {

        return null;
    }

    @Override
    public UserEntity addNewUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UserEntity user) {

    }

    @Override
    public void addRoleToUser(String roleName, String userName) {
        /*userRepository.findAll().forEach(user->{
            System.out.println(user.getUsername());
            user.getRoles().forEach(role->{
                System.out.println(role.getName());
            });
        });*/

        RoleEntity role = roleRepository.findByName(roleName);
        UserEntity user = userRepository.findByUsername(userName);
        user.addRole(role);
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
    public void addPermissionToUser(String permissionName, String userName) {
        PermissionEntity permission = permissionRepository.findByName(permissionName);
        UserEntity user = userRepository.findByUsername(userName);
        //System.out.println(user.getUsername());
        //UserEntity userCreation = user.getCreatedBy();
        //System.out.println(userCreation.getUsername());
        user.addPermission(permission);
        //user.getPermissions().add(permission);
    }
}
