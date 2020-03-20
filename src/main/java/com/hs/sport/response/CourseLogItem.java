package com.hs.sport.response;

import com.hs.sport.entity.CourseLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@ApiModel
public class CourseLogItem {
    @ApiModelProperty("课程打卡记录id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("课程id")
    private Long courseId;

    @ApiModelProperty("打卡时间")
    private LocalDateTime time;

    @ApiModelProperty("消耗卡路里")
    private double calories;

    @ApiModelProperty("耗时")
    private Double timeConsuming;

    public CourseLogItem(CourseLog courseLog){
        this.id=courseLog.getId();
        this.userId=courseLog.getUserId();
        this.courseId=courseLog.getCourseId();
        this.time=courseLog.getTime();
        this.calories=courseLog.getCalories();
        this.timeConsuming=courseLog.getTimeConsuming();
    }
}
