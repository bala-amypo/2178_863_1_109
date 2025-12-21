package com.example.demo.repository;

import com.example.demo.entity.RecommendationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRecordRepository extends JpaRepository<RecommendationRecord, Long> {

    // Fetch all recommendation records for a specific user
    List<RecommendationRecord> findByUserId(Long userId);
}
