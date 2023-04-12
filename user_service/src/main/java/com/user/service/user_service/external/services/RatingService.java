package com.user.service.user_service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.service.user_service.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
@Service
public interface RatingService {
    
    @PostMapping("/ratings")
     Rating createRarting(Rating ratings);

//     @DeleteMapping("/ratings/{ratingId}")
//    public void deleteRating(@PathVariable String ratinngId);
     
    // @PutMapping("/ratings/{ratingId}")
    //  public Rating updateRating(@PathVariable String ratingId,Rating rating);
}
