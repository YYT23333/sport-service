package com.ht.sport.fallback;

import com.ht.sport.feign.CourseFeignClient;
import com.ht.sport.response.CourseInfoResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class CourseServiceFallback implements CourseFeignClient {

    @Override
    public CourseInfoResponse findNameAndAvatarByCourseIds(List<Integer> courseIds) {
        return new CourseInfoResponse();
    }
}
