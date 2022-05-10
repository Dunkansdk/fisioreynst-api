package com.dunkan.fisioreynstapi.authentication.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {

    private String username;
    private String email;
    private String password;
    private Set<String> role;

}
