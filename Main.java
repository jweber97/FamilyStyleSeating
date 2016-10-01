import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		ArrayList<Student> allStuds = new ArrayList();	

		ArrayList<Student> m9Studs = new ArrayList();	
		ArrayList<Student> f9Studs = new ArrayList();	

		ArrayList<Student> m10Studs = new ArrayList();	
		ArrayList<Student> f10Studs = new ArrayList();

		ArrayList<Student> m11Studs = new ArrayList();	
		ArrayList<Student> f11Studs = new ArrayList();

		ArrayList<Student> m12Studs = new ArrayList();	
		ArrayList<Student> f12Studs = new ArrayList();


		//import students from csv with name, grade and gender
		String csvFile = "D:/MyProfile/Downloads/StudentListForJackWeber.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] student = line.split(cvsSplitBy);

				Student stud = new Student();

				stud.setName(student[1]);
				stud.setGrade(Integer.parseInt(student[3]));

				if (student[0].equals("Female")) stud.setGender('F');
				else if (student[0].equals("Male")) stud.setGender('M');

				allStuds.add(stud);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		Collections.shuffle(allStuds);

		//sort by grade and gender
		for (int i=0; i<allStuds.size(); i++){

			if (allStuds.get(i).getGender()=='M'){ 
				if (allStuds.get(i).getGrade()==9){
					m9Studs.add(allStuds.get(i));
				}
				if (allStuds.get(i).getGrade()==10){
					m10Studs.add(allStuds.get(i));
				}
				if (allStuds.get(i).getGrade()==11){
					m11Studs.add(allStuds.get(i));
				}
				if (allStuds.get(i).getGrade()==12){
					m12Studs.add(allStuds.get(i));
				}
			}
			else if(allStuds.get(i).getGender()=='F'){
				if (allStuds.get(i).getGrade()==9){
					f9Studs.add(allStuds.get(i));
				}
				if (allStuds.get(i).getGrade()==10){
					f10Studs.add(allStuds.get(i));
				}
				if (allStuds.get(i).getGrade()==11){
					f11Studs.add(allStuds.get(i));
				}
				if (allStuds.get(i).getGrade()==12){
					f12Studs.add(allStuds.get(i));
				}
			}
		}
		
		ArrayList <Student> sortedStuds = new ArrayList();
		
		sortedStuds.addAll(f9Studs);
		sortedStuds.addAll(f10Studs);
		sortedStuds.addAll(f11Studs);
		sortedStuds.addAll(f12Studs);

		sortedStuds.addAll(m9Studs);
		sortedStuds.addAll(m10Studs);
		sortedStuds.addAll(m11Studs);
		sortedStuds.addAll(m12Studs);
		
		ArrayList<Table> tables = new ArrayList();

		int numTables = Math.round(allStuds.size()/8);
		
		//create tables
		for (int i=0; i<numTables; i++){
			Table t= new Table();
			t.setNumStudsAtTable(9);
			tables.add(t);
		}
		
		Scanner scan = new Scanner(System.in);
		
		int tExtrasCount=0;
		
		System.out.println("How many teachers are bringing one extra?");
		
		int eightTables = scan.nextInt();
		
		tExtrasCount =tExtrasCount+ eightTables;
		
		for (int i=0; i<eightTables; i++){
			tables.get(i).setNumStudsAtTable(8);
		}
		
System.out.println("How many teachers are bringing 2 extras?");
		
		int sevenTables = scan.nextInt();
		
		tExtrasCount =tExtrasCount+ sevenTables;

		
		for (int i=0; i<sevenTables; i++){
			tables.get(i).setNumStudsAtTable(7);
		}
		
		//put students at tables removing them from studsAtTable after
		for (int i=0; i<9; i++){
			for (int j=0; j<tables.size();j++){
				if (sortedStuds.isEmpty()) break;
				if (tables.get(i).numStudsAtTable==tables.get(i).studsAtTable.size()){
					continue;
				}
				else {
				tables.get(j).studsAtTable.add(sortedStuds.get(0));
				sortedStuds.remove(0);
				}
			}
		}
		
		
		
		


		for (int j=0; j<numTables; j++){
			int tableNum = j+1;
			System.out.println("Table: " + tableNum);
			for (int k=0; k<8; k++){
				System.out.println(tables.get(j).getStudsAtTable().get(k).Name);
			}
		}
		
//		System.out.println("");
//		System.out.println("Remaining:");
//		for(int i=0; i<sortedStuds.size();i++){
//			System.out.println(sortedStuds.get(i).getName());
//		}
	}
}


