package com.pranay.authappbackend.services;

import com.pranay.authappbackend.Dtos.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserByEmail(String email);

    UserDto updateUser(UserDto userDto, UUID userId);

    void deleteUser(UUID userId);

    List<UserDto> getAllUsers();
}
