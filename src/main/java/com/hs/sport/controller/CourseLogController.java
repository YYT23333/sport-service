package com.hs.sport.controller;

import com.hs.sport.exception.NotExistException;
import com.hs.sport.response.CourseLogDetailResponse;
import com.hs.sport.response.CourseLogListResponse;
import com.hs.sport.response.Response;
import com.hs.sport.response.WrongResponse;
import com.hs.sport.service.CourseLogService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courseLog")
public class CourseLogController {
    @Autowired
    private CourseLogService courseLogService;

    @ApiOperation(value = "通过id获取课程记录")
    @ApiImplicitParam(name = "id", value = "课程记录id", required = true, dataType = "Long")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CourseLogDetailResponse.class),
            @ApiResponse(code = 500, message = "Failure", response = WrongResponse.class)})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> findById(@PathVariable Long id) throws NotExistException {
        return new ResponseEntity<>(courseLogService.findById(id), HttpStatus.OK);
    }


    @ApiOperation(value = "通过用户id获取课程记录")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Long")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CourseLogListResponse.class)})
    @RequestMapping(value = "/user/{userId}",method=RequestMethod.GET)
    public ResponseEntity<Response> findByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(courseLogService.findByUser(userId), HttpStatus.OK);
    }
}
