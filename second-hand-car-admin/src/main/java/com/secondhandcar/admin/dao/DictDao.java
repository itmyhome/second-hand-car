package com.secondhandcar.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.secondhandcar.admin.model.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
@Mapper
public interface DictDao extends BaseMapper<Dict>{

    /**
     * 根据编码获取词典列表
     *
     * @param code
     * @return
     */
    List<Dict> selectByCode(@Param("code") String code);

    /**
     * 查询字典列表
     * 
     */
    List<Map<String,Object>> list(@Param("condition") String conditiion);
}