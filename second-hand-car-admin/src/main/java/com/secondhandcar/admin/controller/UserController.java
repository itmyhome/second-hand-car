package com.secondhandcar.admin.controller;

import com.secondhandcar.admin.common.enums.BizExceptionEnum;
import com.secondhandcar.admin.common.enums.UserStatusEnum;
import com.secondhandcar.admin.common.exception.BussinessException;
import com.secondhandcar.admin.dao.UserDao;
import com.secondhandcar.admin.dto.UserAddDto;
import com.secondhandcar.admin.model.User;
import com.secondhandcar.admin.utils.ShiroUtils;
import com.secondhandcar.admin.utils.UserFactory;
import com.secondhandcar.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by xiet on 2017/10/10.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    private static String PREFIX = "/system/user/";

    @Resource
    private UserDao userDao;

    /**
     * 跳转到查看管理员列表的页面
     */
    @RequestMapping("/user_add")
    public String addView() {
        return PREFIX + "user_add.html";
    }


    /**
     * 添加管理员
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object add(@Valid UserAddDto userAddDto, BindingResult result) {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }

        // 判断账号是否重复
        User theUser = userDao.getByAccount(userAddDto.getAccount());
        if (theUser != null) {
            throw new BussinessException(BizExceptionEnum.USER_ALREADY_REG);
        }

        // 完善账号信息
        userAddDto.setSalt(ShiroUtils.getRandomSalt(5));
        userAddDto.setPassword(ShiroUtils.md5(userAddDto.getPassword(), userAddDto.getSalt()));
        userAddDto.setStatus(UserStatusEnum.OK.getCode());
        userAddDto.setCreatetime(new Date());

        userDao.insert(UserFactory.createUser(userAddDto));
        return SUCCESS_TIP;
    }
}
