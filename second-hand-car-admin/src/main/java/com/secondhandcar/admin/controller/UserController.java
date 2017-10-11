package com.secondhandcar.admin.controller;

import com.secondhandcar.admin.common.enums.BizExceptionEnum;
import com.secondhandcar.admin.common.enums.UserStatusEnum;
import com.secondhandcar.admin.common.exception.BussinessException;
import com.secondhandcar.admin.dao.UserDao;
import com.secondhandcar.admin.dto.UserAddDto;
import com.secondhandcar.admin.model.User;
import com.secondhandcar.admin.utils.ShiroUtils;
import com.secondhandcar.admin.utils.UserFactory;
import com.secondhandcar.admin.warpper.UserWarpper;
import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.core.utils.ToolUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.naming.NoPermissionException;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("")
    public String index() {
        return PREFIX + "user.html";
    }

    /**
     * 跳转到查看管理员列表的页面
     */
    @RequestMapping("/user_add")
    public String userAdd() {
        return PREFIX + "user_add.html";
    }

    /**
     * 跳转到编辑管理员页面
     */
    @RequestMapping("/user_edit/{userId}")
    public String userEdit(@PathVariable Integer userId, Model model) {
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
//        assertAuth(userId);
        User user = userDao.selectById(userId);
        model.addAttribute(user);
        model.addAttribute("roleName", "cccc");
        model.addAttribute("deptName", "cccc");
//        LogObjectHolder.me().set(user);
        return PREFIX + "user_edit.html";
    }

    /**
     * 查询管理员列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String name, @RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime, @RequestParam(required = false) Integer deptid) {
//        if (ShiroUtils.isAdmin()) {
            List<Map<String, Object>> users = userDao.selectUsers(null, name, beginTime, endTime, deptid);
            return new UserWarpper(users).warp();
//        } else {
//            UserQueryDto userQueryDto = new UserQueryDto(ShiroUtils.getDeptDataScope());
//            List<Map<String, Object>> users = userDao.selectUsers(userQueryDto, name, beginTime, endTime, deptid);
//            return new UserWarpper(users).warp();
//        }
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

    /**
     * 修改管理员
     *
     * @throws NoPermissionException
     */
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(@Valid UserAddDto userAddDto, BindingResult result) throws NoPermissionException {
        if (result.hasErrors()) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
//        if (ShiroUtils.hasRole(SystemConstants.ADMIN_NAME)) {
            userDao.updateById(UserFactory.createUser(userAddDto));
            return SUCCESS_TIP;
//        } else {
//            assertAuth(user.getId());
//            ShiroUser shiroUser = ShiroUtils.getUser();
//            if (shiroUser.getId().equals(userAddDto.getId())) {
//                userDao.updateById(UserFactory.createUser(userAddDto));
//                return SUCCESS_TIP;
//            } else {
//                throw new BussinessException(BizExceptionEnum.NO_PERMITION);
//            }
//        }
    }


}
