package com.hotel.hotelservice.services;

import java.util.List;

import com.hotel.hotelservice.entities.Hotel;

public interface HotelService {
   
    Hotel createHotel(Hotel hotel);
    
    Hotel getSingalHotel(String HotelId);

    List<Hotel> GetAllHotels();

    void deleteHotel(String HotelId);

    Hotel updateHotel(Hotel hotel);

}
