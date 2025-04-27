package com.extrap.Controller;

import com.extrap.Model.SoftwareEngineer;
import com.extrap.Service.SoftwareEngineerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/software-engineers")
public class SoftwareEngineerController {
    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    // Get all Software Engineers
    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    // Insert a new Software Engineer
    @PostMapping
    public ResponseEntity<?> addNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
        return ResponseEntity.status(201).body("User created!");
    }

    // Get a Software Engineer ById
    @GetMapping("/{id}")
    public ResponseEntity<?> getSoftwareEngineerById(@PathVariable Integer id) {
        Optional<SoftwareEngineer> engineer = softwareEngineerService.findSoftwareEngineerById(id);
        if (engineer.isPresent()) {
            return ResponseEntity.ok(engineer.get());
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }

}
