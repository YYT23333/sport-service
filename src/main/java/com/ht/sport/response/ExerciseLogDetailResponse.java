package com.ht.sport.response;


import com.ht.sport.entity.ExerciseLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ExerciseLogDetailResponse extends Response {
    @ApiModelProperty("返回数据")
    private ExerciseLogItem data;

    public ExerciseLogDetailResponse(ExerciseLog exerciseLog){
        this.code = 200;
        this.msg = "操作成功！";
        this.data=new ExerciseLogItem(exerciseLog);
    }

    public ExerciseLogDetailResponse(ExerciseLogItem exerciseLogItem){
        this.code = 200;
        this.msg = "操作成功！";
        this.data=exerciseLogItem;
    }
}
