package com.pranay.authappbackend.services.serviceImpl;

import com.pranay.authappbackend.Dtos.RegisterUserDto;
import com.pranay.authappbackend.Dtos.UserDto;
import com.pranay.authappbackend.repositories.UserRepository;
import com.pranay.authappbackend.services.AuthService;
import com.pranay.authappbackend.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public RegisterUserDto registerUser(RegisterUserDto userDto) {
        UserDto mappedUserDto = modelMapper.map(userDto, UserDto.class);
        mappedUserDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserDto createdUser = userService.createUser(mappedUserDto);
        return modelMapper.map(createdUser, RegisterUserDto.class);
    }
}
