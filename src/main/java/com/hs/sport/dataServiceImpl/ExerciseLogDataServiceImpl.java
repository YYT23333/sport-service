package com.hs.sport.dataServiceImpl;

import com.hs.sport.dao.ExerciseLogDao;
import com.hs.sport.dataService.ExerciseLogDataService;
import com.hs.sport.entity.ExerciseLog;
import com.hs.sport.enums.ExerciseLogType;
import com.hs.sport.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseLogDataServiceImpl implements ExerciseLogDataService {
    @Autowired
    private ExerciseLogDao exerciseLogDao;
    @Override
    public ExerciseLog findById(Long id) throws NotExistException{
        Optional<ExerciseLog> optional=exerciseLogDao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        else{
            throw new NotExistException("ExerciseLog ID:",id);
        }
    }

    @Override
    public List<ExerciseLog> findByUserIdAndType(Long userId, ExerciseLogType exerciseLogType) {
        return exerciseLogDao.findByUserIdAndType(userId,exerciseLogType);
    }
}
