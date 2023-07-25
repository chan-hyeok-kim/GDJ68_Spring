package com.iu.main;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DBConnectionTest extends Mytest{

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void getConnectionTest() throws Exception{
		Connection con = dataSource.getConnection();
		
		assertNotNull(con);
		
	}
}
