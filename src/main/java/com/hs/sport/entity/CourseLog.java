package com.hs.sport.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@ApiModel
public class CourseLog {

    @Id
    @GeneratedValue
    @ApiModelProperty(name="课程打卡记录id",dataType = "Long")
    private Long id;

    @Column
    @ApiModelProperty(name="用户id",dataType = "Long")
    private Long userId;

    @Column
    @ApiModelProperty(name="课程id",dataType = "Long")
    private Long courseId;

    @Column
    @ApiModelProperty(name="打卡时间",dataType = "LocalDateTime")
    private LocalDateTime time;

    @Column
    @ApiModelProperty(name="消耗卡路里")
    private double calories;

    @Column
    @ApiModelProperty(name="耗时")
    private Double timeConsuming;

}
