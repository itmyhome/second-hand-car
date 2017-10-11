package com.secondhandcar.admin.dto;

import java.util.List;

/**
 * Created by xiet on 2017/10/10.
 */
public class UserQueryDto {

    /**
     * 限制范围的字段名称
     */
    private String scopeName = "deptid";

    /**
     * 具体的数据范围
     */
    private List<Integer> deptIds;

    public UserQueryDto() {
    }

    public UserQueryDto(List<Integer> deptIds) {
        this.deptIds = deptIds;
    }

    public UserQueryDto(String scopeName, List<Integer> deptIds) {
        this.scopeName = scopeName;
        this.deptIds = deptIds;
    }

    public List<Integer> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<Integer> deptIds) {
        this.deptIds = deptIds;
    }

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }
}
