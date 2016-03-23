package inpoker.users.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.next.IndianPokerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import inpoker.users.dao.UserDao;
import inpoker.users.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IndianPokerApplication.class)
public class UserDaoTest {
	@Autowired
	private UserDao userDao;

	@Test
	public void addUser() throws Exception {
		User expected = new User("testUserte", "test123", "a4@a.com");
		userDao.addUser(expected);
		User actual = userDao.findUserById("testUserte");
		assertEquals(expected.getUserId(), actual.getUserId());
		assertEquals(expected.getUserPassword(), actual.getUserPassword());
		assertEquals(expected.getUserEmail(), actual.getUserEmail());
	}
}