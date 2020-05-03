package com.ht.sport.service;

import com.ht.sport.enums.ExerciseLogType;
import com.ht.sport.exception.NotExistException;
import com.ht.sport.parameters.ExerciseLogParameter;
import com.ht.sport.response.AddResponse;
import com.ht.sport.response.ExerciseLogDetailResponse;
import com.ht.sport.response.ExerciseLogListResponse;
import com.ht.sport.response.RankListResponse;


public interface ExerciseLogService {
    AddResponse create(ExerciseLogParameter parameter);
    ExerciseLogDetailResponse findById(Long id) throws NotExistException;
    ExerciseLogListResponse findByUserAndType(Long userId, ExerciseLogType type,int page,int pageSize);
    RankListResponse rank30ByType(ExerciseLogType type);
    RankListResponse sortByType(ExerciseLogType type);
    RankListResponse rank30();
    RankListResponse sort();
}
