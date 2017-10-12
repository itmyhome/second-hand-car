package com.secondhandcar.admin.controller;

import com.secondhandcar.admin.common.enums.BizExceptionEnum;
import com.secondhandcar.admin.common.exception.BussinessException;
import com.secondhandcar.admin.common.factory.ConstantFactory;
import com.secondhandcar.admin.dao.DeptDao;
import com.secondhandcar.admin.model.Dept;
import com.secondhandcar.admin.service.DeptService;
import com.secondhandcar.admin.warpper.DeptWarpper;
import com.secondhandcar.core.controller.BaseController;
import com.secondhandcar.core.node.ZTreeNode;
import com.secondhandcar.core.utils.ToolUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xiet on 2017/10/10.
 */
@Controller
@RequestMapping("/dept")
public class DeptController extends BaseController{
    private String PREFIX = "/system/dept/";


    @Resource
    private DeptDao deptDao;

    @Resource
    private DeptService deptService;

    /**
     * 跳转到部门管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "dept.html";
    }

    /**
     * 跳转到添加部门
     */
    @RequestMapping("/dept_add")
    public String deptAdd() {
        return PREFIX + "dept_add.html";
    }

    /**
     * 跳转到修改部门
     */
    @RequestMapping("/dept_update/{deptId}")
    public String deptUpdate(@PathVariable Integer deptId, Model model) {
        Dept dept = deptDao.selectById(deptId);
        model.addAttribute(dept);
        model.addAttribute("pName", ConstantFactory.me().getDeptName(dept.getPid()));
//        LogObjectHolder.me().set(dept);
        return PREFIX + "dept_edit.html";
    }
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

    /**
     * 新增部门
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Dept dept) {
        if (ToolUtil.isOneEmpty(dept, dept.getSimplename())) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        //完善pids,根据pid拿到pid的pids
        deptSetPids(dept);
        return deptDao.insert(dept);
    }

    /**
     * 获取所有部门列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list = this.deptDao.list(condition);
        return super.warpObject(new DeptWarpper(list));
    }

    /**
     * 部门详情
     */
    @RequestMapping(value = "/detail/{deptId}")
    @ResponseBody
    public Object detail(@PathVariable("deptId") Integer deptId) {
        return deptDao.selectById(deptId);
    }

    /**
     * 修改部门
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Dept dept) {
        if (ToolUtil.isEmpty(dept) || dept.getId() == null) {
            throw new BussinessException(BizExceptionEnum.REQUEST_NULL);
        }
        deptSetPids(dept);
        deptDao.updateById(dept);
        return super.SUCCESS_TIP;
    }

    /**
     * 删除部门
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer deptId) {

        //缓存被删除的部门名称
//        LogObjectHolder.me().set(ConstantFactory.me().getDeptName(deptId));

        deptService.deleteDept(deptId);

        return SUCCESS_TIP;
    }

    private void deptSetPids(Dept dept) {
        if (ToolUtil.isEmpty(dept.getPid()) || dept.getPid().equals(0)) {
            dept.setPid(0);
            dept.setPids("[0],");
        } else {
            int pid = dept.getPid();
            Dept temp = deptDao.selectById(pid);
            String pids = temp.getPids();
            dept.setPid(pid);
            dept.setPids(pids + "[" + pid + "],");
        }
    }
}
