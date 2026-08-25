package org.vipul.dockerfirst.service;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.vipul.dockerfirst.dto.UserDto;
import org.vipul.dockerfirst.entity.UserEntity;
import org.vipul.dockerfirst.repository.UserRepository;

import java.util.List;

@Service
@Schema(name = "UserService", description = "Service class for user-related operations")
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void saveUser(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        userRepository.save(userEntity);
    }

    public List<UserEntity> getAllUser(){
         return userRepository.findAll();
    }
}
