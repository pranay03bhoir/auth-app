package com.pranay.authappbackend.security.services.serviceImpl;

import com.pranay.authappbackend.exceptions.ResourceNotFoundException;
import com.pranay.authappbackend.models.User;
import com.pranay.authappbackend.repositories.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @NonNull
    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Credentials!!"));

    }
}
