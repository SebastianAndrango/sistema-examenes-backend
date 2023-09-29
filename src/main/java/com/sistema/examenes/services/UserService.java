package com.sistema.examenes.services;

import java.util.Set;

import com.sistema.examenes.models.User;
import com.sistema.examenes.models.UserRole;

public interface UserService {
    
    public User saveUser(User user, Set<UserRole> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(Long userId);
}
