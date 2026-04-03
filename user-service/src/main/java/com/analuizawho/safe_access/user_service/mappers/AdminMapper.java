package com.analuizawho.safe_access.user_service.mappers;

import com.analuizawho.safe_access.user_service.dtos.CreateAdminDTO;
import com.analuizawho.safe_access.user_service.dtos.InfoAdminDTO;
import com.analuizawho.safe_access.user_service.entities.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    InfoAdminDTO toInfo(Admin admin);

    Admin toAdmin(CreateAdminDTO createDTO);

    @Mapping(target = "id", ignore = true)
    List<InfoAdminDTO> toList(List<Admin> admin);
}
