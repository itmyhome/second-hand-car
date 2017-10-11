package com.secondhandcar.admin.warpper;

import com.secondhandcar.admin.common.factory.ConstantFactory;
import com.secondhandcar.core.enums.IsMenu;
import com.secondhandcar.core.warpper.BaseControllerWarpper;

import java.util.List;
import java.util.Map;

public class MenuWarpper extends BaseControllerWarpper {

    public MenuWarpper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("statusName", ConstantFactory.me().getMenuStatusName((Integer) map.get("status")));
        map.put("isMenuName", IsMenu.valueOf((Integer) map.get("ismenu")));
    }

}