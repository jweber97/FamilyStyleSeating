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

	public int getTeachExtras() {
		return teachExtras;
	}

	public void setTeachExtras(int teachExtras) {
		this.teachExtras = teachExtras;
	}

	String Teacher;
	
	int teachExtras;
}
