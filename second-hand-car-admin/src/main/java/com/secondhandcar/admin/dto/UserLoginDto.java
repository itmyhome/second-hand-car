package com.secondhandcar.admin.dto;

import lombok.Data;

/**
 * Created by xiet on 2017/10/24.
 */
@Data
public class UserLoginDto {

    private String username;
    private String password;
    private String remember;
    private String kaptcha;
}
