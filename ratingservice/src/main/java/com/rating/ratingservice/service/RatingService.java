package com.rating.ratingservice.service;

import java.util.List;



import com.rating.ratingservice.entities.Rating;

public interface RatingService {
    Rating createRating(Rating rating);

    List<Rating> getAllRating();

    List<Rating> getAllByUSerId(String userId);

    List<Rating> getAllByHotelId(String hotelId);


}
