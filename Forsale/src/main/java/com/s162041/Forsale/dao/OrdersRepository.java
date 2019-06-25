package com.s162041.Forsale.dao;

/**
 *  对数据库里的订单表操作
 */
import com.s162041.Forsale.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;


@Repository
public class OrdersRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	//添加订单
	public void addOrdersRepository(String ostate,long gid,String gprices,String pstate,String sid,String bid,String gname){
		java.sql.Date date=new java.sql.Date(new Date().getTime());
		String sql= "insert into orders (OID,Ostate,GID,Gprices,Pstate,SID,BID,Odate,Gname) value (?,?,?,?,?,?,?,?,?)";
//      订单编号-订单状态-商品编号-商品价格-地址-卖家编号-买家编号-订单日期-商品名称
		jdbcTemplate.update(sql, ((int)(Math.random()*999999))+"",ostate,gid,gprices,pstate,sid,bid,date,gname);
	}
	//通过买家编号查询
	public List<Order> findOrdersByBID(String BID){
		String sql="select * from orders where BID=?";
		RowMapper<Order> rowMapper1=new BeanPropertyRowMapper<Order>(Order.class);
		List<Order> goodsList1= jdbcTemplate.query(sql, rowMapper1,BID);
		return goodsList1;
	}
	//查询买家已购买的商品
	public List<Order> findOrdersByOstateAndBID(String ostate,String sid){
		String sql="select * from orders where ostate=? and sid=?";
		RowMapper<Order> rowMapper2=new BeanPropertyRowMapper<Order>(Order.class);
		List<Order> goodsList2= jdbcTemplate.query(sql, rowMapper2,ostate,sid);
		return goodsList2;
	}
}