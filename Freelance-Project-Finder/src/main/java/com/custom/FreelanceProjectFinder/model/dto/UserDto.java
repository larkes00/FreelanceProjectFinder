package com.custom.FreelanceProjectFinder.model.dto;

import com.custom.FreelanceProjectFinder.model.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User convertDtoToEntity() {
        return new User(getUserId(), getFirstName(), getLastName(), getEmail(), getPassword(), null, null);
    }
}
