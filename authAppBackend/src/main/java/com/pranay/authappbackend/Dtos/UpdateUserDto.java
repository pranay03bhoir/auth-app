package com.pranay.authappbackend.Dtos;

import com.pranay.authappbackend.models.Provider;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserDto {
    private String name;
    private String password;
    private String image;
    private boolean enabled;
    private Provider provider;
}
