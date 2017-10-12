package com.secondhandcar.admin.warpper;

import com.secondhandcar.admin.common.factory.ConstantFactory;
import com.secondhandcar.core.utils.ToolUtil;
import com.secondhandcar.core.warpper.BaseControllerWarpper;

import java.util.Map;

public class DeptWarpper extends BaseControllerWarpper {

    public DeptWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {

        Integer pid = (Integer) map.get("pid");

        if (ToolUtil.isEmpty(pid) || pid.equals(0)) {
            map.put("pName", "--");
        } else {
            map.put("pName", ConstantFactory.me().getDeptName(pid));
        }
    }

}