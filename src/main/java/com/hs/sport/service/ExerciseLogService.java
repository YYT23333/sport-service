package com.hs.sport.service;

import com.hs.sport.entity.ExerciseLog;
import com.hs.sport.enums.ExerciseLogType;
import com.hs.sport.exception.NotExistException;

import java.util.List;

public interface ExerciseLogService {
    ExerciseLog findById(Long id) throws NotExistException;
    List<ExerciseLog> findByUserAndType(Long userId, ExerciseLogType type);
}
