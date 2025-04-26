package com.extrap.Models;

import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class SoftwareEngineer extends User {
    private String techStack;

    public SoftwareEngineer() {
    }

    public SoftwareEngineer(Integer id, String name, String email, String techStack) {
        super(id, name, email);
        this.techStack = techStack;
    }

    // Getter
    public String getTechStack() {
        return techStack;
    }

    // Setter
    public void setTechStack(String techStack) {
        this.techStack = techStack;
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
