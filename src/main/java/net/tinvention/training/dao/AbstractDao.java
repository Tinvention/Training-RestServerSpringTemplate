package net.tinvention.training.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractDao {
	
	protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	protected DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	    this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

}
