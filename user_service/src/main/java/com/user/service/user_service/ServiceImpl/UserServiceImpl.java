package com.user.service.user_service.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.user_service.entities.Hotel;
import com.user.service.user_service.entities.Rating;
import com.user.service.user_service.entities.User;
import com.user.service.user_service.external.services.HotelService;
import com.user.service.user_service.repo.UserRepo;
import com.user.service.user_service.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public User savedUser(User user) {
        User user2 = this.userRepo.save(user);
        return user2;

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users;
    }

    // http://localhost:9092/ratings/user/
    @Override
    public User getSingleUser(String userId) {
        User user = this.userRepo.getUserByUserId(userId);
       Rating[] ratingsofUsers = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getUserId(), Rating[].class);
       
     List<Rating> ratings = Arrays.stream(ratingsofUsers).toList();

       List<Rating> raitngList = ratings.stream().map(rating -> {
        // call api of hotel service to get hotels 
        // http://localhost:9595/hotel/1
       
        // Hotel forEntity =restTemplate.getForObject("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
        Hotel forEntity = hotelService.getHotel(rating.getHotelId());
        rating.setHotel(forEntity);
    
        return rating;
       }).collect(Collectors.toList());
       
       user.setRatings(raitngList);

        return user;
    }

    @Override
    public void deleteUser(String userId) {
        User user = this.userRepo.getUserByUserId(userId);
        this.userRepo.delete(user);

    }

    @Override
    public User updateUser(User user) {
        User user2 = this.userRepo.save(user);
        return user2;

    }

}
