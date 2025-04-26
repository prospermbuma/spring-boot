package com.extrap;

public class SoftwareEngineer extends User {
    private String techStack;

    public SoftwareEngineer() {}
    public SoftwareEngineer(int id, String name, String email, String techStack) {
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
}
