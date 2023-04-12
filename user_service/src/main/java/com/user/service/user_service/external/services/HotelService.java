package com.user.service.user_service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.user_service.entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
   
    @GetMapping("/hotel/{hotelId}")
   Hotel getHotel(@PathVariable String hotelId);

}
