package inpoker.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import inpoker.users.model.User;

@Repository
public class UserDao {
	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	public void addUser(User user) {
		String sql = "INSERT INTO users (userId, userPassword, userEmail) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, user.getUserId(), user.getUserPassword(), user.getUserEmail());
	}

	public User findUserById(String userId) {
		String sql = "SELECT pid, userId, userPassword, userEmail FROM users WHERE userId = ?";

		// TODO 람다식 써서 표현하기 functional interface
		
		RowMapper<User> rm = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int index) throws SQLException {
				return new User(rs.getInt("pid"), rs.getString("userId"), rs.getString("userPassword"),
						rs.getString("userEmail"));
			}
		};
		return jdbcTemplate.queryForObject(sql, rm, userId);
	}
}
