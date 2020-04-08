package com.ht.sport.dataServiceImpl;

import com.ht.sport.dao.ExerciseLogDao;
import com.ht.sport.dataService.ExerciseLogDataService;
import com.ht.sport.entity.ExerciseLog;
import com.ht.sport.enums.ExerciseLogType;
import com.ht.sport.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExerciseLogDataServiceImpl implements ExerciseLogDataService {
    @Autowired
    private ExerciseLogDao exerciseLogDao;

    @Override
    public Long create(ExerciseLog log) {
        return exerciseLogDao.save(log).getId();
    }

    @Override
    public ExerciseLog findById(Long id) throws NotExistException {
        Optional<ExerciseLog> optional = exerciseLogDao.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotExistException("ExerciseLog ID:", id);
        }
    }

    @Override
    public List findByUserIdAndType(Long userId, ExerciseLogType exerciseLogType) {
        return exerciseLogDao.findByUserIdAndType(userId, exerciseLogType);
    }

    @Override
    public List rank30ByType(ExerciseLogType type, LocalDateTime start, LocalDateTime end) {
        return exerciseLogDao.rank30ByType(type.ordinal(), start, end);
    }

    @Override
    public List sortByType(ExerciseLogType type, LocalDateTime start, LocalDateTime end) {
        return exerciseLogDao.sortByType(type.ordinal(), start, end);
    }

    @Override
    public List rank30(LocalDateTime start, LocalDateTime end) {
        return exerciseLogDao.rank30(start, end);
    }

    @Override
    public List sort(LocalDateTime start, LocalDateTime end) {
        return exerciseLogDao.sort(start, end);
    }
}
