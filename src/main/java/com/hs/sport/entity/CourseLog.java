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
public class CourseLog {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long courseId;

    @Column
    private LocalDateTime time;

    @Column
    private double calories;

    @Column
    private Double timeConsuming;

}
