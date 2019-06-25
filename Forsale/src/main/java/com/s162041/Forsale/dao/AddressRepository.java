package com.s162041.Forsale.dao;
/**
 *  �����ݿ���ĵ�ַ�����
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.s162041.Forsale.entity.Address;

import java.util.List;

@Repository
public class AddressRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Address> rowMapper=new BeanPropertyRowMapper<Address>(Address.class);
	private List<Address> list;

	//��ӵ�ַ
	public void addAddress(String bid,String pstate){
		String sql= "insert into address (pid,bid,pstate) value (?,?,?)";
		jdbcTemplate.update(sql,((int)(Math.random()*999999))+"",bid,pstate);
	}
	//��ѯ��ַ
	public Address getAddress(String bid) {
		String sql="select * from address where bid=?";
		list = jdbcTemplate.query(sql, rowMapper,bid);
		if (list != null && list.size()>0) {
			return list.get(0);
		}else
			return null;				
	}
	//�޸ĵ�ַ
	public void setAddress(String bid,String pstate){
		String sql= "update address set pstate=? where bid=?";
		jdbcTemplate.update(sql,pstate,bid);
	}
}