package com.extrap.Service;

import com.extrap.Model.SoftwareEngineer;
import com.extrap.Repository.SoftwareEngineerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    // Get all Software Engineers
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    // Insert a new Software Engineer
    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    // Get a Software Engineer ById
    public Optional<SoftwareEngineer> findSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id);
    }

}
