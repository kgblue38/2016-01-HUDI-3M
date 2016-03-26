package inpoker.users.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
		try {
			String sql = "SELECT pid, userId, userPassword, userEmail FROM users WHERE userId = ?";
			// try catch해준 이유 - 레코드 비어있을때 익셉션 처리 안해주면, ajax통신에서 클라로 데이터 전달 안해줌, 아래링크 참고
			//http://www.mkyong.com/spring/queryforobject-throws-emptyresultdataaccessexception-when-record-not-found/ 
			RowMapper<User> rm = new RowMapper<User>() {
				@Override
				public User mapRow(ResultSet rs, int index) throws SQLException {
					return new User(rs.getInt("pid"), rs.getString("userId"), rs.getString("userPassword"),
							rs.getString("userEmail"));
				}
			};
			return jdbcTemplate.queryForObject(sql, rm, userId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
