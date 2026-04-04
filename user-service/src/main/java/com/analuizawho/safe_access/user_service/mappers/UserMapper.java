package com.analuizawho.safe_access.user_service.mappers;

import com.analuizawho.safe_access.user_service.dtos.InfoUserDTO;
import com.analuizawho.safe_access.user_service.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    List<InfoUserDTO> toList(List<User> user);
}
