package com.hs.sport.dao;

import com.hs.sport.entity.CourseLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseLogDao extends JpaRepository<CourseLog,String> {
    Optional<CourseLog> findById(Long id);
    List<CourseLog> findByUserId(Long userId);
}
