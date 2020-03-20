package com.hs.sport.service;

import com.hs.sport.entity.CourseLog;
import com.hs.sport.exception.NotExistException;
import com.hs.sport.response.CourseLogDetailResponse;
import com.hs.sport.response.CourseLogListResponse;

import java.util.List;

public interface CourseLogService {
    CourseLogDetailResponse findById(Long id) throws NotExistException;
    CourseLogListResponse findByUser(Long userId);
}
