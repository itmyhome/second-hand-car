package com.secondhandcar.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.secondhandcar.admin.model.Dept;
import com.secondhandcar.core.node.ZTreeNode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by xiet on 2017/10/10.
 */
@Mapper
public interface DeptDao extends BaseMapper<Dept> {


    List<ZTreeNode> tree();

    List<Map<String, Object>> list(@Param("condition") String condition);
}
