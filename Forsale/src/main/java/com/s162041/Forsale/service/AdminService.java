package com.s162041.Forsale.service;

import javax.annotation.Resource;

import com.s162041.Forsale.entity.Admin;
import com.s162041.Forsale.entity.Announcement;
import org.springframework.stereotype.Service;

import com.s162041.Forsale.dao.AdminDao;

import java.util.List;

@Service
public class AdminService implements AdminDao{
	
	@Resource
	private AdminDao adminDao;
	@Override
	public int editAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.editAdmin(admin);
	}

	@Override
	public List<Announcement> getAnnounceList() {
		return adminDao.getAnnounceList();
	}

	@Override
	public int saveAnnouncement(Announcement announcement) {
		return adminDao.saveAnnouncement(announcement);
	}

	@Override
	public int updateAnnounceById(Announcement announcement) {
		return adminDao.updateAnnounceById(announcement);
	}

	@Override
	public Announcement getAnnounceListById(String nid) {
		return adminDao.getAnnounceListById(nid);
	}

	@Override
	public int deleteAnnouncement(String nid) {
		return adminDao.deleteAnnouncement(nid);
	}
}
