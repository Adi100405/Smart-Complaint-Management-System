package com.project.complaintsystem.repository;

import com.project.complaintsystem.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByStatus(String status);
    long countByStatus(String status);
}
