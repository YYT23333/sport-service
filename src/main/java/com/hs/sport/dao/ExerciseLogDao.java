package com.hs.sport.dao;

import com.hs.sport.entity.ExerciseLog;
import com.hs.sport.enums.ExerciseLogType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseLogDao extends JpaRepository<ExerciseLog,String> {
    Optional<ExerciseLog> findById(Long id);
    List<ExerciseLog> findByUserIdAndType(Long userId, ExerciseLogType type);
}
