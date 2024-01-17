package collections;

import java.util.Objects;

public class Student {
	private int sid;
	private String sName;
	private int marks;
	
	public Student() {}
	
	public Student(int sid, String sName, int marks) {
		super();
		this.sid = sid;
		this.sName = sName;
		this.marks = marks;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", marks=" + marks + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(sid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return sid == other.sid;
	}
	
	
}
