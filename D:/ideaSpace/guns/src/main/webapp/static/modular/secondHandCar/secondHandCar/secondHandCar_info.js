/**
 * 初始化二手车详情对话框
 */
var SecondHandCarInfoDlg = {
    secondHandCarInfoData : {}
};

/**
 * 清除数据
 */
SecondHandCarInfoDlg.clearData = function() {
    this.secondHandCarInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SecondHandCarInfoDlg.set = function(key, val) {
    this.secondHandCarInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SecondHandCarInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SecondHandCarInfoDlg.close = function() {
    parent.layer.close(window.parent.SecondHandCar.layerIndex);
}

/**
 * 收集数据
 */
SecondHandCarInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
SecondHandCarInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/secondHandCar/add", function(data){
        Feng.success("添加成功!");
        window.parent.SecondHandCar.table.refresh();
        SecondHandCarInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.secondHandCarInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SecondHandCarInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/secondHandCar/update", function(data){
        Feng.success("修改成功!");
        window.parent.SecondHandCar.table.refresh();
        SecondHandCarInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.secondHandCarInfoData);
    ajax.start();
}

$(function() {

});
