package com.ht.sport.parameters;

import com.ht.sport.enums.ExerciseLogType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ExerciseLogParameter {
    @ApiModelProperty("用户id")
    private long userId;

    @ApiModelProperty("课程id(type==COURSE时才有)")
    private long courseId;

    @ApiModelProperty("运动类型")
    private ExerciseLogType type;

    @ApiModelProperty("耗时(type!=COURSE时才有)")
    private double timeConsuming;

    @ApiModelProperty("运动距离(typze!=COURSE时才有)")
    private double distance;

    @ApiModelProperty("运动速度(type!=COURSE时才有)")
    private double speed;

    @ApiModelProperty("消耗卡路里(type!=COURSE时才有)")
    private double calories;
}
