package com.s162041.Forsale.dao;

import com.s162041.Forsale.entity.Admin;
import com.s162041.Forsale.entity.Services;

/**
 * 162041班 第2组
 * 校园二手交易平台——后台登录模块
 *
 * @author: 张侃
 * date: 2019/6/2
 * 主要功能说明 管理员登陆DAO层
 */
public interface LoginASDao {
    Admin getLoginAdmin(Admin loginAdmin);
    Services getLoginService(Services loginService);
}
