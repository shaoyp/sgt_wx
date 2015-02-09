package com.zdaq.group.service;

import java.util.Map;

import com.zdaq.group.dao.GroupDao;

public class GroupService {
	 GroupDao dao = new GroupDao();
	public int insert(Map<String,Object> map){
		int count = dao.insert(map);
		return count;
	}
}
