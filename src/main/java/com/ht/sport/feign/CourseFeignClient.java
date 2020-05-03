package com.ht.sport.feign;

import com.ht.sport.fallback.CourseServiceFallback;
import com.ht.sport.response.CourseInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "course-server",fallback = CourseServiceFallback.class)
public interface CourseFeignClient {
    @RequestMapping(value = "/hastime/course/util/coursepartdetails", method = RequestMethod.GET)
    CourseInfoResponse findNameAndAvatarByCourseIds(@RequestParam("courseIds") List<Integer> courseIds);
}
