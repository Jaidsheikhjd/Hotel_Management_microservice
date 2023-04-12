package com.rating.ratingservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rating.ratingservice.entities.Rating;

public interface RatingRepo extends JpaRepository<Rating,String> {
    
    List<Rating> findByUserId(String UserId);
         
    List<Rating> findByHotelId(String HotelId);
}
