package com.example.itemservice.api;

import com.example.itemservice.dto.ItemDto;
import com.example.itemservice.dto.UserDto;
import com.example.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v2/item")
public class ItemApi {

    @Autowired
    ItemService service;

    @Autowired
    RestTemplate template;

    /*public ResponseEntity<String> SaveItem(ItemDto itemDto){
        service.Save(itemDto);
        return new ResponseEntity<>(itemDto+"Item Saved Successfully...", HttpStatus.OK);*/

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody UserDto userDto){
        String response = template.postForObject("http://localhost:9083/userService/api/v2/user", userDto, String.class);
        return response;
    }

    @PostMapping
    public String saveItem(@RequestBody  ItemDto itemDto){
        System.out.println(itemDto);
        service.Save(itemDto);
        return "successful";
    }

}
