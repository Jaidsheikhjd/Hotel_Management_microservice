package com.hotel.hotelservice.contoller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotelservice.entities.Hotel;
import com.hotel.hotelservice.services.HotelService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class HotelController {
    
  @Autowired
  private HotelService hotelService;
 
  @PostMapping("/hotel")
   public ResponseEntity<Hotel> postHotel(@RequestBody Hotel hotel){
     Hotel hotel1 = this.hotelService.createHotel(hotel);
     return new ResponseEntity<>(hotel1,HttpStatus.CREATED);
   }

   @GetMapping("/hotel/{hotelId}")
   public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId){
     Hotel hotel1 = this.hotelService.getSingalHotel(hotelId);
     return new ResponseEntity<>(hotel1,HttpStatus.OK);
   }
   @GetMapping("/hotel")
   public ResponseEntity<List<Hotel>> getAllHotelss(){
     List<Hotel> hotel1 = this.hotelService.GetAllHotels();
     return new ResponseEntity<>(hotel1,HttpStatus.OK);
   }
   
   @PutMapping("/hotel")
   public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel){
     Hotel hotel1 = this.hotelService.updateHotel(hotel);
     return new ResponseEntity<>(hotel1,HttpStatus.CREATED);
   }
   @DeleteMapping("/hotel/{hotelId}")
   public ResponseEntity<?> deleteSingleHotel(@PathVariable String hotelId){
     this.hotelService.deleteHotel(hotelId);
     return new ResponseEntity<>(HttpStatus.OK);
   }


}
