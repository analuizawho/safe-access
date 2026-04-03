package com.analuizawho.safe_access.user_service.entities;

import com.analuizawho.safe_access.user_service.dtos.UpdateEmployeeDTO;
import com.analuizawho.safe_access.user_service.entities.enums.Department;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class Employee extends User{

    private String position;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Employee() {
        super();
    }

    public Employee(Long id, String name, Department department, String password, Boolean userActive, String position, LocalDateTime entryTime, LocalDateTime exitTime) {
        super(id, name, department, password, userActive);
        this.position = position;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

}
