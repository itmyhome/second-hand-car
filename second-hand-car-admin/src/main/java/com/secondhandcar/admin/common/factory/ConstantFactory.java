package com.secondhandcar.admin.common.factory;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.secondhandcar.admin.dao.*;
import com.secondhandcar.admin.model.*;
import com.secondhandcar.admin.utils.SpringContextHolder;
import com.secondhandcar.core.utils.ConvertUtils;
import com.secondhandcar.core.utils.StringUtils;
import com.secondhandcar.core.utils.ToolUtil;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@DependsOn("springContextHolder")
public class ConstantFactory implements IConstantFactory {

    private RoleDao roleDao = SpringContextHolder.getBean(RoleDao.class);
    private DeptDao deptDao = SpringContextHolder.getBean(DeptDao.class);
    private DictDao dictDao = SpringContextHolder.getBean(DictDao.class);
    private UserDao userDao = SpringContextHolder.getBean(UserDao.class);
    private MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);

    public static IConstantFactory me() {
        return SpringContextHolder.getBean("constantFactory");
    }

    /**
     * 根据用户id获取用户名称
     *
     */
    @Override
    public String getUserNameById(Integer userId) {
        User user = userDao.selectById(userId);
        if (user != null) {
            return user.getName();
        } else {
            return "--";
        }
    }

    /**
     * 根据用户id获取用户账号
     *
     * @author stylefeng
     * @date 2017年5月16日21:55:371
     */
    @Override
    public String getUserAccountById(Integer userId) {
        User user = userDao.selectById(userId);
        if (user != null) {
            return user.getAccount();
        } else {
            return "--";
        }
    }

    /**
     * 通过角色ids获取角色名称
     */
    @Override
    public String getRoleName(String roleIds) {
        Integer[] roles = ConvertUtils.toIntArray(roleIds);
        StringBuilder sb = new StringBuilder();
        for (int role : roles) {
            Role roleObj = roleDao.selectById(role);
            if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
                sb.append(roleObj.getName()).append(",");
            }
        }
        return StringUtils.removeSuffix(sb.toString(), ",");
    }

    @Override
    public String getSingleRoleName(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = roleDao.selectById(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getName();
        }
        return "";
    }

    @Override
    public String getSingleRoleTip(Integer roleId) {
        if (0 == roleId) {
            return "--";
        }
        Role roleObj = roleDao.selectById(roleId);
        if (ToolUtil.isNotEmpty(roleObj) && ToolUtil.isNotEmpty(roleObj.getName())) {
            return roleObj.getTips();
        }
        return "";
    }


    /**
     * 获取部门名称
     */
    @Override
    public String getDeptName(Integer deptId) {
        Dept dept = deptDao.selectById(deptId);
        if (ToolUtil.isNotEmpty(dept) && ToolUtil.isNotEmpty(dept.getFullname())) {
            return dept.getFullname();
        }
        return "";
    }

    @Override
    public String getMenuNames(String menuIds) {
        return null;
    }

    @Override
    public String getMenuName(Integer menuId) {
        return null;
    }

    @Override
    public String getMenuNameByCode(String code) {
        if (ToolUtil.isEmpty(code)) {
            return "";
        } else {
            Menu param = new Menu();
            param.setCode(code);
            Menu menu = menuDao.selectOne(param);
            if (menu == null) {
                return "";
            } else {
                return menu.getName();
            }
        }
    }

    @Override
    public String getDictName(Integer dictId) {
        return null;
    }

    @Override
    public String getNoticeTitle(Integer dictId) {
        return null;
    }

    @Override
    public String getDictsByName(String name, Integer val) {
        return null;
    }

    @Override
    public String getSexName(Integer sex) {
        return null;
    }

    @Override
    public String getStatusName(Integer status) {
        return null;
    }

    @Override
    public String getMenuStatusName(Integer status) {
        return null;
    }

    @Override
    public List<Dict> findInDict(Integer id) {
        if (ToolUtil.isEmpty(id)) {
            return null;
        } else {
            EntityWrapper<Dict> wrapper = new EntityWrapper<>();
            List<Dict> dicts = dictDao.selectList(wrapper.eq("pid", id));
            if (dicts == null || dicts.size() == 0) {
                return null;
            } else {
                return dicts;
            }
        }
    }

    @Override
    public String getCacheObject(String para) {
        return null;
    }

    @Override
    public List<Integer> getSubDeptId(Integer deptid) {
        return null;
    }

    @Override
    public List<Integer> getParentDeptIds(Integer deptid) {
        return null;
    }
}