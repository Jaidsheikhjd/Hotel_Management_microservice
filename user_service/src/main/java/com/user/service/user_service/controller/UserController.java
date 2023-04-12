package com.user.service.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.user_service.entities.User;
import com.user.service.user_service.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class UserController {
   @Autowired 
   private UserService userService;
   
    @PostMapping("/user")
   public ResponseEntity<User> PostUser(@RequestBody User user ) {
    User user2=this.userService.savedUser(user);
      return new ResponseEntity<>(user2,HttpStatus.CREATED);

   }

   @GetMapping("/user")
   public ResponseEntity<List<User>> getAllUser( ) {
    List<User> user2=this.userService.getAllUsers();
      return new ResponseEntity<List<User>>(user2,HttpStatus.OK);
   }

   int retryCount = 1;

   @GetMapping("/user/{userId}")
   // @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//   @Retry(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
   @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
  public ResponseEntity<User> SingleUser(@PathVariable String userId ) {
     System.out.print("retry count{} : "+retryCount);
      retryCount++;
      User user2=this.userService.getSingleUser(userId);
      return new ResponseEntity<>(user2,HttpStatus.CREATED);
   }
//   create fallback method
public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex) {
   User user = User.builder()
   .email("dummy@gmail.com")
   .name("dummy")
   .about("this user is dummy because some service is down")
   .userId("123123")
   .build();
   return new ResponseEntity<>(user,HttpStatus.OK);

}




   @PutMapping("/user")
   public ResponseEntity<User> updateUser(@RequestBody User user ) {
    User user2=this.userService.updateUser(user);
      return new ResponseEntity<>(user2,HttpStatus.CREATED);

   }
   @DeleteMapping("/user/{serId}")
   public ResponseEntity<?> deleteUser(@PathVariable String userId ) {
    this.userService.deleteUser(userId);
      return new ResponseEntity<>(HttpStatus.CREATED);

   }
   
}
