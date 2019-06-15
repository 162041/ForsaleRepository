package com.s162041.Forsale.service;

import com.s162041.Forsale.dao.LoginASDao;
import com.s162041.Forsale.entity.Admin;
import com.s162041.Forsale.entity.Services;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 162041班 第2组
 * 校园二手交易平台——XXX模块
 *
 * @author: 张侃
 * date: 2019/6/11
 * 主要功能说明 ……
 */
@Service
public class LoginASService implements LoginASDao {
    @Resource
    private LoginASDao loginASDao;

    @Override
    public Admin getLoginAdmin(Admin loginAdmin){
        return loginASDao.getLoginAdmin(loginAdmin);

    }

    @Override
    public Services getLoginService(Services loginService) {
        return loginASDao.getLoginService(loginService);
    }
}
