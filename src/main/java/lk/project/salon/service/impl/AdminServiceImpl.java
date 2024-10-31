package lk.project.salon.service.impl;

import lk.project.salon.dto.AdminDto;
import lk.project.salon.entity.Admin;
import lk.project.salon.repo.AdminRepo;
import lk.project.salon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminServiceImpl(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    @Override
    public Object registerAdmin(AdminDto adminDto) {
        System.out.println("Received AdminDto: " + adminDto);
        if (adminDto.getAdminName() == null) {
            throw new IllegalArgumentException("Admin name must not be null");
        }
        return adminRepo.save(new Admin(adminDto.getAdminName(), adminDto.getPassword()));
    }

}
