package com.user.service.user_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.user.service.user_service.entities.Rating;
import com.user.service.user_service.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
      
	@Autowired
	private RatingService ratingService;
   
	@Test
	void creatRating(){

		Rating rating= Rating.builder().rating(4).feedback("its a great hotel").userId("1").hotelId("2").build();
		ratingService.createRarting(rating);
		System.out.println("created rating");
	}
}
