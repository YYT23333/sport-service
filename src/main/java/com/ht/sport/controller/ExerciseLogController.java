package com.ht.sport.controller;

import com.ht.sport.enums.ExerciseLogType;
import com.ht.sport.exception.NotExistException;
import com.ht.sport.parameters.ExerciseLogParameter;
import com.ht.sport.response.ExerciseLogDetailResponse;
import com.ht.sport.response.ExerciseLogListResponse;
import com.ht.sport.response.RankListResponse;
import com.ht.sport.response.Response;
import com.ht.sport.service.ExerciseLogService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exerciseLog")
public class ExerciseLogController {
    @Autowired
    private ExerciseLogService exerciseLogService;

    @ApiOperation(value = "创建运动记录")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Response.class)})
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Response> createNewLog(@RequestBody @ApiParam ExerciseLogParameter parameter) throws NotExistException {
        return new ResponseEntity<>(exerciseLogService.create(parameter), HttpStatus.OK);
    }

    @ApiOperation(value = "根据id查找运动记录")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ExerciseLogDetailResponse.class)})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Response> findById(@PathVariable Long id) throws NotExistException {
        return new ResponseEntity<>(exerciseLogService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "根据userId和运动类型查找运动记录")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = ExerciseLogListResponse.class)})
    @RequestMapping(value = "/user/{userId}/{type}", method = RequestMethod.GET)
    public ResponseEntity<Response> findByUserId(@PathVariable Long userId,@PathVariable ExerciseLogType type) {
        return new ResponseEntity<>(exerciseLogService.findByUserAndType(userId,type), HttpStatus.OK);
    }

    @ApiOperation(value = "根据类型获得前一天时长排名前30的用户")
    @ApiImplicitParam(name = "type", value = "运动类型", required = true, dataType = "String")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = RankListResponse.class)})
    @RequestMapping(value = "/rank/{type}",method=RequestMethod.GET)
    public ResponseEntity<Response> rank30ByType(@PathVariable ExerciseLogType type) {
        return new ResponseEntity<>(exerciseLogService.rank30ByType(type), HttpStatus.OK);
    }

    @ApiOperation(value = "根据类型对前一天用户时长排名（管理员）")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = RankListResponse.class)})
    @RequestMapping(value = "/sort/{type}",method=RequestMethod.GET)
    public ResponseEntity<Response> sortByType(@PathVariable ExerciseLogType type) {
        return new ResponseEntity<>(exerciseLogService.sortByType(type), HttpStatus.OK);
    }

    @ApiOperation(value = "获得前一天总时长排名前30的用户")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = RankListResponse.class)})
    @RequestMapping(value = "/rank",method=RequestMethod.GET)
    public ResponseEntity<Response> rank30() {
        return new ResponseEntity<>(exerciseLogService.rank30(), HttpStatus.OK);
    }

    @ApiOperation(value = "获得前一天用户运动时长+课程时长排名（管理员）")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = RankListResponse.class)})
    @RequestMapping(value = "/sort",method=RequestMethod.GET)
    public ResponseEntity<Response> sort() {
        return new ResponseEntity<>(exerciseLogService.sort(), HttpStatus.OK);
    }

}
