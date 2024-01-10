package com.codewithyash.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.codewithyash.blog.entities.User;
import com.codewithyash.blog.exceptions.ResourceNotFoundException;
import com.codewithyash.blog.payloads.UserDto;
import com.codewithyash.blog.services.UserService;
import com.codewithyash.blog.repositories.UserRepo;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo UserRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        User savedUser = this.UserRepo.save(user);  //userRepo
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto usertDto, Integer userId) {
        User user = this.UserRepo.findById(userId)
        .orElseThrow(()->
            new ResourceNotFoundException("User "," Id ",userId)
        );
        user.setName(usertDto.getName());
        user.setEmail(usertDto.getEmail());
        user.setPassword(usertDto.getPassword());  //changes using bcrypt
        user.setAbout(usertDto.getAbout());

        User updatedUser = this.UserRepo.save(user);
        UserDto userDto1=this.userToDto(updatedUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
       User user = this.UserRepo.findById(userId)
       .orElseThrow(()->new ResourceNotFoundException("User", " Id ", userId));
       return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.UserRepo.findAll();
        List<UserDto> userDtos = users.stream()
        .map(user -> this.userToDto(user))
        .collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.UserRepo.findById(userId)
        .orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
        this.UserRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto){
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private UserDto userToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
    
}
