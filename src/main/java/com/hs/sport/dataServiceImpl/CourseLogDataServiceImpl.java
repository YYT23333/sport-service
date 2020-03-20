package com.hs.sport.dataServiceImpl;

import com.hs.sport.dao.CourseLogDao;
import com.hs.sport.dataService.CourseLogDataService;
import com.hs.sport.entity.CourseLog;
import com.hs.sport.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseLogDataServiceImpl implements CourseLogDataService {
    @Autowired
    private CourseLogDao courseLogDao;
    @Override
    public CourseLog findById(Long id) throws NotExistException{
        Optional<CourseLog> optional=courseLogDao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new NotExistException("CourseLog ID:",id);
        }
    }

    @Override
    public List<CourseLog> findByUserId(Long userId) {
        return courseLogDao.findByUserId(userId);
    }
}
