package com.hotel.hotelservice.serviceImpl;

import java.util.List;
import com.hotel.hotelservice.repositories.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.hotelservice.entities.Hotel;
import com.hotel.hotelservice.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

   @Autowired
   private HotelRepo hotelRepo; 

    @Override
    public List<Hotel> GetAllHotels() {
         List<Hotel> hotels = this.hotelRepo.findAll();
        return hotels;
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        Hotel hotel1 = this.hotelRepo.save(hotel);
        return hotel1;
    }

    @Override
    public void deleteHotel(String HotelId) {
        Hotel hotel = this.hotelRepo.getHotelById(HotelId);
      this.hotelRepo.delete(hotel);      
    }

    @Override
    public Hotel getSingalHotel(String HotelId) {
       Hotel hotel =this.hotelRepo.getHotelById(HotelId);
        return hotel;
    }

    @Override
    public Hotel updateHotel(Hotel hotel) {
        Hotel hotel2 = this.hotelRepo.save(hotel);
        return hotel2;
    }
    
}
