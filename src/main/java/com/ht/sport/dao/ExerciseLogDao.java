package com.ht.sport.dao;

import com.ht.sport.entity.ExerciseLog;
import com.ht.sport.enums.ExerciseLogType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ExerciseLogDao extends JpaRepository<ExerciseLog, String> {
    Optional<ExerciseLog> findById(Long id);

    List<ExerciseLog> findByUserIdAndType(Long userId, ExerciseLogType type);

    @Query(nativeQuery = true, value = "select user_id,sum(time_consuming) from exercise_log where type=?1 and time>=?2 and time<?3 group by user_id order by sum(time_consuming) desc limit 30")
    List rank30ByType(int type, LocalDateTime start, LocalDateTime end);

    @Query(nativeQuery = true, value = "select user_id,sum(time_consuming) from exercise_log where type=?1 and time>=?2 and time<?3 group by user_id order by sum(time_consuming) desc")
    List sortByType(int type, LocalDateTime start, LocalDateTime end);

    @Query(nativeQuery = true, value = "select user_id,sum(time_consuming) from exercise_log where time>=?1 and time<?2 group by user_id order by sum(time_consuming) desc limit 30")
    List rank30(LocalDateTime start, LocalDateTime end);

    @Query(nativeQuery = true, value = "select user_id,sum(time_consuming) from exercise_log where time>=?1 and time<?2 group by user_id order by sum(time_consuming) desc")
    List sort(LocalDateTime start, LocalDateTime end);
}
