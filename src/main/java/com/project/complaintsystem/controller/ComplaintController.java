package com.project.complaintsystem.controller;

import com.project.complaintsystem.entity.Complaint;
import com.project.complaintsystem.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/complaints")
@CrossOrigin
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping
    public Complaint createComplaint(@RequestBody Complaint complaint) {
        return complaintService.saveComplaint(complaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    @GetMapping("/status/{status}")
    public List<Complaint> getByStatus(@PathVariable String status) {
        return complaintService.getComplaintsByStatus(status);
    }

    @PutMapping("/{id}/status")
    public Complaint updateStatus(@PathVariable Long id, @RequestParam String status) {
        return complaintService.updateStatus(id, status);
    }

    @GetMapping("/dashboard")
    public Map<String, Long> dashboard() {
        return complaintService.getDashboardStats();
    }
}
