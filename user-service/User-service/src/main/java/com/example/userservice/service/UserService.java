package com.example.userservice.service;

import com.example.userservice.dto.UserDto;

import java.util.List;

public interface UserService {
    public void Save(UserDto userDto);
    public void update(UserDto userDto);
    public void  delete(String id);
    UserDto findById(String id);
    List<UserDto>getAll();
}
