package com.secondhandcar.admin.controller;

import com.secondhandcar.admin.dao.DeptDao;
import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.core.node.ZTreeNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiet on 2017/10/10.
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController{
    private String PREFIX = "/system/dept/";


    @Resource
    private DeptDao deptDao;
    /**
     * 获取部门的tree列表
     */
    @RequestMapping(value = "/tree")
    @ResponseBody
    public List<ZTreeNode> tree() {
        List<ZTreeNode> tree = deptDao.tree();
        tree.add(ZTreeNode.createParent());
        return tree;
    }
}
