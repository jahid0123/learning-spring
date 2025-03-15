package com.jmjbrothers.employee_crud.config;

import java.time.Duration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class AppConfig {

	// we use appach common dbcp for connection pulling

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/ORCLPDB");
		dataSource.setUsername("orclpdbuser");
		dataSource.setPassword("isdb62");
		dataSource.setInitialSize(5); // initial connection in the pool
		dataSource.setMaxTotal(20); // maximum number of active connections
		dataSource.setMaxIdle(10); // maximum idle connections
		dataSource.setMinIdle(5); // minimum idle connections
		dataSource.setMaxWait(Duration.ofMillis(10000));
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource) {

		return new JdbcTemplate(datasource);
	}

	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {

		return new DataSourceTransactionManager(dataSource);
	}

}
