package com.secondhandcar.admin.controller;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.secondhandcar.admin.common.constants.SystemConstants;
import com.secondhandcar.admin.common.enums.BizExceptionEnum;
import com.secondhandcar.admin.common.enums.UserStatusEnum;
import com.secondhandcar.admin.common.exception.BussinessException;
import com.secondhandcar.admin.common.factory.ConstantFactory;
import com.secondhandcar.admin.config.FileUploadConfig;
import com.secondhandcar.admin.dao.UserDao;
import com.secondhandcar.admin.dto.UserAddDto;
import com.secondhandcar.admin.model.User;
import com.secondhandcar.admin.utils.ShiroUtils;
import com.secondhandcar.admin.utils.UserFactory;
import com.secondhandcar.admin.warpper.UserWarpper;
import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.core.utils.FileUploadUtils;
import com.secondhandcar.core.utils.ToolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.naming.NoPermissionException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by xiet on 2017/10/10.
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController{

    private static String PREFIX = "/system/user/";

    @Resource
    private UserDao userDao;

    @Resource
    private FileUploadConfig fileUploadConfig;

    @Resource
    private FileUploadUtils fileUploadUtils;

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

    /**
     * 跳转到查看用户详情页面
     */
    @RequestMapping("/user_info")
    public String userInfo(Model model) {
        Integer userId = 1;
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        User user = this.userDao.selectById(userId);
        model.addAttribute(user);
        model.addAttribute("roleName", ConstantFactory.me().getRoleName(user.getRoleid()));
        model.addAttribute("deptName", ConstantFactory.me().getDeptName(user.getDeptid()));
//        LogObjectHolder.me().set(user);
        return PREFIX + "user_view.html";
    }

    /**
     * 上传图片(上传到项目的webapp/static/img)
     */
    @PostMapping(path = "/upload")
    @ResponseBody
    public String upload(@RequestPart("file") MultipartFile picture) {
//        String pictureName = UUID.randomUUID().toString() + ".jpg";
//        try {
//            String fileSavePath = fileUploadConfig.getFileUploadPath();
//            log.info("file upload path is {} ", fileSavePath);
//            picture.transferTo(new File(fileSavePath + pictureName));
//        } catch (Exception e) {
//            throw new BussinessException(BizExceptionEnum.UPLOAD_ERROR);
//        }
        System.out.println("文件长度: " + picture.getSize());
        System.out.println("文件类型: " + picture.getContentType());
        System.out.println("文件名称: " + picture.getName());
        System.out.println("文件原名: " + picture.getOriginalFilename());
        String fileName = "";

        try {
            fileName = fileUploadUtils.upload(picture.getInputStream());
        } catch (IOException e) {
            log.error("文件上传失败" + e);
        }


        return fileUploadUtils.getFileUrlPrefix() + fileName;
    }

    public static void main(String[] args) {
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);
        UploadManager uploadManager = new UploadManager(c);
        Auth auth = Auth.create("uUYmEr_7chG8hLbtXp1pJDSJL0qR2Vv772wKqLrj", "NEouGJGzbmgx3_9XJioUZjObqUd_I8vRk8OhbDTg");
        String token = auth.uploadToken("ershouche");
        try {
            Response r = uploadManager.put("hello world".getBytes(), "1234567", token);
            System.out.println(r.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }

    /**
     * 跳转到角色分配页面
     */
    //@RequiresPermissions("/mgr/role_assign")  //利用shiro自带的权限检查
    @RequestMapping("/role_assign/{userId}")
    public String roleAssign(@PathVariable Integer userId, Model model) {
        if (ToolUtil.isEmpty(userId)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        User user = userDao.selectById(userId);
        model.addAttribute("userId", userId);
        model.addAttribute("userAccount", user.getAccount());
        return PREFIX + "user_roleassign.html";
    }

    /**
     * 分配角色
     */
    @RequestMapping("/setRole")
//    @BussinessLog(value = "分配角色", key = "userId,roleIds", dict = UserDict.class)
    @ResponseBody
    public Object setRole(@RequestParam("userId") Integer userId, @RequestParam("roleIds") String roleIds) {
        if (ToolUtil.isOneEmpty(userId, roleIds)) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //不能修改超级管理员
        if (userId.equals(SystemConstants.ADMIN_ID)) {
            throw new BussinessException(BizExceptionEnum.CANT_CHANGE_ADMIN);
        }
        assertAuth(userId);
        userDao.setRoles(userId, roleIds);
        return SUCCESS_TIP;
    }

    /**
     * 判断当前登录的用户是否有操作这个用户的权限
     */
    private void assertAuth(Integer userId) {
        if (ShiroUtils.isAdmin()) {
            return;
        }
        List<Integer> deptDataScope = ShiroUtils.getDeptDataScope();
        User user = this.userDao.selectById(userId);
        Integer deptid = user.getDeptid();
        if (deptDataScope.contains(deptid)) {
            return;
        } else {
            throw new BussinessException(BizExceptionEnum.NO_PERMITION);
        }

    }


}
