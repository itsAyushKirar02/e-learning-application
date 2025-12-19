package demoproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demoproject.entities.Topic;
import demoproject.utils.CmUtils;

public class TopicDaoImpl implements TopicDao {
	
	Connection getConnection() throws Exception {
		Class.forName(CmUtils.DRIVER);
		
		Connection con = DriverManager.getConnection(CmUtils.DB_URL, CmUtils.USERNAME, CmUtils.PASSWORD);
		return con;
	}

	@Override
	public int addTopic(Topic topic) throws Exception {
		System.out.println(topic);   
		
		
		Connection con = getConnection();
		
		PreparedStatement pStmt = con.prepareStatement(CmUtils.ADD_TOPIC);
        
		 pStmt.setInt(1, topic.getCourseId());
	     System.out.println(topic.getCourseId());
		
		pStmt.setString(2, topic.getTitle());
        System.out.println(topic.getTitle());
        
        pStmt.setString(3, topic.getDescription());
        System.out.println(topic.getDescription());
        
        pStmt.setInt(4, topic.getOrder());
        System.out.println(topic.getOrder());
  
        return pStmt.executeUpdate();
	}

//	 @Override
	 public Topic getTopic(int id) throws Exception {
		Connection con = getConnection();
		PreparedStatement pStmt = con.prepareStatement(CmUtils.GET_TOPIC); 
        pStmt.setInt(1, id);
		
		ResultSet rSet =  pStmt.executeQuery();
		
		Topic topic = null;
		
		if(rSet.next()) {
			int cid = rSet.getInt("course_id");
			String title = rSet.getString("title");
			String description = rSet.getString("description");
			int order = rSet.getInt("order");
			
			topic = new Topic(cid, title, description, order); 
		}
		 return topic;
	} 

	@Override
	public int updateTopic(Topic topic) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement pStmt = con.prepareStatement(CmUtils.UPDATE_TOPIC);
		
		pStmt.setInt(1, topic.getCourseId());
		pStmt.setString(2, topic.getTitle());
		pStmt.setString(3, topic.getDescription());
		pStmt.setInt(4, topic.getOrder());
		
		return pStmt.executeUpdate();
	}

	@Override
	public int deleteTopic(int id) throws Exception {
		
		Connection con = getConnection();
		
		PreparedStatement pStmt = con.prepareStatement(CmUtils.DELETE_TOPIC);
		
		pStmt.setInt(1, id);

		return pStmt.executeUpdate();
	}
	
	@Override
	public List<Topic> getAllTopics() throws Exception {
		
        Connection con = getConnection();
		
		Statement stmt = con.createStatement();
		
		ResultSet rSet = stmt.executeQuery(CmUtils.GET_ALL_TOPICS);
		
		List<Topic> topic = new ArrayList<Topic>();
		
		while(rSet.next()) {
			int id = rSet.getInt("id");
			int cid = rSet.getInt("course_id");
			String title = rSet.getString("title");
		    String description = rSet.getString("description");
			int order = rSet.getInt("order");
			
			topic.add(new Topic(id, cid, title, description, order));
		}
		return topic;
	}

	@Override
	public List<Topic> getTopicsCourseWise(int courseId) throws Exception {
		Connection con = getConnection();
		
		PreparedStatement stmt = con.prepareStatement(CmUtils.GET_COURSEWISE_TOPICS);
		stmt.setInt(1, courseId);
		
		ResultSet rSet = stmt.executeQuery();
		
		List<Topic> topic = new ArrayList<Topic>();
		
		while(rSet.next()) {
			int id = rSet.getInt("id");
			String title = rSet.getString("title");
		    String description = rSet.getString("description");
			int order = rSet.getInt("order");
			
			topic.add(new Topic(id, title, description, order));
		}
		return topic;
	}
}


