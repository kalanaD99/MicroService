package com.example.userservice.service.util;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repo.UserRepo;
import com.example.userservice.service.UserService;
import com.example.userservice.util.Converter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    Converter converter;

    @Autowired
    UserRepo repo;

    @Override
    public void Save(UserDto userDto) {
        if (repo.existsById(userDto.getUserId())){
            throw new RuntimeException(userDto.getUserId()+"User Already Exists");
        }
        repo.save(converter.UserDtoToUserEntity(userDto));

    }

    @Override
    public void update(UserDto userDto) {
        if (!repo.existsById(userDto.getUserId())){
            throw new RuntimeException(userDto.getUserId()+"User does not Exists");
        }
        repo.save(converter.UserDtoToUserEntity(userDto));

    }

    @Override
    public void delete(String id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException(id + "User does not Exists");
        }
        repo.deleteById(id);
    }

    @Override
    public UserDto findById(String id) {
        Optional<UserEntity> optionalUserEntity = repo.findById(id);
        if (optionalUserEntity.isEmpty())
            throw new RuntimeException(id+ "User does not Exists");
        return converter.UserEntityToUserDto(optionalUserEntity.get());
    }

    @Override
    public List<UserDto> getAll() {
        //get all repo
        // loop
//        conver
//        userDtos.add()
        List<UserDto>userDtos=new ArrayList<>();

        List<UserEntity>userEntities = repo.findAll();
        for (UserEntity entity: userEntities) {
            UserDto dto = converter.UserEntityToUserDto(entity);
            userDtos.add(dto);
        }
        return userDtos;
    }
}
