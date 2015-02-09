package com.zdaq.priOrder.service;

import java.util.Map;

import com.zdaq.priOrder.dao.PriOrderDao;

public class PriOrderService {
	PriOrderDao dao = new PriOrderDao();
	public int insert(Map<String,Object> map){
		int count = dao.insert(map);
		return count;
	}

}
