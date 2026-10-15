package com.pranay.authappbackend.services.serviceImpl;

import com.pranay.authappbackend.Dtos.UserDto;
import com.pranay.authappbackend.models.User;
import com.pranay.authappbackend.repositories.UserRepository;
import com.pranay.authappbackend.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {

        if (userDto.getEmail() == null || userDto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is Required.");
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }
        User user = modelMapper.map(userDto, User.class);
        // TODO: Create a user role during the creation of user when implementing authentication.
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, UUID userId) {
        return null;
    }

    @Override
    public void deleteUser(UUID userId) {

    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(
                        (user ->
                                modelMapper
                                        .map(user, UserDto.class)))
                .toList();
    }
}
