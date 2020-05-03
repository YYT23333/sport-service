package com.ht.sport.serviceImpl;

import com.ht.sport.feign.CourseFeignClient;
import com.ht.sport.response.CourseInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService  {
    @Autowired
    private CourseFeignClient courseFeignClient;

    public CourseInfoResponse getCourseInfo(List<Integer> courseIds) {
        return courseFeignClient.findNameAndAvatarByCourseIds(courseIds);
    }


}
