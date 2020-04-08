package com.ht.sport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class RankItem {
    @ApiModelProperty("用户id")
    private long userId;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("用户头像")
    private String imgUrl;
    @ApiModelProperty("总时长")
    private double totalTime;

}
