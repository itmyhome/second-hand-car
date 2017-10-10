package com.secondhandcar.admin.dao;

import com.secondhandcar.core.node.ZTreeNode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xiet on 2017/10/10.
 */
@Mapper
public interface DeptDao {

    @Select("select id,pid as pId,simplename as name,\n" +
            "\t\t(\n" +
            "\t\tCASE\n" +
            "\t\tWHEN (pId = 0 OR pId IS NULL) THEN\n" +
            "\t\t\t'true'\n" +
            "\t\tELSE\n" +
            "\t\t\t'false'\n" +
            "\t\tEND\n" +
            "\t\t) as isOpen from dept")
    List<ZTreeNode> tree();
}
