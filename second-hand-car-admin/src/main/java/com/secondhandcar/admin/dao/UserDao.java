package com.secondhandcar.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.secondhandcar.admin.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by xiet on 2017/10/10.
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 修改用户状态
     *
     * @param user
     */
    int setStatus(@Param("userId") Integer userId, @Param("status") int status);

    /**
     * 修改密码
     *
     * @param userId
     * @param pwd
     */
    int changePwd(@Param("userId") Integer userId, @Param("pwd") String pwd);

    /**
     * 根据条件查询用户列表
     *
     * @return
     */
//    List<Map<String, Object>> selectUsers(@Param("dataScope") DataScope dataScope, @Param("name") String name, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("deptid") Integer deptid);

    /**
     * 设置用户的角色
     *
     * @return
     */
    int setRoles(@Param("userId") Integer userId, @Param("roleIds") String roleIds);

    /**
     * 通过账号获取用户
     *
     * @param account
     * @return
     */
    @Select("select\n" +
            "\t\tid, account, name, birthday,password, sex, email, avatar,\n" +
            "\t\tphone, roleid,salt,\n" +
            "\t\tdeptid, status,\n" +
            "\t\tcreatetime, version\n" +
            "\t\tfrom user where account = #{account} and status != 3")
    User getByAccount(@Param("account") String account);
}
