package com.secondhandcar.api.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.secondhandcar.api.dto.SecondHandCarDetailResponseDTO;
import com.secondhandcar.api.model.SecondHandCarDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xiet on 2017/10/17.
 */
@Mapper
public interface SecondHandCarDetailDao extends BaseMapper<SecondHandCarDetail> {
    /**
     *
     * @param carId
     * @return
     */
    SecondHandCarDetailResponseDTO findSecondHandCarDetail(String carId);
}
