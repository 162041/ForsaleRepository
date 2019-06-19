package com.s162041.Forsale.dao;

import com.s162041.Forsale.entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginUserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<LoginUser> rowMapper=new BeanPropertyRowMapper<LoginUser>(LoginUser.class);
	private List<LoginUser> list;
	public LoginUser getLoginUser(String account, String password) {
		String sql="select * from buyer where Bname=? and Bpassword=?";
		list = jdbcTemplate.query(sql, rowMapper,account,password);
		if (list != null && list.size()>0) {
			System.out.println("lsit为"+list.get(0).getBname());
			return list.get(0);
		}else
			return null;				
	}
	public void setLoginUser(String BID ,String Bname,String Btel,String Pstate){
		String sql= "update buyer set Bname=?,Btel=? where BID=?";
		jdbcTemplate.update(sql,Bname,Btel,BID);
		sql= "update address set Pstate=? where BID=?";
		jdbcTemplate.update(sql,Pstate,BID);
	}
}