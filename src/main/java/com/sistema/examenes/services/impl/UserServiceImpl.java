package com.sistema.examenes.services.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.examenes.exceptions.UserFoundException;
import com.sistema.examenes.models.User;
import com.sistema.examenes.models.UserRole;
import com.sistema.examenes.repository.RoleRepository;
import com.sistema.examenes.repository.UserRepository;
import com.sistema.examenes.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception {
        User userLocal = userRepository.findByUsername(user.getUsername());
        if (userLocal != null) {
            System.out.println("El usuario ya existe");
            throw new UserFoundException("El usuario ya existe");
        }
        else{
            for(UserRole userRole: userRoles){
                roleRepository.save(userRole.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            userLocal = userRepository.save(user);
        }
        return userLocal;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


    
}
