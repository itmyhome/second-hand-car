package com.secondhandcar.admin.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiet on 2017/10/11.
 */
@Data
public class Relation extends Model<Relation> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    /**
     * 菜单id
     */
    private Integer menuid;
    /**
     * 角色id
     */
    private Integer roleid;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
