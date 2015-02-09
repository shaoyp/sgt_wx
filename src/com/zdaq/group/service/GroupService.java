package com.zdaq.group.service;

import java.util.Map;

import com.zdaq.group.dao.GroupDao;
import com.zdaq.group.model.Group;

public class GroupService {
	 GroupDao dao = new GroupDao();
	public int insert(Map<String,Object> map){
		int count = dao.insert(map);
		return count;
	}
	//根据id获取团购信息
	public Group getGroup(int id){
		Group group = dao.getGroup(id);
		return group;
	}
}
