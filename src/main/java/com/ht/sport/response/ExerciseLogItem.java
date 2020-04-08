package com.ht.sport.response;

import com.ht.sport.entity.ExerciseLog;
import com.ht.sport.enums.ExerciseLogType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel
public class ExerciseLogItem {
    @ApiModelProperty("运动记录Id")
    private long id;

    @ApiModelProperty("课程id(type==COURSE时才有)")
    private long courseId;

    @ApiModelProperty("课程名称(type==COURSE时才有)")
    private String courseName;

    @ApiModelProperty("课程封面图片(type==COURSE时才有)")
    private String imgUrl;

    @ApiModelProperty("运动类型")
    private ExerciseLogType type;

    @ApiModelProperty("打卡时间")
    private LocalDateTime time;

    @ApiModelProperty("耗时")
    private double timeConsuming;

    @ApiModelProperty("运动距离(type!=COURSE时才有)")
    private double distance;

    @ApiModelProperty("运动速度(type!=COURSE时才有)")
    private double speed;

    @ApiModelProperty("消耗卡路里")
    private double calories;

    public ExerciseLogItem(ExerciseLog log){
        this.id=log.getId();
        this.type=log.getType();
        this.time=log.getTime();
        this.timeConsuming=log.getTimeConsuming();
        this.distance=log.getDistance();
        this.speed=log.getSpeed();
        this.calories=log.getCalories();
    }
}
