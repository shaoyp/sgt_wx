package com.zdaq.advise.service;

import java.util.Map;

import com.zdaq.advise.dao.AdviseDao;

public class AdviseService {
	AdviseDao dao = new AdviseDao();
	public int insert(Map<String,Object> map){
		int count = dao.insert(map);
		return count;
	}

}
