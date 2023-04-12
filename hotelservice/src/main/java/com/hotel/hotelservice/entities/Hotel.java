package com.hotel.hotelservice.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {
    
    @Id
  private String id =UUID.randomUUID().toString();
  private String name;
  private String location;
  private String about;

}
