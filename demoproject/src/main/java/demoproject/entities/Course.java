package demoproject.entities;

import java.io.InputStream;

public class Course {

    private int course_id;
    private String name;
    private String instructor;
    private double duration;
    private double fees;
    private String description;
    private InputStream course_image;
	
    public Course() {
		super();
	}

	public Course(int course_id, String name, String instructor, double duration, double fees, String description,
			InputStream course_image) {
		super();
		this.course_id = course_id;
		this.name = name;
		this.instructor = instructor;
		this.duration = duration;
		this.fees = fees;
		this.description = description;
		this.course_image = course_image;
	}

	public Course(String name, String instructor, double duration, double fees, String description, InputStream course_image) {
		super();
		this.name = name;
		this.instructor = instructor;
		this.duration = duration;
		this.fees = fees;
		this.description = description;
		this.course_image = course_image;
	}

	public int getCourseId() {
		return course_id;
	}

	public void setCourseId(int courseId) {
		this.course_id = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public InputStream getCourseImage() {
		return course_image;
	}

	public void setCourseImage(InputStream course_image) {
		this.course_image = course_image;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", name=" + name + ", instructor=" + instructor + ", duration="
				+ duration + ", fees=" + fees + ", description=" + description + ", course_image=" + course_image + "]";
	}


 }