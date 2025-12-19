package demoproject.dao;

import java.util.List;

import demoproject.entities.User;

public interface UserDao {
	
	int addDetails(User register) throws Exception;
	
	User getDetails(String username) throws Exception;
	
	int updateDetails(User register) throws Exception;
	
	int deleteDetails(String username) throws Exception;
	
	User authenticate(String username, String password, String role) throws Exception;
	
	List<User> getAllDetails() throws Exception;
}
