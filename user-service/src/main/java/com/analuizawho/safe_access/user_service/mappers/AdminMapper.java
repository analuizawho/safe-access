package com.analuizawho.safe_access.user_service.mappers;

import com.analuizawho.safe_access.user_service.dtos.CreateAdminDTO;
import com.analuizawho.safe_access.user_service.dtos.InfoAdminDTO;
import com.analuizawho.safe_access.user_service.entities.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    InfoAdminDTO toInfo(Admin admin);

    Admin toAdmin(CreateAdminDTO createDTO);
}
