package com.s162041.Forsale.dao;

import com.s162041.Forsale.entity.Services;

import java.util.List;

/**
 * 162041班 第2组
 * 校园二手交易平台——XXX模块
 *
 * @author: 张侃
 * date: 2019/6/14
 * 主要功能说明 ……
 */
public interface ServiceDao {
    List<Services> getServiceList();
    int addService(Services services);
    int deleteServiceById(String id);
}
