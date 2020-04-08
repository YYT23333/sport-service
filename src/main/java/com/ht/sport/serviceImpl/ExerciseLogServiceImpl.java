package com.ht.sport.serviceImpl;

import com.ht.sport.dataService.ExerciseLogDataService;
import com.ht.sport.entity.ExerciseLog;
import com.ht.sport.enums.ExerciseLogType;
import com.ht.sport.exception.NotExistException;
import com.ht.sport.parameters.ExerciseLogParameter;
import com.ht.sport.response.*;
import com.ht.sport.service.ExerciseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class ExerciseLogServiceImpl implements ExerciseLogService {
    @Autowired
    private ExerciseLogDataService exerciseLogDataService;

    @Override
    public AddResponse create(ExerciseLogParameter parameter) {
        ExerciseLog log = new ExerciseLog();
        log.setUserId(parameter.getUserId());
        log.setTime(LocalDateTime.now());
        log.setType(parameter.getType());
        if (parameter.getType() == ExerciseLogType.COURSE) {
            log.setCourseId(parameter.getCourseId());
            //todo 从课程拿数据
        } else {
            log.setDistance(parameter.getDistance());
            log.setCalories(parameter.getCalories());
            log.setTimeConsuming(parameter.getTimeConsuming());
            log.setSpeed(parameter.getSpeed());
        }
        log.setUserId(parameter.getUserId());
        log.setTime(LocalDateTime.now());
        //todo 找课程拿课程数据
        return new AddResponse(exerciseLogDataService.create(log));
    }

    @Override
    public ExerciseLogDetailResponse findById(Long id) throws NotExistException {
        return new ExerciseLogDetailResponse(exerciseLogDataService.findById(id));
    }

    @Override
    public ExerciseLogListResponse findByUserAndType(Long userId, ExerciseLogType type) {
        return new ExerciseLogListResponse(exerciseLogDataService.findByUserIdAndType(userId, type));
    }

    @Override
    public RankListResponse rank30ByType(ExerciseLogType type) {
        LocalDateTime yesterday_start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        List list = exerciseLogDataService.rank30ByType(type,yesterday_start,today_start);
        List<RankItem> items = new ArrayList<>();
        for(Object row:list){
            RankItem item = new RankItem();
            Object[] cells = (Object[]) row;
            item.setUserId(((BigInteger) cells[0]).longValue());
            item.setTotalTime((double) cells[1]);
            //todo 获取用户头像 昵称
            items.add(item);
        }
        return new RankListResponse(items);
    }

    @Override
    public RankListResponse sortByType(ExerciseLogType type) {
        LocalDateTime yesterday_start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        List list = exerciseLogDataService.sortByType(type,yesterday_start,today_start);
        List<RankItem> items = new ArrayList<>();
        for(Object row:list){
            RankItem item = new RankItem();
            Object[] cells = (Object[]) row;
            item.setUserId(((BigInteger) cells[0]).longValue());
            item.setTotalTime((double) cells[1]);
            items.add(item);
        }
        return new RankListResponse(items);
    }

    @Override
    public RankListResponse rank30() {
        LocalDateTime yesterday_start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        List list = exerciseLogDataService.rank30(yesterday_start,today_start);
        List<RankItem> items = new ArrayList<>();
        for(Object row:list){
            RankItem item = new RankItem();
            Object[] cells = (Object[]) row;
            item.setUserId(((BigInteger) cells[0]).longValue());
            item.setTotalTime((double) cells[1]);
            items.add(item);
        }
        return new RankListResponse(items);
    }

    @Override
    public RankListResponse sort() {
        LocalDateTime yesterday_start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        List list = exerciseLogDataService.sort(yesterday_start,today_start);
        List<RankItem> items = new ArrayList<>();
        for(Object row:list){
            RankItem item = new RankItem();
            Object[] cells = (Object[]) row;
            item.setUserId(((BigInteger) cells[0]).longValue());
            item.setTotalTime((double) cells[1]);
            items.add(item);
        }
        return new RankListResponse(items);
    }

}
