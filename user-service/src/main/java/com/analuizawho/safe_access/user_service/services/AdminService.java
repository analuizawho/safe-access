package com.analuizawho.safe_access.user_service.services;

import com.analuizawho.safe_access.user_service.dtos.CreateAdminDTO;
import com.analuizawho.safe_access.user_service.dtos.InfoAdminDTO;
import com.analuizawho.safe_access.user_service.dtos.UpdateAdminDTO;
import com.analuizawho.safe_access.user_service.mappers.AdminMapper;
import com.analuizawho.safe_access.user_service.repository.AdminRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository repository;

    private final AdminMapper mapper;

    public AdminService(AdminRepository repository, AdminMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public InfoAdminDTO createAdmin(CreateAdminDTO createDTO){
        var newAdmin = mapper.toAdmin(createDTO);

        var admin = repository.save(newAdmin);

        return mapper.toInfo(admin);
    }

    @Transactional
    public InfoAdminDTO infoAdmin(Long id){
        var admin = repository.getReferenceById(id);

        return mapper.toInfo(admin);
    }

    @Transactional
    public List<InfoAdminDTO> listAdmin(){
        var admin = repository.findAllByAdminActiveTrue();
        return mapper.toList(admin);
    }

    @Transactional
    public InfoAdminDTO updateAdmin(Long id, UpdateAdminDTO updateDTO){
        var admin = repository.getReferenceById(id);
        admin.updateAdminInfo(updateDTO);
        admin = repository.save(admin);
        return mapper.toInfo(admin);
    }

    @Transactional
    public void activateAdmin(Long id){
        var admin = repository.getReferenceById(id);
        admin.setUserActivated();
    }

    @Transactional
    public void softDeleteAdmin(Long id){
        var admin = repository.getReferenceById(id);
        admin.setUserInactivated();
    }

    @Transactional
    public void deleteAdmin(Long id){
        repository.deleteById(id);
    }

}
