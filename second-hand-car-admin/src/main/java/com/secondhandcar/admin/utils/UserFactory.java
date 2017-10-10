package com.secondhandcar.admin.utils;

import com.secondhandcar.admin.dto.UserAddDto;
import com.secondhandcar.admin.model.User;
import org.springframework.beans.BeanUtils;

public class UserFactory {

    public static User createUser(UserAddDto userAddDto){
        if(userAddDto == null){
            return null;
        }else{
            User user = new User();
            BeanUtils.copyProperties(userAddDto,user);
            return user;
        }
    }
}