package inpocker.users.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.next.IndianPockerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import inpoker.users.dao.UserDao;
import inpoker.users.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IndianPockerApplication.class)
public class UserDaoTest {
	@Autowired
	private UserDao userDao;

	@Test
	public void addUser() throws Exception {
		User expected = new User("testUser2", "test123", "a1@a.com");
		userDao.addUser(expected);
		User actual = userDao.findUserById("testUser2");
		assertEquals(expected.getUserId(), actual.getUserId());
		assertEquals(expected.getUserPassword(), actual.getUserPassword());
		assertEquals(expected.getUserEmail(), actual.getUserEmail());
	}
}