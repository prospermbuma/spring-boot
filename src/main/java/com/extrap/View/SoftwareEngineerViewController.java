package com.extrap.View;

import com.extrap.Model.SoftwareEngineer;
import com.extrap.Service.SoftwareEngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SoftwareEngineerViewController {

    @Autowired
    private SoftwareEngineerService softwareEngineerService;

    @GetMapping("/software-engineers/view")
    public String viewSoftwareEngineers(Model model) {
        List<SoftwareEngineer> engineers = softwareEngineerService.getAllSoftwareEngineers();
        model.addAttribute("softwareEngineers", engineers);
        return "software-engineers"; // this is the Thymeleaf HTML file name
    }
}
