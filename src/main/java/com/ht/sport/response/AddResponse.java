package com.ht.sport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class AddResponse extends Response {
    @ApiModelProperty("返回数据")
    private Long data;
    public AddResponse(Long id){
        this.code = 200;
        this.msg = "操作成功！";
        this.data=id;
    }
}
