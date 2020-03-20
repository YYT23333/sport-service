package com.hs.sport.serviceImpl;

import com.hs.sport.dataService.ExerciseLogDataService;
import com.hs.sport.entity.ExerciseLog;
import com.hs.sport.enums.ExerciseLogType;
import com.hs.sport.exception.NotExistException;
import com.hs.sport.service.ExerciseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseLogServiceImpl implements ExerciseLogService {
    @Autowired
    private ExerciseLogDataService exerciseLogDataService;
    @Override
    public ExerciseLog findById(Long id) throws NotExistException {
        return exerciseLogDataService.findById(id);
    }

    @Override
    public List<ExerciseLog> findByUserAndType(Long userId, ExerciseLogType type) {
        return exerciseLogDataService.findByUserIdAndType(userId,type);
    }
}
