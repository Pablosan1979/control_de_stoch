package com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dataSource;
	
	public ConnectionFactory() {
		var pooledDatasource = new ComboPooledDataSource();
		pooledDatasource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
		pooledDatasource.setUser("root");
		pooledDatasource.setPassword("334D99b9fe01@");
		pooledDatasource.setMaxPoolSize(10);
		
		this.dataSource = pooledDatasource;
	}
	
	public Connection recuperaConexion(){		
		 try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
}
