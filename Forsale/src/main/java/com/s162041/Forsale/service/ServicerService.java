package com.s162041.Forsale.service;

import com.s162041.Forsale.dao.ServiceDao;
import com.s162041.Forsale.entity.Services;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 162041班 第2组
 * 校园二手交易平台——XXX模块
 *
 * @author: 张侃
 * date: 2019-6-15
 * 主要功能说明 ……
 */
@Service
public class ServicerService implements ServiceDao {
    @Resource
    private ServiceDao serviceDao;
    @Override
    public List<Services> getServiceList() {
        return serviceDao.getServiceList();
    }

    @Override
    public int addService(Services services) {
        return serviceDao.addService(services);
    }

    @Override
    public int deleteServiceById(String id) {
        return serviceDao.deleteServiceById(id);
    }
}
