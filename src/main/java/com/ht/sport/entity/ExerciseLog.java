package com.ht.sport.entity;

import com.ht.sport.enums.ExerciseLogType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    private int courseId;
    
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

    @ElementCollection
    private List<Position> positions;

}
