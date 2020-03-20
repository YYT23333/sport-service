package com.hs.sport.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WrongResponse extends Response {
    @ApiModelProperty("错误码")
    private int infoCode;
    @ApiModelProperty("错误描述")
    private String description;

    public WrongResponse(int infoCode, String description) {
        this.infoCode = infoCode;
        this.description = description;
    }

}
