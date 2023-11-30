package com.example.userservice.util;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Converter {
    @Autowired
    ModelMapper modelMapper;

    public UserEntity UserDtoToUserEntity(UserDto userDto){
        return modelMapper.map(userDto, UserEntity.class);
    }

    public UserDto UserEntityToUserDto(UserEntity userEntity){
        return modelMapper.map(userEntity,UserDto.class);
    }
}
