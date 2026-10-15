package com.pranay.authappbackend.Dtos;

import com.pranay.authappbackend.models.Provider;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private UUID id;
    private String email;
    private String name;
    private String password;
    private String image;
    @Builder.Default
    private boolean enabled = true;
    @Builder.Default
    private Provider provider = Provider.LOCAL;
    @Builder.Default
    private Set<RoleDto> roles = new HashSet<>();
    private Instant updatedAt;
    private Instant createdAt;
}
