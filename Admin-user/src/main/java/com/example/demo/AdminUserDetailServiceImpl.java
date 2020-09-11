package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserDetailServiceImpl {
	
	@Autowired
	private AdminUserRepository adminUserRepository;

	
	public List<AdminUserEntity> getAdminUserDetails() {
		
		//List<AdminUserEntity> adminUserEntityList=new ArrayList<>();
		return adminUserRepository.findAll();
//		adminUserRepository.findAll().forEach(userDetail->adminUserEntityList.add(userDetail));
//		return adminUserEntityList;
	}


	public void deleteUserDetails(int id) {
		 adminUserRepository.deleteById(id);
		
	}


	public Optional<AdminUserEntity> editAdminDetails(int id) {
		
		return adminUserRepository.findById(id);
	}


	public void update(AdminUserEntity adminUser) {
		 adminUserRepository.save(adminUser);
		
	}


	public List<AdminUserEntity> filterAdminDetails(String searchKeyword) {
		if (searchKeyword != null) {
            return adminUserRepository.search(searchKeyword);
        }
		 return adminUserRepository.findAll();
    }


	public List<AdminUserEntity> filterAdminDetailsEnity(AdminUserEntity adminUserEntity) {
		if (adminUserEntity != null) {
            return adminUserRepository.searchEntity(adminUserEntity);
        }
        return adminUserRepository.findAll();
	}
	}


	


	

	


