package com.secondhandcar.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.secondhandcar.admin.common.enums.BizExceptionEnum;
import com.secondhandcar.admin.common.exception.BussinessException;
import com.secondhandcar.admin.dao.DictDao;
import com.secondhandcar.admin.model.Dict;
import com.secondhandcar.admin.service.DictService;
import com.secondhandcar.admin.utils.DictUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xiet on 2017/10/12.
 */
@Service
public class DictServiceImpl implements DictService {

    @Resource
    DictDao dictDao;
    @Override
    public void addDict(String dictName, String dictValues) {
        //判断有没有该字典
        List<Dict> dicts = dictDao.selectList(new EntityWrapper<Dict>().eq("name", dictName).and().eq("pid", 0));
        if (dicts != null && dicts.size() > 0) {
            throw new BussinessException(BizExceptionEnum.DICT_EXISTED);
        }

        //解析dictValues
        List<Map<String, String>> items = DictUtils.parseKeyValue(dictValues);

        //添加字典
        Dict dict = new Dict();
        dict.setName(dictName);
        dict.setNum(0);
        dict.setPid(0);
        this.dictDao.insert(dict);

        //添加字典条目
        for (Map<String, String> item : items) {
            String num = item.get(DictUtils.MUTI_STR_KEY);
            String name = item.get(DictUtils.MUTI_STR_VALUE);
            Dict itemDict = new Dict();
            itemDict.setPid(dict.getId());
            itemDict.setName(name);
            try {
                itemDict.setNum(Integer.valueOf(num));
            } catch (NumberFormatException e) {
                throw new BussinessException(BizExceptionEnum.DICT_MUST_BE_NUMBER);
            }
            this.dictDao.insert(itemDict);
        }
    }

    @Override
    public void editDict(Integer dictId, String dictName, String dicts) {
        //删除之前的字典
        this.delteDict(dictId);

        //重新添加新的字典
        this.addDict(dictName, dicts);
    }

    @Override
    public void delteDict(Integer dictId) {
        //删除这个字典的子词典
        Wrapper<Dict> dictEntityWrapper = new EntityWrapper<>();
        dictEntityWrapper = dictEntityWrapper.eq("pid", dictId);
        dictDao.delete(dictEntityWrapper);

        //删除这个词典
        dictDao.deleteById(dictId);
    }
}
