package com.s162041.Forsale.dao;


import com.s162041.Forsale.entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Repository
public class OrdersRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addOrdersRepository(String ostate,String gid,String gprices,String pstate,String sid,String bid,String gname){
		java.sql.Date date=new java.sql.Date(new Date().getTime());
		String sql= "insert into orders (OID,Ostate,GID,Gprices,Pstate,SID,BID,Odate,Gname) value (?,?,?,?,?,?,?,?,?)";
//      订单编号-订单状态-商品编号-商品价格-地址-卖家编号-买家编号-订单日期-商品名称
		jdbcTemplate.update(sql, ((int)(Math.random()*999999))+"",ostate,gid,gprices,pstate,sid,bid,date,gname);
	}

	public List<Orders> findByBID(String BID){
		String sql="select * from orders where BID=?";
		RowMapper<Orders> rowMapper1=new BeanPropertyRowMapper<Orders>(Orders.class);
		List<Orders> goodsList1= jdbcTemplate.query(sql, rowMapper1,BID);
		return goodsList1;
	}
}