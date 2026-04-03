package com.analuizawho.safe_access.user_service.entities;

import com.analuizawho.safe_access.user_service.dtos.UpdateAdminDTO;
import com.analuizawho.safe_access.user_service.entities.enums.Department;
import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String password;
    private Boolean userActive;

    public Admin(){

    }

    public Admin(Long id, String name, Department department, String password, Boolean userActive){
        this.id = id;
        this.name = name;
        this.department = department;
        this.password = password;
        this.userActive = userActive;
    }

    private Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setUserActivated(){
        this.userActive = true;
    }

    public void setUserInactivated(){
        this.userActive = false;
    }

    public void updateAdminInfo(UpdateAdminDTO infoData){
        if(infoData.name() != null){
            this.name = infoData.name();
        }

        if(infoData.department() != null){
            this.department = infoData.department();
        }

        if(infoData.password() != null){
            this.password = infoData.password();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return id != null && id.equals(admin.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
