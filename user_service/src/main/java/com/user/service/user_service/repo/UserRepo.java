package com.user.service.user_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.user.service.user_service.entities.User;

@Repository
public interface UserRepo  extends JpaRepository<User,Integer>{
    

  User getUserByUserId(String UserId);
      
}
