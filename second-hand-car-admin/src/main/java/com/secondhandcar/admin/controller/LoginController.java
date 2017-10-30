package com.secondhandcar.admin.controller;

import com.secondhandcar.admin.dao.MenuDao;
import com.secondhandcar.admin.dao.UserDao;
import com.secondhandcar.admin.dto.UserLoginDto;
import com.secondhandcar.admin.model.User;
import com.secondhandcar.admin.utils.ShiroUser;
import com.secondhandcar.admin.utils.ShiroUtils;
import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.core.node.MenuNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiet on 2017/10/10.
 */
@Controller
@Slf4j
public class LoginController extends BaseController {

    @Resource
    private MenuDao menuDao;

    @Resource
    private UserDao userDao;

    /**
     * 跳转到主页
     */
    @GetMapping(value = "/")
    public String index(Model model) {
        log.info("跳转到主页");
        //获取菜单列表
        List<Integer> roleList = ShiroUtils.getUser().getRoleList();
        if (roleList == null || roleList.size() == 0) {
            ShiroUtils.getSubject().logout();
            model.addAttribute("tips", "该用户没有角色，无法登陆");
            return "/login.html";
        }
//        List<Integer> roleList = Lists.newArrayList(1);
        List<MenuNode> menus = menuDao.getMenusByRoleIds(roleList);
        List<MenuNode> menuNodeList = MenuNode.buildTitle(menus);
        model.addAttribute("menuNodeList", menuNodeList);
//
//        //获取用户头像
        Integer id = ShiroUtils.getUser().getId();
        User user = userDao.selectById(id);
        String avatar = user.getAvatar();
        model.addAttribute("avatar", avatar);
        return "/index.html";
    }

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (ShiroUtils.isAuthenticated() || ShiroUtils.getUser() != null) {
            return REDIRECT + "/";
        } else {
            return "/login.html";
        }
    }

    /**
     * 执行登录动作
     *
     * @return
     */
    @PostMapping(value = "login")
    public String loginVali(UserLoginDto userLoginDto) {
        //验证验证码是否正确
//        if (KaptchaUtil.getKaptchaOnOff()) {
//            String kaptcha = super.getPara("kaptcha").trim();
//            String code = (String) super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//            if (ToolUtil.isEmpty(kaptcha) || !kaptcha.equalsIgnoreCase(code)) {
//                throw new InvalidKaptchaException();
//            }
//        }
        Subject currentUser = ShiroUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userLoginDto.getUsername(), userLoginDto.getPassword().toCharArray());

        if ("on".equals(userLoginDto.getRemember())) {
            token.setRememberMe(true);
        } else {
            token.setRememberMe(false);
        }

        currentUser.login(token);

        ShiroUser shiroUser = ShiroUtils.getUser();
        super.getSession().setAttribute("shiroUser", shiroUser);
        super.getSession().setAttribute("username", shiroUser.getAccount());

//        LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(), getIp()));

        ShiroUtils.getSession().setAttribute("sessionFlag", true);

        return REDIRECT + "/";
    }

    /**
     * 退出登录
     */
    @GetMapping(value = "/logout")
    public String logOut() {
//        LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), getIp()));
        ShiroUtils.getSubject().logout();
        return REDIRECT + "/login";
    }

}
