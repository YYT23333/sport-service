package com.hs.sport.serviceImpl;

import com.hs.sport.dataService.CourseLogDataService;
import com.hs.sport.entity.CourseLog;
import com.hs.sport.exception.NotExistException;
import com.hs.sport.response.CourseLogDetailResponse;
import com.hs.sport.response.CourseLogListResponse;
import com.hs.sport.service.CourseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseLogServiceImpl implements CourseLogService {
    @Autowired
    private CourseLogDataService courseLogDataService;

    @Override
    public CourseLogDetailResponse findById(Long id) throws NotExistException {
        return new CourseLogDetailResponse(courseLogDataService.findById(id));
    }

    @Override
    public CourseLogListResponse findByUser(Long userId) {
        return new CourseLogListResponse(courseLogDataService.findByUserId(userId));
    }
}
