package com.extrap.Models;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SoftwareEngineer extends User {
    private List<String> techStack;

    public SoftwareEngineer() {}
    public SoftwareEngineer(Integer id, String name, String email, String techStack) {
        super(id, name, email);
        this.techStack = Collections.singletonList(techStack);
    }

    // Getter
    public List<String> getTechStack() {
        return techStack;
    }

    // Setter
    public void setTechStack(String techStack) {
        this.techStack = Collections.singletonList(techStack);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return Objects.equals(techStack, that.techStack);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(techStack);
    }
}
