package com.dashboardai.dto;

import com.dashboardai.entity.User;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private Set<User.Role> roles;
}
