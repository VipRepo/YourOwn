package com.vip.inventory.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("com.vip.inventory.repository")
public class MongoConfig extends AbstractMongoConfiguration implements InitializingBean{
	
//	@Value("${db.mongo.host}")
	private String host= "127.0.0.1";
	
//	@Value("${db.mongo.port}")
	private String port = "27017";
	
	@Value("${db.mongo.db.name}")
	private String dbName;
	
	
	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient(host, Integer.valueOf(port.trim()));
	}
	
	@Override
	protected String getMappingBasePackage() {
		return "com.vip.inventory.repository";
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("***DB Details***");
		System.out.println("Host: "+host);
		System.out.println("Port: "+port);
		
	}

}
