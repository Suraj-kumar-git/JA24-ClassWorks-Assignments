package com.hexaware.weekendpractice.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "StuX2X")
public class StudentManyToMany {

	@Id
	@Column(name = "student_id")
	private int id;

	@Column(name = "student_name")
	private String name;

	@ManyToMany(cascade =CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<CourseManyToMany> courses = new HashSet<>();

	public StudentManyToMany(int id, String name, Set<CourseManyToMany> courses) {
		super();
		this.id = id;
		this.name = name;
		this.courses = courses;
	}

	public StudentManyToMany(int i, String name) {
		super();
		this.id = i;
		this.name = name;
	}
	
	public void addCourse(CourseManyToMany course) {
		this.getCourses().add(course);
	}

	public StudentManyToMany() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CourseManyToMany> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseManyToMany> courses) {
		this.courses = courses;
	}

}
