package com.secondhandcar.api.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.secondhandcar.api.model.SecondHandCar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SecondHandCarDao extends BaseMapper<SecondHandCar>{
    /**
     * 二手车列表
     * @return
     */
    public List<SecondHandCar> findSecondHandCarList();
}
