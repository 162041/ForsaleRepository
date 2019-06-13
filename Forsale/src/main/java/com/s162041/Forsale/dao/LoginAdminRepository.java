package com.s162041.Forsale.dao;

import com.s162041.Forsale.entity.LoginAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginAdminRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public LoginAdmin getLoginAdmin(String account, String password) {
		String sql="select * from admin where Aname=? and Apassword=?";
		RowMapper<LoginAdmin> rowMapper=new BeanPropertyRowMapper<LoginAdmin>(LoginAdmin.class);
		List<LoginAdmin> list = jdbcTemplate.query(sql, rowMapper,account,password);
		if (list != null && list.size()>0) {
			System.out.println(list.get(0).getAname());
			return list.get(0);
		}else
			return null;				
	}
	public void setLoginAdmin(String AID ,String Aname,String Atel){
		String sql= "update admin set Aname='Aname',Atel='Atel' where AID='AID'";
		jdbcTemplate.update(sql);
	}
}