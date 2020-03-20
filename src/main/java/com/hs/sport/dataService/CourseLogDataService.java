package com.hs.sport.dataService;

import com.hs.sport.entity.CourseLog;
import com.hs.sport.exception.NotExistException;

import java.util.List;

public interface CourseLogDataService {
    CourseLog findById(Long id) throws NotExistException;
    List<CourseLog> findByUserId(Long userId);
}
