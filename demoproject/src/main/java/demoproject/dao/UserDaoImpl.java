package demoproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demoproject.entities.User;
import demoproject.utils.CmUtils;

public class UserDaoImpl implements UserDao {
	
	    Connection getConnection() throws Exception {
		Class.forName(CmUtils.DRIVER);
		
		Connection con = DriverManager.getConnection(CmUtils.DB_URL, CmUtils.USERNAME, CmUtils.PASSWORD);
		return con;
	}

		@Override
		public int addDetails(User register) throws Exception {
			Connection con = getConnection();
			
			PreparedStatement pStmt = con.prepareStatement(CmUtils.ADD_DETAILS);
	        
	        pStmt.setString(1, register.getUsername());
	        System.out.println(register.getUsername());
	        
	        pStmt.setString(2, register.getEmail());
	        System.out.println(register.getEmail());
	        
	        pStmt.setString(3, register.getPassword());
	        System.out.println(register.getPassword());
	        
	        pStmt.setString(4, register.getConfirmpassword());
	        System.out.println(register.getConfirmpassword());
	        
	        pStmt.setString(5, register.getRole());
	        System.out.println(register.getRole());
	  
	        return pStmt.executeUpdate();
		}

		@Override
		public User getDetails(String username) throws Exception {
			Connection con = getConnection();
			PreparedStatement pStmt = con.prepareStatement(CmUtils.GET_DETAILS); 
	        pStmt.setString(1, username);
			
			ResultSet rSet =  pStmt.executeQuery();
			
			User register = null;
			
			if(rSet.next()) {
				String name = rSet.getString("username");
				String email = rSet.getString("email");
				String password = rSet.getString("password");
				String cpassword = rSet.getString("confirmpassword");
				String role = rSet.getString("role");
				
				register = new User(name, email, password, cpassword, role); 
			}
			 return register;
		}

		@Override
		public int updateDetails(User register) throws Exception {
			Connection con = getConnection();
			
			PreparedStatement pStmt = con.prepareStatement(CmUtils.UPDATE_DETAILS);
			
			pStmt.setString(1, register.getEmail());
			pStmt.setString(2, register.getPassword());
			pStmt.setString(3, register.getConfirmpassword());
			
			return pStmt.executeUpdate();
		}

		@Override
		public int deleteDetails(String username) throws Exception {
			Connection con = getConnection();
			
			PreparedStatement pStmt = con.prepareStatement(CmUtils.DELETE_DETAILS);
			
			pStmt.setString(1, username);

			return pStmt.executeUpdate();

		}

		@Override
		public List<User> getAllDetails() throws Exception {
	        Connection con = getConnection();
			
			Statement stmt = con.createStatement();
			
			ResultSet rSet = stmt.executeQuery(CmUtils.GET_ALL_DETAILS);
			
			List<User> register = new ArrayList<User>();
			
			while(rSet.next()) {
				String name = rSet.getString("username");
				String email = rSet.getString("email");
				String password = rSet.getString("password");
				String cpassword = rSet.getString("confirmpassword");
				String role = rSet.getString("role");
				
				register.add(new User(name, email, password, cpassword, role)); 
			}
			 return register;

		}

		@Override
		public User authenticate(String username, String password, String role) throws Exception {
            Connection con = getConnection();
			
			PreparedStatement pStmt = con.prepareStatement(CmUtils.AUTHENTICATE);
			
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			pStmt.setString(3, role);

			ResultSet rSet =  pStmt.executeQuery();
			
			User register = null;
			
			if(rSet.next()) {
				String email = rSet.getString("email");
				String cpassword = rSet.getString("confirmpassword");
				
				register = new User(username, email, password, cpassword, role); 
			}
			 return register;

		}

}
