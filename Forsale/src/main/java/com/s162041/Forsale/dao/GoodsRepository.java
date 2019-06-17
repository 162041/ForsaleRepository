package com.s162041.Forsale.dao;

import com.s162041.Forsale.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public class GoodsRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Goods findByGID(String GID) {
		String sql="select * from goods where GID=?";
		RowMapper<Goods> rowMapper1=new BeanPropertyRowMapper<Goods>(Goods.class);
		List<Goods> list = jdbcTemplate.query(sql, rowMapper1,GID);
		if (list != null && list.size()>0) {
			return list.get(0);
		}else
			return null;
	}
	public List<Goods> findByType(String Gtype){
		String sql="select * from goods where Gtype=?";
		RowMapper<Goods> rowMapper2=new BeanPropertyRowMapper<Goods>(Goods.class);
		List<Goods> goodsList2= jdbcTemplate.query(sql, rowMapper2,Gtype);
		return goodsList2;
	}
	public void addGoodsRepository(String Gname,String Gprices,String Gtype,String Gdescribe,String Gpicture,String SID){
		java.sql.Date date=new java.sql.Date(new Date().getTime());
		String sql= "insert into goods (Gdate,Gprices,SID,Gname,Gdescribe,Gpicture,Gtype) value (?,?,?,?,?,?,?)";
		//商品编号-时间-价格-卖家编号-商品名称-商品描述-商品图片-商品类型
		jdbcTemplate.update(sql,date,Gprices,SID,Gname,Gdescribe,Gpicture,Gtype);
	}
}