package com.ht.sport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel
public class Response implements Serializable {
    @ApiModelProperty("code")
    public int code;
    @ApiModelProperty("code详情")
    public String msg;
}
