package com.pranay.authappbackend.services;

import com.pranay.authappbackend.Dtos.UpdateUserDto;
import com.pranay.authappbackend.Dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByEmail(String email);

    UserDto getUserById(UUID userId);

    UserDto updateUser(UpdateUserDto updateUserDto, UUID userId);

    void deleteUser(UUID userId);

    List<UserDto> getAllUsers();
}
