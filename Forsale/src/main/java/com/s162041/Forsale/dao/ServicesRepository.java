package com.s162041.Forsale.dao;
/**
 *  对数据库里的买家表操作
 */
import com.s162041.Forsale.entity.Buyer;
import com.s162041.Forsale.entity.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServicesRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Services> rowMapper=new BeanPropertyRowMapper<Services>(Services.class);
	private List<Services> list;
	//查询用户
	public Services findNameByKID(String KID) {
		String sql="select * from service where KID=?";
		list = jdbcTemplate.query(sql, rowMapper,KID);
		if (list != null && list.size()>0) {
			return list.get(0);
		}else
			return null;				
	}
}