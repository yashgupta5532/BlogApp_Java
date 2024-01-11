package com.codewithyash.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserDto {
    private int id;

    @NotEmpty
    @Size(min = 4, message = "Username must be minimum 4 characters")
    private String name;

    @Email(message = "Invalid Email ")
    private String email;

    @NotEmpty(message = "Password required")
    @Size(min = 4, message = "Password must be greater than 4 characters")
    private String password;

    @NotEmpty
    private String about;
}
