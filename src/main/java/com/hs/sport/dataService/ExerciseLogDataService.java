package com.hs.sport.dataService;

import com.hs.sport.entity.ExerciseLog;
import com.hs.sport.enums.ExerciseLogType;
import com.hs.sport.exception.NotExistException;

import java.util.List;

public interface ExerciseLogDataService {
    ExerciseLog findById(Long id) throws NotExistException;
    List<ExerciseLog> findByUserIdAndType(Long userId, ExerciseLogType exerciseLogType);
}
