package net.tinvention.training.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import net.tinvention.training.model.Customer;

@Transactional
@Repository
public class CustomerDao extends AbstractDao {

	private static final String TABLE_NAME = "customer";
	private static final String SELECT_BASE_QUERY = "SELECT * FROM " + TABLE_NAME;
	private static final String UPDATE_BASE_QUERY = "UPDATE " + TABLE_NAME;
	private static final String INSERT_BASE_QUERY = "INSERT INTO " + TABLE_NAME;
	private static final String DELETE_BASE_QUERY = "DELETE FROM " + TABLE_NAME;
	private static final String COUNT_BASE_QUERY = "SELECT count(*) FROM " + TABLE_NAME;

	private RowMapper<Customer> customerRowMapper = new BeanPropertyRowMapper<Customer>(Customer.class);

	@Transactional(readOnly = true)
	public Customer getById(final Long id) {
		Assert.notNull(id, "Id cannot be null");
		Map<String, Long> queryParams = Collections.singletonMap("id", id);
		return namedParameterJdbcTemplate.queryForObject(SELECT_BASE_QUERY + " WHERE id=:id", queryParams,
				customerRowMapper);
	}

	@Transactional(readOnly = true)
	public List<Customer> list() {
		return namedParameterJdbcTemplate.query(SELECT_BASE_QUERY, customerRowMapper);
	}

	/**
	 * 
	 * @param newCustomer
	 * @return the value of the generated ID
	 */
	public Long add(final Customer newCustomer) {
		Assert.isNull(newCustomer.getId(), "Id cannot be null");

		String sql = INSERT_BASE_QUERY + " (name, note) VALUES(:name, :note) ";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(newCustomer);
		namedParameterJdbcTemplate.update(sql, paramSource, keyHolder, new String[] { "id" });

		return new Long(keyHolder.getKey().longValue()); // keyHolder.getKey() now contains the generated key
	}

	/**
	 * it uses newValues.getId() as value to match records to be updated
	 * 
	 * @param newValues
	 * @return num of updated records
	 */
	public int updateById(final Customer newValues) {
		Assert.notNull(newValues.getId(), "Id cannot be null");

		String sql = UPDATE_BASE_QUERY + " SET name=:name, note=:note " + " WHERE id=:id";

		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(newValues);
		return namedParameterJdbcTemplate.update(sql, paramSource);
	}

	/**
	 * 
	 * @param id
	 * @return num of deleted records
	 */
	public int deleteById(final Long id) {
		Assert.notNull(id, "Id cannot be null");

		String sql = DELETE_BASE_QUERY + "  WHERE id=:id";

		Map<String, Object> queryParams = Collections.singletonMap("id", id);
		return namedParameterJdbcTemplate.update(sql, queryParams);
	}

	public int countWithLeak() throws SQLException {
		Connection conn = dataSource.getConnection();
		ResultSet res = conn.createStatement().executeQuery(COUNT_BASE_QUERY);

		// do not close the connection to simulate a leak

		return res.getInt(1);
	}

}
