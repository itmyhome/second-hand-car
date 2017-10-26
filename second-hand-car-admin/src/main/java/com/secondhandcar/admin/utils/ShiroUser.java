package com.secondhandcar.admin.utils;

import lombok.Data;

import java.util.List;

/**
 * Created by xiet on 2017/10/10.
 */
@Data
public class ShiroUser {
    private static final long serialVersionUID = 1L;

    public Integer id;          // 主键ID
    public String account;      // 账号
    public String name;         // 姓名
    public Integer deptId;      // 部门id
    public List<Integer> roleList; // 角色集
    public String deptName;        // 部门名称
    public List<String> roleNames; // 角色名称集
}
