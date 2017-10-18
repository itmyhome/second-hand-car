package com.secondhandcar.platform.service.impl;

import com.secondhandcar.platform.dao.SecondHandCarDetailDao;
import com.secondhandcar.platform.dao.SecondHandCarEvaluateItemsDao;
import com.secondhandcar.platform.dao.SecondHandCarHighlightConfigItemDao;
import com.secondhandcar.platform.model.SecondHandCarDetail;
import com.secondhandcar.platform.model.SecondHandCarEvaluateItems;
import com.secondhandcar.platform.model.SecondHandCarHighlightConfigItem;
import com.secondhandcar.platform.service.SecondHandCarDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiet on 2017/10/17.
 */
@Service
public class SecondHandCarDetailServiceImpl implements SecondHandCarDetailService {

    @Resource
    private SecondHandCarDetailDao secondHandCarDetailDao;
    @Resource
    private SecondHandCarEvaluateItemsDao secondHandCarEvaluateItemsDao;
    @Resource
    private SecondHandCarHighlightConfigItemDao secondHandCarHighlightConfigItemDao;
    @Override
    public void add(SecondHandCarDetail secondHandCarDetail) {

    }

    @Override
    public void update(SecondHandCarDetail secondHandCarDetail) {

    }

    @Override
    public void addOrEditSecondHandCarEvaluateItems(SecondHandCarEvaluateItems secondHandCarEvaluateItems) {
        secondHandCarEvaluateItemsDao.insert(secondHandCarEvaluateItems);
    }

    @Override
    public void addOrEditSecondHandCarHighlightConfigItem(SecondHandCarHighlightConfigItem secondHandCarHighlightConfigItem) {
        secondHandCarHighlightConfigItemDao.insert(secondHandCarHighlightConfigItem);
    }
}
