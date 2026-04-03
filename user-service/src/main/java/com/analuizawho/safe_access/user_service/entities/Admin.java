package com.analuizawho.safe_access.user_service.entities;

import com.analuizawho.safe_access.user_service.dtos.UpdateAdminDTO;
import com.analuizawho.safe_access.user_service.entities.enums.Department;
import com.analuizawho.safe_access.user_service.entities.enums.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends User{

    private Role role;

    public Admin(){
        super();
    }

    public Admin(Long id, String name, Department department, String password, Boolean userActive, Role role) {
        super(id, name, department, password, userActive);
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

}
