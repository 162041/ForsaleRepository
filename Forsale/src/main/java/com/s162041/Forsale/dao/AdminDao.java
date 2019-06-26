package com.s162041.Forsale.dao;

import com.s162041.Forsale.entity.Admin;
import com.s162041.Forsale.entity.Announcement;

import java.util.List;

/**
 * 162041班 第2组
 * 校园二手交易平台——XXX模块
 *
 * @author: 张侃
 * date: 2019-6-16
 * 主要功能说明 ……
 */
public interface AdminDao {
    int editAdmin(Admin admin);
    List<Announcement> getAnnounceList();
    int saveAnnouncement(Announcement announcement);
    int updateAnnounceById(Announcement announcement);
    Announcement getAnnounceListById(String nid);
    int deleteAnnouncement(String nid);
}
