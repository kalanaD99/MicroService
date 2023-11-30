package com.example.userservice.api;

import com.example.userservice.dto.ItemDto;
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
    public String SaveUser(@RequestBody UserDto userDto){
        System.out.println(userDto);
        service.Save(userDto);
        return "Successfull !";
    }
    @PostMapping("/saveItem")
    public String saveItem(@RequestBody ItemDto itemDto){
        String response = template.postForObject("http://localhost:9085/userService/api/v2/item", itemDto, String.class);
        return response;


    }
}
