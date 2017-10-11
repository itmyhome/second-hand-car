package com.secondhandcar.admin.warpper;

import com.secondhandcar.admin.common.factory.ConstantFactory;
import com.secondhandcar.core.warpper.BaseControllerWarpper;

import java.util.List;
import java.util.Map;

public class RoleWarpper extends BaseControllerWarpper {

    public RoleWarpper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("pName", ConstantFactory.me().getSingleRoleName((Integer) map.get("pid")));
        map.put("deptName", ConstantFactory.me().getDeptName((Integer) map.get("deptid")));
    }

}