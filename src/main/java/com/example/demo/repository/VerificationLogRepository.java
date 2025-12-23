package com.example.demo.repository;

import com.example.demo.model.VerificationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VerificationLogRepository extends JpaRepository<VerificationLog, Long> {
    @Query("SELECT vl FROM VerificationLog vl WHERE vl.serviceEntry.id = :serviceEntryId")
    List<VerificationLog> findByServiceEntryId(@Param("serviceEntryId") Long serviceEntryId);
    
    List<VerificationLog> findByVerifiedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}
