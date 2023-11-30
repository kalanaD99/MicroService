package com.example.itemservice.util;

import com.example.itemservice.dto.ItemDto;
import com.example.itemservice.entity.ItemEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    @Autowired
    ModelMapper modelMapper;

    public ItemEntity getUserEntity(ItemDto itemDto){
        return modelMapper.map(itemDto, ItemEntity.class);
    }
    public ItemDto getUserDTO(ItemEntity itemEntity){
        return modelMapper.map(itemEntity, ItemDto.class);
    }
}
