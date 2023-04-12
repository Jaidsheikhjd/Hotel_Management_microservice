package com.user.service.user_service.entities;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data 
@Builder
public class User {
    
  @Id
  private String userId = UUID.randomUUID().toString();

  private String name;

  private String email;

  private String about;

  @Transient
  private List<Rating> ratings = new ArrayList<>();

}
