package com.s162041.Forsale.dao;
/**
 *  �����ݿ�������ұ����
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class SellerRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	//���������Ϣ
	public void addSeller(String SID,String Sname,String Spassword,String Stel){
		String sql= "insert into seller (SID,Sname,Spassword,Stel) value (?,?,md5(?),?)";
		jdbcTemplate.update(sql,SID,Sname,Spassword,Stel);
	}
}