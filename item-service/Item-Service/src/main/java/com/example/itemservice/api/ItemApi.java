package com.example.itemservice.api;

import com.example.itemservice.dto.ItemDto;
import com.example.itemservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

   /* @PostMapping("save")
    public String saveitem(){
        return template.getForObject("http://localhost:8080/User-service/api/v1/user/save", String.class);
    }*/

    @PostMapping("save")
    public ResponseEntity

}
