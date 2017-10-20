<div class="form-group">
    <label class="col-sm-3 control-label head-scu-label">${name}</label>
    <div class="col-sm-4">
        <div id="${id}PreId">
            <div><img width="100px" height="100px"
                      @if(isEmpty(thumbImg)){
                      src="${ctxPath}/static/img/girl.gif"></div>
            @}else{
            src="${thumbImg}">
        </div>
        @}
    </div>
</div>