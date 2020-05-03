package com.ht.sport.parameters;

import com.ht.sport.enums.ExerciseLogType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class ExerciseLogParameter {
    @ApiModelProperty("用户id")
    private long userId;

    @ApiModelProperty("课程id(type==COURSE时才有)")
    private int courseId;

    @ApiModelProperty("运动类型")
    private ExerciseLogType type;

    @ApiModelProperty("耗时")
    private double timeConsuming;

    @ApiModelProperty("消耗卡路里")
    private double calories;

    @ApiModelProperty("运动距离(type!=COURSE时才有)")
    private double distance;

    @ApiModelProperty("运动速度(type!=COURSE时才有)")
    private double speed;

    @ApiModelProperty("经度列表(type!=COURSE时才有)")
    private List<Double> longitudes;

    @ApiModelProperty("纬度列表(type!=COURSE时才有)")
    private List<Double> latitudes;
}
