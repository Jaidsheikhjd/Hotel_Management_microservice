package com.rating.ratingservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.ratingservice.entities.Rating;
import com.rating.ratingservice.repo.RatingRepo;
import com.rating.ratingservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
   
    @Autowired 
    private RatingRepo ratingRepo;

    @Override
    public Rating createRating(Rating rating) {
         Rating rating1 = this.ratingRepo.save(rating);
         return rating1;
    }

    @Override
    public List<Rating> getAllRating() {
             List<Rating> ratings  = this.ratingRepo.findAll();
             return ratings;
    }

    @Override
    public List<Rating> getAllByUSerId(String userId) {
      List<Rating> ratings = this.ratingRepo.findByUserId(userId);
      return ratings;
    }

    @Override
    public List<Rating> getAllByHotelId(String hotelId) {
        List<Rating> ratings = this.ratingRepo.findByHotelId(hotelId);
        return ratings;
    }
    
}
