package demoproject.entities;

public class Topic {
	
    private int id;
    private int course_id;
    private String title;
    private String description;
    private int order;
	
    public Topic() {
		super();
	}
	
	public Topic(int course_id, String title, String description, int order) {
		super();
		this.course_id = course_id;
		this.title = title;
		this.description = description;
		this.order = order;
	}

	public Topic(int id, int course_id, String title, String description, int order) {
		super();
		this.id = id;
		this.course_id = course_id;
		this.title = title;
		this.description = description;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return course_id;
	}

	public void setCourseId(int course_id) {
		this.course_id = course_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Topics [id=" + id + ", course_id=" + course_id + ", title=" + title + ", description=" + description
				+ ", order=" + order + "]";
	}
    
    
}
