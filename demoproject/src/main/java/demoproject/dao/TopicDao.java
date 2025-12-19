package demoproject.dao;

import java.util.List;

import demoproject.entities.Topic;

public interface TopicDao {
	
	int addTopic(Topic topic) throws Exception;
	
	Topic getTopic(int id) throws Exception;
	
	int updateTopic(Topic topic) throws Exception;
	
	int deleteTopic(int id) throws Exception;
	
	List<Topic> getAllTopics() throws Exception;
	
	List<Topic> getTopicsCourseWise(int courseId) throws Exception;
}
