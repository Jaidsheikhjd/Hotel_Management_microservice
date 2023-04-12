package com.hotel.hotelservice.repositories;

import com.hotel.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;



// @Repository
public interface HotelRepo extends JpaRepository<Hotel,String> {
  
    Hotel getHotelById(String hotelId);
    
}
