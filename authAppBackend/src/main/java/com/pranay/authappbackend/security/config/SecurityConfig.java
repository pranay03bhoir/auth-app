package com.pranay.authappbackend.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BcryptPassword4jPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeHttpRequests ->
                        authorizeHttpRequests
                                .requestMatchers("/api/v1/auth/register").permitAll()
                                .requestMatchers("/api/v1/auth/login").permitAll()
                                .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())
                .build();
    }

//    @Bean
//    public UserDetailsService users() {
//
//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        UserDetails user = userBuilder
//                .username("Pranay")
//                .password("abc")
//                .roles("ADMIN")
//                .build();
//        UserDetails user1 = userBuilder
//                .username("Manisha")
//                .password("abc")
//                .roles("USER")
//                .build();
//        UserDetails user2 = userBuilder
//                .username("Durgesh")
//                .password("abc")
//                .roles("GUEST")
//                .build();
//        return new InMemoryUserDetailsManager(user, user1, user2);
//    }
}
