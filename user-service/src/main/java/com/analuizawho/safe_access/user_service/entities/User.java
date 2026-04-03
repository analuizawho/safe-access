package com.analuizawho.safe_access.user_service.entities;

import com.analuizawho.safe_access.user_service.entities.enums.Department;
import jakarta.persistence.*;

import java.util.Objects;

@MappedSuperclass
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name;
    @Enumerated(EnumType.STRING)
    protected Department department;
    protected String password;
    protected Boolean userActive;

    public User(){

    }

    public User(Long id, String name, Department department, String password, Boolean userActive){
        this.id = id;
        this.name = name;
        this.department = department;
        this.password = password;
        this.userActive = userActive;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
