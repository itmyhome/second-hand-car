package com.secondhandcar.platform.service;

import com.secondhandcar.platform.model.SecondHandCarHotParam;

/**
 * Created by xiet on 2017/10/14.
 */
public interface SecondHandCarHotParamService {

    void add(SecondHandCarHotParam secondHandCarHotParam);

    void update(SecondHandCarHotParam secondHandCarHotParam);

    void delete(Integer secondHandCarHotParamId);

}
