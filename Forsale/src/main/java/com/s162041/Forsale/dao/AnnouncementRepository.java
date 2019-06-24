package com.s162041.Forsale.dao;

/**
 *  对数据库里的公告表操作
 */
import com.s162041.Forsale.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AnnouncementRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Announcement> findAll(){
		String sql="select * from Announcement";
		RowMapper<Announcement> rowMapper1=new BeanPropertyRowMapper<Announcement>(Announcement.class);
		List<Announcement> goodsList1= jdbcTemplate.query(sql, rowMapper1);
		return goodsList1;
	}
}