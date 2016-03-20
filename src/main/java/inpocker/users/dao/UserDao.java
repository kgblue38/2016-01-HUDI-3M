package inpocker.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import core.jdbc.JdbcTemplate;
import core.jdbc.RowMapper;
import inpocker.users.model.User;

public class UserDao {
	public void addUser(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "INSERT INTO users VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, user.getUserId(), user.getUserPassword(), user.getUserEmail());
	}
	
	public User findUserById(String userId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		String sql = "SELECT userId, userPassword, userEmail FROM users WHERE userId = ?";
		
		// TODO 람다식 써서 표현하기 functional interface
		RowMapper<User> rm = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs) throws SQLException {
				return new User(rs.getInt("pid"),
						rs.getString("userId"),
						rs.getString("userPassword"),
						rs.getString("userEmail"));
			}
		};
		return jdbcTemplate.queryForObject(sql, rm, userId);
	}
}
