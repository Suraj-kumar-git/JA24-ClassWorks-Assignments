package com.hexaware.weekendpractice.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courseX2X")
public class CourseManyToMany {
	@Id
	@Column(name = "course_id")
	private int courseId;
	private String courseName;
	@Column(name = "duration")
	private int courseDuration;

	@ManyToMany(mappedBy="courses")
	private Set<StudentManyToMany> students = new HashSet<>();
	
	public void addStudent(StudentManyToMany student) {
		this.getStudents().add(student);
	}
	public CourseManyToMany() {
		super();
	}

	public CourseManyToMany(int courseId, String courseName, int courseDuration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}

	public int getCourseId() {
		return courseId;
	}

	public Set<StudentManyToMany> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentManyToMany> students) {
		this.students = students;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	@Override
	public String toString() {
		return "CourseManyToMany [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration="
				+ courseDuration + "]";
	}

}
