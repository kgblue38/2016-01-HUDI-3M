package inpoker.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import inpoker.user.model.User;
import inpoker.user.model.UserNotFoundException;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void addUser(User user) {
		String sql = "INSERT INTO users (userId, userPassword, userEmail) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, user.getUserId(), user.getUserPassword(), user.getUserEmail());
	}

	public User findUserById(String userId) throws UserNotFoundException {
		try {
			String sql = "SELECT pid, userId, userPassword, userEmail FROM users WHERE userId = ?";
			RowMapper<User> rm = new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet rs, int index) throws SQLException {
					return new User(rs.getInt("pid"), rs.getString("userId"), rs.getString("userPassword"),
							rs.getString("userEmail"));
				}
			};
			return jdbcTemplate.queryForObject(sql, rm, userId);
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException();
		}
	}

	public void updateUser(String userPassword, User user) throws UserNotFoundException {
		try {
			String sql = "UPDATE users SET userPassword = ? WHERE userId = ?";
			jdbcTemplate.update(sql, userPassword, user.getUserId());
		} catch (EmptyResultDataAccessException e) {
			throw new UserNotFoundException();
		}
	}
}
