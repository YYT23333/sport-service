package com.ht.sport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class RankListResponse extends Response {
    @ApiModelProperty("返回数据")
    private List<RankItem> data;

    public RankListResponse(List<RankItem> items) {
        this.code = 200;
        this.msg = "操作成功！";
        this.data=items;
    }
    public RankListResponse(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
