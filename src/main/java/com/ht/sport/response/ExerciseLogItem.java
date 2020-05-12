package com.ht.sport.response;

import com.ht.sport.entity.ExerciseLog;
import com.ht.sport.enums.ExerciseLogType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@ApiModel
public class ExerciseLogItem {
    @ApiModelProperty("运动记录Id")
    private long id;

    @ApiModelProperty("课程id(type==COURSE时才有)")
    private int courseId;

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

    @ApiModelProperty("经度列表(type!=COURSE时才有)")
    private List<Double> longitudes;

    @ApiModelProperty("纬度列表(type!=COURSE时才有)")
    private List<Double> latitudes;

    public ExerciseLogItem(ExerciseLog log){
        this.id=log.getId();
        this.courseId=log.getCourseId();
        this.type=log.getType();
        this.time=log.getTime();
        this.timeConsuming=log.getTimeConsuming();
        this.distance=log.getDistance();
        this.speed=log.getSpeed();
        this.calories=log.getCalories();
        this.longitudes=log.getPositions().stream().map(Position->Position.getLongitude()).collect(Collectors.toList());
        this.latitudes=log.getPositions().stream().map(Position->Position.getLatitudes()).collect(Collectors.toList());
    }
}
