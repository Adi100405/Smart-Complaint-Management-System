package com.project.complaintsystem.service;

import com.project.complaintsystem.entity.Complaint;
import com.project.complaintsystem.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    public Complaint saveComplaint(Complaint complaint) {
        complaint.setCreatedAt(LocalDateTime.now());
        complaint.setStatus("Pending");

        String text = complaint.getDescription() == null ? "" : complaint.getDescription().toLowerCase();

        if (text.contains("urgent") || text.contains("emergency") || text.contains("immediately")) {
            complaint.setPriority("High");
        } else if (text.contains("important") || text.contains("soon")) {
            complaint.setPriority("Medium");
        } else {
            complaint.setPriority("Low");
        }

        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public List<Complaint> getComplaintsByStatus(String status) {
        return complaintRepository.findByStatus(status);
    }

    public Complaint updateStatus(Long id, String status) {
        if (id == null) {
            throw new IllegalArgumentException("Complaint id cannot be null");
        }
        Complaint complaint = complaintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Complaint not found with id: " + id));
        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }

    public Map<String, Long> getDashboardStats() {
        long total = complaintRepository.count();
        long pending = complaintRepository.countByStatus("Pending");
        long resolved = complaintRepository.countByStatus("Resolved");

        Map<String, Long> stats = new HashMap<>();
        stats.put("Total Complaints", total);
        stats.put("Pending Complaints", pending);
        stats.put("Resolved Complaints", resolved);
        return stats;
    }
}
