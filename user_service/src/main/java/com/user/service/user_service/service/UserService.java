package com.user.service.user_service.service;

import java.util.ArrayList;
import java.util.List;

import com.user.service.user_service.entities.User;

public interface UserService {
    
    User savedUser(User user);
     List<User> getAllUsers();
     User getSingleUser(String userId);
  
     void deleteUser(String userId);
     User updateUser(User user);


}
