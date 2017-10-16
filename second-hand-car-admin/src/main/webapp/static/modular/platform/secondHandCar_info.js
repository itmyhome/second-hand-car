/**
 * 初始化二手车详情对话框
 */
var SecondHandCarInfoDlg = {
    count: $("#itemSize").val(),
    secondHandCarInfoData: {},
    itemTemplate: $("#itemTemplate").html()
};

/**
 * item获取新的id
 */
SecondHandCarInfoDlg.newId = function () {
    if(this.count == undefined){
        this.count = 0;
    }
    this.count = this.count + 1;
    return "secondHandCarHotParam" + this.count;
};

/**
 * 清除数据
 */
SecondHandCarInfoDlg.clearData = function () {
    this.secondHandCarInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SecondHandCarInfoDlg.set = function (key, val) {
    this.secondHandCarInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SecondHandCarInfoDlg.get = function (key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SecondHandCarInfoDlg.close = function () {
    parent.layer.close(window.parent.SecondHandCar.layerIndex);
}

/**
 * 添加条目
 */
SecondHandCarInfoDlg.addItem = function () {
    $("#itemsArea").append(this.itemTemplate);
    $("#secondHandCarHotParam").attr("id", this.newId());
};

/**
 * 删除item
 */
SecondHandCarInfoDlg.deleteItem = function (event) {
    var obj = SecondHandCarAdmin.eventParseObject(event);
    obj.parent().parent().remove();
};

/**
 * 清除为空的item Dom
 */
SecondHandCarInfoDlg.clearNullDom = function(){
    $("[name='secondHandCarHotParam']").each(function(){
        var text = $(this).find("[name='text']").val();
        var color = $(this).find("[name='color']").val();
        if(text == '' || color == ''){
            $(this).remove();
        }
    });
};

/**
 * 收集数据
 */
SecondHandCarInfoDlg.collectData = function () {
    this.clearNullDom();

    this.set('id').set('carId').set('title').set('licenseDate').set('roadHaul').set('price')
        .set('firstPay').set('newPost').set('orderNo').set('thumbImg');

    var multiString = "";
    $("[name='secondHandCarHotParam']").each(function(){
        var text = $(this).find("[name='text']").val();
        var color = $(this).find("[name='color']").val();
        multiString = multiString + (text + ":" + color + ";");
    });

    this.set('secondHandCarHotParamStr', multiString);

}

/**
 * 提交添加
 */
SecondHandCarInfoDlg.addSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(SecondHandCarAdmin.ctxPath + "/secondHandCar/add", function (data) {
        SecondHandCarAdmin.success("添加成功!");
        window.parent.SecondHandCar.table.refresh();
        SecondHandCarInfoDlg.close();
    }, function (data) {
        SecondHandCarAdmin.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.secondHandCarInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SecondHandCarInfoDlg.editSubmit = function () {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(SecondHandCarAdmin.ctxPath + "/secondHandCar/update", function (data) {
        SecondHandCarAdmin.success("修改成功!");
        window.parent.SecondHandCar.table.refresh();
        SecondHandCarInfoDlg.close();
    }, function (data) {
        SecondHandCarAdmin.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.secondHandCarInfoData);
    ajax.start();
}

$(function () {
    // 初始化头像上传
    var avatarUp = new $WebUpload("thumbImg");
    avatarUp.setUploadBarId("progressBar");
    avatarUp.init();
});
