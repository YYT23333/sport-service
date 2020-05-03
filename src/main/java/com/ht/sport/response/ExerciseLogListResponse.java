package com.ht.sport.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class ExerciseLogListResponse extends Response{
    @ApiModelProperty("返回数据")
    private List<ExerciseLogItem> data;

    public ExerciseLogListResponse(List<ExerciseLogItem> exerciseLogItems){
        this.code = 200;
        this.msg = "操作成功！";
        this.data=exerciseLogItems;
    }
}
