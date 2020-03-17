package com.hs.sport.entity;

import com.hs.sport.enums.ExerciseLogType;
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
    private Long id;
    
    @Column
    private ExerciseLogType type;

    @Column
    private LocalDateTime time;

    @Column
    private double distance;

    @Column
    private double speed;

    @Column
    private double calories;

    @Column
    private String imgUrl;

}
