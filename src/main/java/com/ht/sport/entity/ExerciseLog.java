package com.ht.sport.entity;

import com.ht.sport.enums.ExerciseLogType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class ExerciseLog {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long userId;

    @Column
    private long courseId;
    
    @Column
    private ExerciseLogType type;

    @Column
    private LocalDateTime time;

    @Column
    private double timeConsuming;

    @Column
    private double distance;

    @Column
    private double speed;

    @Column
    private double calories;

}
