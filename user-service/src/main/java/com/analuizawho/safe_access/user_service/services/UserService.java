package com.analuizawho.safe_access.user_service.services;

import com.analuizawho.safe_access.user_service.dtos.InfoUserDTO;
import com.analuizawho.safe_access.user_service.mappers.UserMapper;
import com.analuizawho.safe_access.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public List<InfoUserDTO> listAllUsers(){
        var user = repository.findAllByUserActivateTrue();
        return mapper.toList(user);
    }
}
