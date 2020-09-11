package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUserEntity, Integer>{

	@Query("SELECT admin FROM AdminUserEntity admin WHERE CONCAT(admin.userName.firstUserName, ' ', admin.userName.lastUserName, ' ', admin.AccountStatus, ' ', admin.AccessDetails, ' ', admin.userId) LIKE %?1% ")
    List<AdminUserEntity> search(String searchKeyword);

	@Query("SELECT admin FROM AdminUserEntity admin WHERE CONCAT(admin.userName.firstUserName, ' ', admin.userName.lastUserName, ' ', admin.AccountStatus, ' ', admin.AccessDetails, ' ', admin.userId) LIKE %?1%")
	List<AdminUserEntity> searchEntity(AdminUserEntity adminUserEntity);

	



	
//	@Autowired
//    private JdbcTemplate jdbcTemplate;
//
//	public List<AdminUserEntity> findAll() {
//		String sql = "SELECT * FROM ADMIN_USER";
//		 
//	    List<AdminUserEntity> adminUserList = jdbcTemplate.query(sql,
//	            BeanPropertyRowMapper.newInstance(AdminUserEntity.class));
//	 
//	    return adminUserList;
//	}

	
}
