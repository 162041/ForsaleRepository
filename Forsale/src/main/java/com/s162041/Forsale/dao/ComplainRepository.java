package com.s162041.Forsale.dao;

/**
 *  �����ݿ���Ķ��������
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.s162041.Forsale.entity.Complain;
import com.s162041.Forsale.entity.Goods;

import java.util.Date;
import java.util.List;


@Repository
public class ComplainRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//���Ͷ��
	public void addComplainRepository(String bid,String ccontent,String cstate){
		Date date=new Date();
		String sql= "insert into complain (bid,cdate,ccontent,cstate) value (?,?,?,?)";
//      Ͷ�ߵ����-���id-����-����-����
		jdbcTemplate.update(sql,bid,date,ccontent,cstate);
	}
	//��ѯͶ�߽��
	public List<Complain> findByBID(String BID){
		String sql="select * from complain where BID=? and Cback is not null";
		RowMapper<Complain> rowMapper2=new BeanPropertyRowMapper<Complain>(Complain.class);
		List<Complain> goodsList2= jdbcTemplate.query(sql, rowMapper2,BID);
		return goodsList2;
	}
}