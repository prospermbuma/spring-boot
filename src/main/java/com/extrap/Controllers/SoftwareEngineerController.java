package com.extrap.Controllers;

import com.extrap.Models.SoftwareEngineer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/software-engineers")
public class SoftwareEngineerController {
    @GetMapping
    public List<SoftwareEngineer> getSoftwareEngineers() {
        return List.of(
                new SoftwareEngineer(
                        1,
                        "James Doe",
                        "james.doe@extrap.com",
                        "React, Node, MongoDB, Express"
                ),
                new SoftwareEngineer(
                        2,
                        "John Doe",
                        "john.doe@extrap.com",
                        "Vue, Java, Postgres, Spring Boot"
                )
        );
    }
}
