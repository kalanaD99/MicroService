package com.example.userservice.api;

import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v2/user")
public class UserApi {
    @Autowired
   UserService service;

    @Autowired
    RestTemplate template;

    @PostMapping
    public ResponseEntity<String> SaveUser(@RequestBody UserDto userDto){
        service.Save(userDto);
        return new ResponseEntity<>(userDto.getUserId()+"User Saved Successfully !...", HttpStatus.OK);
    }
}
