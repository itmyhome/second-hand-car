package com.secondhandcar.admin.service;

/**
 * Created by xiet on 2017/10/12.
 */
public interface DictService {
    /**
     * 添加字典
     *
     */
    void addDict(String dictName, String dictValues);

    /**
     * 编辑字典
     *
     */
    void editDict(Integer dictId, String dictName, String dicts);

    /**
     * 删除字典
     *
     */
    void delteDict(Integer dictId);
}
