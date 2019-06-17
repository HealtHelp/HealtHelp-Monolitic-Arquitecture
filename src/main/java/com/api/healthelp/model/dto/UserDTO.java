package com.api.healthelp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO  {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String profile;
    private String tenant;

}
