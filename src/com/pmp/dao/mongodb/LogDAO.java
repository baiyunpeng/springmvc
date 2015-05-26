package com.pmp.dao.mongodb;

import org.springframework.stereotype.Repository;

import com.pmp.entity.log.LogEntity;

@Repository
public class LogDAO extends MongoBaseDAO<LogEntity, String>{

}
