package com.analuizawho.safe_access.user_service.entities;

import com.analuizawho.safe_access.user_service.dtos.UpdateAdminDTO;
import com.analuizawho.safe_access.user_service.dtos.UpdateEmployeeDTO;
import com.analuizawho.safe_access.user_service.entities.enums.Department;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    @Enumerated(EnumType.STRING)
    private Department department;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String password;
    private Boolean employeeActive;

    public Employee() {
    }

    public Employee(Long id, String name, String position, Department department,
                    LocalDateTime entryTime, LocalDateTime exitTime, String password, Boolean employeeActive) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.password = password;
        this.employeeActive = employeeActive;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmployeeActivated() {
        this.employeeActive = true;
    }

    public void setEmployeeInactivated() {
        this.employeeActive = false;
    }

    public void updateEmployeeInfo(UpdateEmployeeDTO infoData){
        if(infoData.name() != null){
            this.name = infoData.name();
        }

        if(infoData.position() != null){
            this.position = infoData.position();
        }

        if(infoData.department() != null){
            this.department = infoData.department();
        }

        if(infoData.entryTime() != null){
            this.entryTime = infoData.entryTime();
        }

        if(infoData.exitTime() != null){
            this.exitTime = infoData.exitTime();
        }

        if(infoData.password() != null){
            this.password = infoData.password();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
