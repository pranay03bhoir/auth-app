package com.pranay.authappbackend.services;

import com.pranay.authappbackend.Dtos.RegisterUserDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    RegisterUserDto registerUser(RegisterUserDto userDto);

}
