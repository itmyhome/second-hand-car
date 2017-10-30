package com.secondhandcar.platform.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Maps;
import com.secondhandcar.admin.utils.DictUtils;
import com.secondhandcar.platform.dao.SecondHandCarDetailDao;
import com.secondhandcar.platform.dao.SecondHandCarEvaluateItemsDao;
import com.secondhandcar.platform.dao.SecondHandCarHighlightConfigItemDao;
import com.secondhandcar.platform.model.SecondHandCarDetail;
import com.secondhandcar.platform.model.SecondHandCarEvaluateItem;
import com.secondhandcar.platform.model.SecondHandCarHighlightConfigItem;
import com.secondhandcar.platform.service.SecondHandCarDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xiet on 2017/10/17.
 */
@Service
@Slf4j
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
    @Transactional(rollbackFor = RuntimeException.class)
    public void update(SecondHandCarDetail secondHandCarDetail) {
        if (secondHandCarDetail.getId() == null) {
            secondHandCarDetailDao.insert(secondHandCarDetail);
        } else {
            //不为空才去删除
            secondHandCarDetailDao.updateById(secondHandCarDetail);
            String carId = secondHandCarDetail.getCarId();
            deleteEvaluateItemsByCarId(carId);
            deleteHighlightConfigItem(carId);
        }
        insertSecondHandCarEvaluatrItems(secondHandCarDetail);
        insertSecondHandCarHighlightConfigItem(secondHandCarDetail);
    }

    private void insertSecondHandCarEvaluatrItems(SecondHandCarDetail secondHandCarDetail) {
        List<Map<String, String>> items = DictUtils.parseKeyValueForThree(secondHandCarDetail.getEvaluateItem());


        for (Map<String, String> item : items) {
            String title = item.get(DictUtils.MUTI_STR_KEY);
            String count = item.get(DictUtils.MUTI_STR_VALUE);
            String faile = item.get(DictUtils.MUTI_STR_THREE);
            SecondHandCarEvaluateItem secondHandCarEvaluateItem = new SecondHandCarEvaluateItem();

            secondHandCarEvaluateItem.setCarId(secondHandCarDetail.getCarId());
            secondHandCarEvaluateItem.setTitle(title);
            secondHandCarEvaluateItem.setCount(Integer.parseInt(count));
            secondHandCarEvaluateItem.setFaile(Integer.parseInt(faile));
            this.addOrEditSecondHandCarEvaluateItems(secondHandCarEvaluateItem);
        }
    }

    private void insertSecondHandCarHighlightConfigItem(SecondHandCarDetail secondHandCarDetail) {
        List<Map<String, String>> items = DictUtils.parseKeyValueForImage(secondHandCarDetail.getHighlightConfigItem());


        for (Map<String, String> item : items) {
            String title = item.get(DictUtils.MUTI_STR_KEY);
            String image = item.get("image");
            String isAdd = item.get(DictUtils.MUTI_STR_THREE);
            SecondHandCarHighlightConfigItem secondHandCarHighlightConfigItem = new SecondHandCarHighlightConfigItem();

            secondHandCarHighlightConfigItem.setCarId(secondHandCarDetail.getCarId());
            secondHandCarHighlightConfigItem.setTitle(title);
            secondHandCarHighlightConfigItem.setImage(image);
            secondHandCarHighlightConfigItem.setAdd(isAdd.equals("1") ? true : false);
            this.addOrEditSecondHandCarHighlightConfigItem(secondHandCarHighlightConfigItem);
        }
    }

    @Override
    public SecondHandCarDetail selectByCarId(String carId) {
        SecondHandCarDetail secondHandCarDetail = new SecondHandCarDetail();
        secondHandCarDetail.setCarId(carId);
        return secondHandCarDetailDao.selectOne(secondHandCarDetail);
    }

    @Override
    public void addOrEditSecondHandCarEvaluateItems(SecondHandCarEvaluateItem secondHandCarEvaluateItems) {
        secondHandCarEvaluateItemsDao.insert(secondHandCarEvaluateItems);
    }

    @Override
    public void deleteEvaluateItemsByCarId(String carId) {
        Map<String, Object> columnMap = Maps.newHashMap();
        columnMap.put("car_id", carId);
        Integer count = secondHandCarEvaluateItemsDao.deleteByMap(columnMap);
        log.info("删除详细检测配置记录数为{}", count);
    }

    @Override
    public void addOrEditSecondHandCarHighlightConfigItem(SecondHandCarHighlightConfigItem secondHandCarHighlightConfigItem) {
        secondHandCarHighlightConfigItemDao.insert(secondHandCarHighlightConfigItem);
    }

    @Override
    public void deleteHighlightConfigItem(String carId) {
        Map<String, Object> columnMap = Maps.newHashMap();
        columnMap.put("car_id", carId);
        Integer count = secondHandCarHighlightConfigItemDao.deleteByMap(columnMap);
        log.info("删除高配属性记录数为{}", count);

    }

    @Override
    public List<SecondHandCarEvaluateItem> selectEvaluateItemListByCarId(String secondHandCarId) {
        return secondHandCarEvaluateItemsDao.selectList(new EntityWrapper<SecondHandCarEvaluateItem>().eq("car_id", secondHandCarId));
    }

    @Override
    public List<SecondHandCarHighlightConfigItem> selectHighlightConfigItemListByCarId(String secondHandCarId) {
        return secondHandCarHighlightConfigItemDao.selectList(new EntityWrapper<SecondHandCarHighlightConfigItem>().eq("car_id", secondHandCarId));
    }
}
