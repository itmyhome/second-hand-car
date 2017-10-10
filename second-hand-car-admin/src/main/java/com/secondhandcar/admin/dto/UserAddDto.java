package com.secondhandcar.admin.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by xiet on 2017/10/10.
 */
@Data
public class UserAddDto {
    private Integer id;
    private String account;
    private String password;
    private String salt;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private Integer sex;
    private String email;
    private String phone;
    private String roleid;
    private Integer deptid;
    private Integer status;
    private Date createtime;
    private Integer version;
    private String avatar;
}
