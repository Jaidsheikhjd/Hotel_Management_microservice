package com.rating.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rating.ratingservice.entities.Rating;
import com.rating.ratingservice.service.RatingService;
 
@Controller
public class RatingController {
    
    @Autowired
    private RatingService ratingService;

    @PostMapping("/ratings")
    public ResponseEntity<Rating> createRatings(@RequestBody Rating ratings) {
         Rating rating1 = this.ratingService.createRating(ratings);
         return new ResponseEntity<>(rating1,HttpStatus.CREATED);
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<Rating>> getAllRatings() {
         List<Rating> rating1 = this.ratingService.getAllRating();
         return new ResponseEntity<>(rating1,HttpStatus.CREATED);
    }

    @GetMapping("/ratings/user/{UserId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUser(@PathVariable String UserId) {
         List<Rating> rating1 = this.ratingService.getAllByUSerId(UserId);
         return new ResponseEntity<>(rating1,HttpStatus.CREATED);
    }

    @GetMapping("/ratings/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotel(@PathVariable String hotelId) {
         List<Rating> rating1 = this.ratingService.getAllByHotelId(hotelId);
         return new ResponseEntity<>(rating1,HttpStatus.CREATED);
    }

}
