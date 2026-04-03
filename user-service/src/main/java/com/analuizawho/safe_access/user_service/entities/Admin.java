package com.analuizawho.safe_access.user_service.entities;

import com.analuizawho.safe_access.user_service.dtos.UpdateAdminDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin extends User{

    public Admin(){
        super();
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
