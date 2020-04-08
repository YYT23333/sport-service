package com.ht.sport.dataService;

import com.ht.sport.entity.ExerciseLog;
import com.ht.sport.enums.ExerciseLogType;
import com.ht.sport.exception.NotExistException;

import java.time.LocalDateTime;
import java.util.List;

public interface ExerciseLogDataService {
    Long create(ExerciseLog log);

    ExerciseLog findById(Long id) throws NotExistException;

    List<ExerciseLog> findByUserIdAndType(Long userId, ExerciseLogType exerciseLogType);

    List rank30ByType(ExerciseLogType type, LocalDateTime start, LocalDateTime end);

    List sortByType(ExerciseLogType type, LocalDateTime start, LocalDateTime end);

    List rank30(LocalDateTime start, LocalDateTime end);

    List sort(LocalDateTime start, LocalDateTime end);
}
