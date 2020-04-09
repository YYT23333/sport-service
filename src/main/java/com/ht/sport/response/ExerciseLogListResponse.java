package com.ht.sport.response;

import com.ht.sport.entity.ExerciseLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel
public class ExerciseLogListResponse extends Response{
    @ApiModelProperty("返回数据")
    private List<ExerciseLogItem> data;

    public ExerciseLogListResponse(List<ExerciseLog> exerciseLogs){
        this.code = 200;
        this.msg = "操作成功！";
        this.data=new ArrayList<>();
        for (ExerciseLog log:exerciseLogs) {
            ((ArrayList) this.data).add(new ExerciseLogItem(log));
        }
    }
}
