import java.util.ArrayList;

public class Table {
	
	ArrayList <Student> studsAtTable= new ArrayList();
	
	public ArrayList<Student> getStudsAtTable() {
		return studsAtTable;
	}

	public void setStudsAtTable(ArrayList<Student> studsAtTable) {
		this.studsAtTable = studsAtTable;
	}
	

	public String getTeacher() {
		return Teacher;
	}

	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	public int getNumStudsAtTable() {
		return numStudsAtTable;
	}

	public void setNumStudsAtTable(int numStudsAtTable) {
		this.numStudsAtTable = numStudsAtTable;
	}
	String Teacher;
	
	int numStudsAtTable;
}
