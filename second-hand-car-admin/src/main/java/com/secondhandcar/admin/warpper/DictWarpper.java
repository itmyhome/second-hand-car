package com.secondhandcar.admin.warpper;

import com.secondhandcar.admin.common.factory.ConstantFactory;
import com.secondhandcar.admin.model.Dict;
import com.secondhandcar.core.utils.ToolUtil;
import com.secondhandcar.core.warpper.BaseControllerWarpper;

import java.util.List;
import java.util.Map;

public class DictWarpper extends BaseControllerWarpper {

    public DictWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        StringBuffer detail = new StringBuffer();
        Integer id = (Integer) map.get("id");
        List<Dict> dicts = ConstantFactory.me().findInDict(id);
        if(dicts != null){
            for (Dict dict : dicts) {
                detail.append(dict.getNum() + ":" +dict.getName() + ",");
            }
            map.put("detail", ToolUtil.removeSuffix(detail.toString(),","));
        }
    }

}