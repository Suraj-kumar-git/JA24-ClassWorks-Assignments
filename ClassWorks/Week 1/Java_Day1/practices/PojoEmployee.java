package practices;

public class PojoEmployee {
	private int eid;
	private String eName;
	private double salary;
	
	public PojoEmployee() {}
	
	public PojoEmployee(int eid,String eName,double salary) {
		this.eid=eid;
		this.eName=eName;
		this.salary=salary;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "PojoEmployee [eid=" + eid + ", eName=" + eName + ", salary=" + salary + "]";
	}
	
}
