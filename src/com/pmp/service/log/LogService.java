package com.pmp.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmp.dao.mongodb.LogDAO;
import com.pmp.entity.log.LogEntity;

@Service
public class LogService {

	@Autowired
	private LogDAO logDao;

	public void save(LogEntity logEntity) {
		logDao.insert(logEntity);
	}
}
