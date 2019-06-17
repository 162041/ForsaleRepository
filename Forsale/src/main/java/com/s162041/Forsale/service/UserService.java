package com.s162041.Forsale.service;

import com.s162041.Forsale.dao.UserDao;
import com.s162041.Forsale.entity.Buyer;
import com.s162041.Forsale.entity.Seller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 162041班 第2组
 * 校园二手交易平台——XXX模块
 *
 * @author: 张侃
 * date: 2019/6/14
 * 主要功能说明 ……
 */
@Service
public class UserService implements UserDao {
    @Resource
    private UserDao userDao;
    @Override
    public List<Buyer> getBuyerList() {
        return userDao.getBuyerList();
    }

    @Override
    public List<Seller> getSellerList() {
        return userDao.getSellerList();
    }

    @Override
    public int deleteBuyerById(String id) {
        return userDao.deleteBuyerById(id);
    }
    @Override
    public int deleteSellerById(String id) {
        return userDao.deleteSellerById(id);
    }
}
