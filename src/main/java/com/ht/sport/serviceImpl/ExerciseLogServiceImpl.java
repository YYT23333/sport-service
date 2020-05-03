package com.ht.sport.serviceImpl;

import com.ht.sport.dataService.ExerciseLogDataService;
import com.ht.sport.entity.ExerciseLog;
import com.ht.sport.enums.ExerciseLogType;
import com.ht.sport.exception.NotExistException;
import com.ht.sport.parameters.ExerciseLogParameter;
import com.ht.sport.response.*;
import com.ht.sport.service.ExerciseLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExerciseLogServiceImpl implements ExerciseLogService {
    @Autowired
    private ExerciseLogDataService exerciseLogDataService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Override
    public AddResponse create(ExerciseLogParameter parameter) {
        ExerciseLog log = new ExerciseLog();
        log.setUserId(parameter.getUserId());
        log.setTime(LocalDateTime.now());
        log.setType(parameter.getType());
        log.setCalories(parameter.getCalories());
        log.setTimeConsuming(parameter.getTimeConsuming());
        if (parameter.getType() == ExerciseLogType.COURSE) {
            log.setCourseId(parameter.getCourseId());
        } else {
            log.setDistance(parameter.getDistance());
            log.setSpeed(parameter.getSpeed());
            log.setLongitudes(parameter.getLongitudes());
            log.setLatitudes(parameter.getLatitudes());
        }
        return new AddResponse(exerciseLogDataService.create(log));
    }

    @Override
    public ExerciseLogDetailResponse findById(Long id) throws NotExistException {
        ExerciseLog log = exerciseLogDataService.findById(id);
        ExerciseLogItem item = new ExerciseLogItem(log);
        if (log.getType() == ExerciseLogType.COURSE) {
            List<Integer> courseIds = Collections.singletonList(log.getCourseId());
            CourseInfoResponse courseInfoResponse = courseService.getCourseInfo(courseIds);
            List<CourseNameAndAvatarItem> info = courseInfoResponse.getData();
            if (info != null && info.size() > 0) {
                item.setImgUrl(info.get(0).getImgUrl());
                item.setCourseName(info.get(0).getName());
            }
        }
        return new ExerciseLogDetailResponse(item);
    }

    @Override
    public ExerciseLogListResponse findByUserAndType(Long userId, ExerciseLogType type, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<ExerciseLog> exerciseLogs = exerciseLogDataService.findByUserIdAndType(userId, type, pageable);
        List<ExerciseLogItem> items = new ArrayList<>();
        if (type == ExerciseLogType.COURSE) {
            List<Integer> courseIds = exerciseLogs.stream().map(ExerciseLog -> ExerciseLog.getCourseId()).collect(Collectors.toList());
            CourseInfoResponse courseInfoResponse = courseService.getCourseInfo(courseIds);
            List<CourseNameAndAvatarItem> info = courseInfoResponse.getData();
            if (info != null && info.size() > 0) {
                for (ExerciseLog log : exerciseLogs) {
                    for (CourseNameAndAvatarItem courseInfo : info) {
                        if (log.getCourseId() == courseInfo.getId()) {
                            ExerciseLogItem item = new ExerciseLogItem(log);
                            item.setCourseName(courseInfo.getName());
                            item.setImgUrl(courseInfo.getImgUrl());
                            items.add(item);
                        }
                    }
                }
                return new ExerciseLogListResponse(items);
            }
        }
        exerciseLogs.forEach(log -> {
            ExerciseLogItem item = new ExerciseLogItem(log);
            items.add(item);
        });
        return new ExerciseLogListResponse(items);
    }

    @Override
    public RankListResponse rank30ByType(ExerciseLogType type) {
        LocalDateTime yesterday_start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        List list = exerciseLogDataService.rank30ByType(type, yesterday_start, today_start);
        List<RankItem> items = new ArrayList<>();
        for (Object row : list) {
            RankItem item = new RankItem();
            Object[] cells = (Object[]) row;
            item.setUserId(((BigInteger) cells[0]).longValue());
            item.setTotalTime((double) cells[1]);
            items.add(item);
        }
        List<Long> userIds = items.stream().map(RankItem -> RankItem.getUserId()).collect(Collectors.toList());
        UserInfoResponse userInfoResponse = userService.getUserInfo(userIds);
        List<UserNameAndAvatar> info = userInfoResponse.getData();
        if (info != null && info.size() > 0) {
            for (RankItem item : items) {
                for (UserNameAndAvatar userInfo : userInfoResponse.getData()) {
                    if (item.getUserId() == userInfo.getUserid()) {
                        item.setImgUrl(userInfo.getAvatarUrl());
                        item.setUsername(userInfo.getName());
                    }
                }
            }
        }
        return new RankListResponse(items);
    }

    @Override
    public RankListResponse sortByType(ExerciseLogType type) {
        LocalDateTime yesterday_start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        List list = exerciseLogDataService.sortByType(type, yesterday_start, today_start);
        List<RankItem> items = new ArrayList<>();
        for (Object row : list) {
            RankItem item = new RankItem();
            Object[] cells = (Object[]) row;
            item.setUserId(((BigInteger) cells[0]).longValue());
            item.setTotalTime((double) cells[1]);
            items.add(item);
        }
        List<Long> userIds = items.stream().map(RankItem -> RankItem.getUserId()).collect(Collectors.toList());
        UserInfoResponse userInfoResponse = userService.getUserInfo(userIds);
        List<UserNameAndAvatar> info = userInfoResponse.getData();
        if (info != null && info.size() > 0) {
            for (RankItem item : items) {
                for (UserNameAndAvatar userInfo : userInfoResponse.getData()) {
                    if (item.getUserId() == userInfo.getUserid()) {
                        item.setImgUrl(userInfo.getAvatarUrl());
                        item.setUsername(userInfo.getName());
                    }
                }
            }
        }
        return new RankListResponse(items);
    }

    @Override
    public RankListResponse rank30() {
        LocalDateTime yesterday_start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        List list = exerciseLogDataService.rank30(yesterday_start, today_start);
        List<RankItem> items = new ArrayList<>();
        for (Object row : list) {
            RankItem item = new RankItem();
            Object[] cells = (Object[]) row;
            item.setUserId(((BigInteger) cells[0]).longValue());
            item.setTotalTime((double) cells[1]);
            items.add(item);
        }
        List<Long> userIds = items.stream().map(RankItem -> RankItem.getUserId()).collect(Collectors.toList());
        UserInfoResponse userInfoResponse = userService.getUserInfo(userIds);
        List<UserNameAndAvatar> info = userInfoResponse.getData();
        if (info != null && info.size() > 0) {
            for (RankItem item : items) {
                for (UserNameAndAvatar userInfo : userInfoResponse.getData()) {
                    if (item.getUserId() == userInfo.getUserid()) {
                        item.setImgUrl(userInfo.getAvatarUrl());
                        item.setUsername(userInfo.getName());
                    }
                }
            }
        }
        return new RankListResponse(items);
    }

    @Override
    public RankListResponse sort() {
        LocalDateTime yesterday_start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.MIN);
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        List list = exerciseLogDataService.sort(yesterday_start, today_start);
        List<RankItem> items = new ArrayList<>();
        for (Object row : list) {
            RankItem item = new RankItem();
            Object[] cells = (Object[]) row;
            item.setUserId(((BigInteger) cells[0]).longValue());
            item.setTotalTime((double) cells[1]);
            items.add(item);
        }
        List<Long> userIds = items.stream().map(RankItem -> RankItem.getUserId()).collect(Collectors.toList());
        UserInfoResponse userInfoResponse = userService.getUserInfo(userIds);
        List<UserNameAndAvatar> info = userInfoResponse.getData();
        if (info != null && info.size() > 0) {
            for (RankItem item : items) {
                for (UserNameAndAvatar userInfo : userInfoResponse.getData()) {
                    if (item.getUserId() == userInfo.getUserid()) {
                        item.setImgUrl(userInfo.getAvatarUrl());
                        item.setUsername(userInfo.getName());
                    }
                }
            }
        }
        return new RankListResponse(items);
    }

}
