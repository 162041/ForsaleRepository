package com.s162041.Forsale.dao;
/**
 *  �����ݿ������ұ����
 */
import com.s162041.Forsale.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuyerRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Buyer> rowMapper=new BeanPropertyRowMapper<Buyer>(Buyer.class);
	private List<Buyer> list;
	//��ѯ�û�
	public Buyer getLoginUser(String account, String password) {
		String sql="select * from buyer where Bname=? and Bpassword=md5(?)";
		list = jdbcTemplate.query(sql, rowMapper,account,password);
		if (list != null && list.size()>0) {
			System.out.println("lsitΪ"+list.get(0).getBname());
			return list.get(0);
		}else
			return null;				
	}
	//�޸��û�
	public void setLoginUser(String BID ,String Bname,String Btel,String Pstate){
		String sql= "update buyer set Bname=?,Btel=? where BID=?";
		jdbcTemplate.update(sql,Bname,Btel,BID);
		sql= "update address set Pstate=? where BID=?";
		jdbcTemplate.update(sql,Pstate,BID);
	}
	//����û�
	public void addLoginUser(String BID,String Bname,String Bpassword,String Btel){
		String sql= "insert into buyer (BID,Bname,Bpassword,Btel) value (?,?,md5(?),?)";
		jdbcTemplate.update(sql,BID,Bname,Bpassword,Btel);
	}
}