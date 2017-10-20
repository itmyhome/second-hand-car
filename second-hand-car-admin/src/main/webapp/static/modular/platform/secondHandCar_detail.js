/**
 * Created by xiet on 2017/10/18.
 */
/**
 * 初始化二手车详情对话框
 */
var SecondHandCarInfoDlg = {
    evaluateItemCount: $("#evaluateItemSize").val(),
    highLightConfigItemCount: $("#highLightConfigItemSize").val(),
    thumbImgCount: $("#thumbSize").val(),
    secondHandCarInfoData: {},
    itemTemplate: $("#evaluateItem").html(),
    highLightConfigItem: $("#highLightConfigItem").html()
};

/**
 * item获取新的id
 */
SecondHandCarInfoDlg.newEvaluateItemId = function () {
    if(this.evaluateItemCount == undefined){
        this.evaluateItemCount = 0;
    }
    this.evaluateItemCount = this.evaluateItemCount + 1;
    return "secondHandCarEvaluateItem" + this.evaluateItemCount;
};

SecondHandCarInfoDlg.newHighLightConfigItemId = function () {
    if(this.highLightConfigItemCount == undefined){
        this.highLightConfigItemCount = 0;
    }
    this.highLightConfigItemCount = this.highLightConfigItemCount + 1;
    return "secondHandCarHighLightConfigItem" + this.highLightConfigItemCount;
}

SecondHandCarInfoDlg.newThumbImgId = function () {
    if(this.thumbImgCount == undefined){
        this.thumbImgCount = 0;
    }
    this.thumbImgCount = this.thumbImgCount + 1;
    return "image" + this.thumbImgCount;
}



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
 * 添加详细检测条目
 */
SecondHandCarInfoDlg.addSecondHandCarEvaluateItems = function () {
    $("#itemsArea").append(this.itemTemplate);
    $("#secondHandCarEvaluateItems").attr("id", this.newEvaluateItemId());
};

/**
 * 添加高亮配置条目
 */
SecondHandCarInfoDlg.addSecondHandCarHighlightConfigItem = function () {
    $("#driverInfoContent").append(this.highLightConfigItem);
    $("#secondHandCarHighlightConfigItem").attr("id", this.newHighLightConfigItemId());

    var thumbImgStr = this.newThumbImgId();

    $("#imageBtnId").attr("id", thumbImgStr + "BtnId");
    $("#imagePreId").attr("id", thumbImgStr + "PreId");
    $("#image").attr("id", thumbImgStr);
    var avatarUp = new $WebUpload(thumbImgStr);
    avatarUp.setUploadBarId("progressBar");
    avatarUp.init();
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
    $("[name='secondHandCarEvaluateItem']").each(function(){
        var title = $(this).find("[name='title']").val();
        var count = $(this).find("[name='count']").val();
        var faile = $(this).find("[name='faile']").val();
        if(title == '' || count == '' || faile == ''){
            $(this).remove();
        }
    });
    $("[name='secondHandCarHighlightConfigItem']").each(function(){
        var title = $(this).find("[name='title']").val();
        var image = $(this).find("[name='image']").val();
        var isAdd = $(this).find("[name='isAdd']").val();
        if(title == '' || image == '' || isAdd == ''){
            $(this).remove();
        }
    });
};

/**
 * 收集数据
 */
SecondHandCarInfoDlg.collectData = function () {
    this.clearNullDom();

    this.set('id').set('carId').set('airDisplacement').set('gearbox').set('seller').set('sellerJob')
        .set('transferNum').set('cardCity').set('districtName').set('sellerDescription')
        .set('auditDate').set('strongInsuranceDate').set('insuranceDate').set('dealPrice')
        .set('newPrice').set('useDate').set('followNum').set('emissionStandard')
        .set('emissionStandardDesc').set('emissionStandardsUrl').set('hegeIcon').set('evaluatorDesc').set('phone');

    var evaluateItem = "";
    $("[name='secondHandCarEvaluateItem']").each(function(){
        var title = $(this).find("[name='title']").val();
        var count = $(this).find("[name='count']").val();
        var faile = $(this).find("[name='faile']").val();
        evaluateItem = evaluateItem + (title + ":" + count + ":" + faile + ";");
    });

    this.set('evaluateItem', evaluateItem);

    var highlightConfigItem = "";
    $("[name='secondHandCarHighlightConfigItem']").each(function(){
        var title = $(this).find("[name='title']").val();
        var image = $(this).find("input[id^='image']").val();
        var isAdd = $(this).find("[name='isAdd']").val();
        highlightConfigItem = highlightConfigItem + (title + ":" + image + ":" + isAdd + ";");
    });

    this.set('highlightConfigItem', highlightConfigItem);

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

    console.info(this.secondHandCarInfoData)

    //提交信息
    var ajax = new $ax(SecondHandCarAdmin.ctxPath + "/secondHandCarDetail/update", function (data) {
        SecondHandCarAdmin.success("修改成功!");
        // window.parent.SecondHandCar.table.refresh();
        SecondHandCarInfoDlg.close();
    }, function (data) {
        SecondHandCarAdmin.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.secondHandCarInfoData);
    ajax.start();
}

$(function () {
    // 初始化头像上传
    // var avatarUp = new $WebUpload("thumbImg");
    // avatarUp.setUploadBarId("progressBar");
    // avatarUp.init();
});

