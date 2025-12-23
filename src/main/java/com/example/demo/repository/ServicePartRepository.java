package com.example.demo.repository;

import com.example.demo.model.ServicePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServicePartRepository extends JpaRepository<ServicePart, Long> {
    @Query("SELECT sp FROM ServicePart sp WHERE sp.serviceEntry.id = :serviceEntryId")
    List<ServicePart> findByServiceEntryId(@Param("serviceEntryId") Long serviceEntryId);
}
