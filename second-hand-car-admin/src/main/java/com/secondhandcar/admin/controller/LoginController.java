package com.secondhandcar.admin.controller;

import com.secondhandcar.core.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by xiet on 2017/10/10.
 */
@Controller
@Slf4j
public class LoginController extends BaseController {

    /**
     * 跳转到主页
     */
    @GetMapping(value = "/")
    public String index(Model model) {
        log.info("跳转到主页");
        //获取菜单列表
//        List<Integer> roleList = ShiroKit.getUser().getRoleList();
//        if (roleList == null || roleList.size() == 0) {
//            ShiroKit.getSubject().logout();
//            model.addAttribute("tips", "该用户没有角色，无法登陆");
//            return "/login.html";
//        }
//        List<MenuNode> menus = menuDao.getMenusByRoleIds(roleList);
//        List<MenuNode> titles = MenuNode.buildTitle(menus);
//        titles = ApiMenuFilter.build(titles);
//
//        model.addAttribute("titles", titles);
//
//        //获取用户头像
//        Integer id = ShiroKit.getUser().getId();
//        User user = userMapper.selectById(id);
//        String avatar = user.getAvatar();
//        model.addAttribute("avatar", avatar);
        return "/index.html";
    }
}
