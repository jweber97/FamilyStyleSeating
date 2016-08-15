import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
		String csvFile = "/Users/Jack/Desktop/StudentListForJackWeber.csv";
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

		//create tables

		ArrayList<Table> tables = new ArrayList();

		int numTables = Math.round(allStuds.size()/8);
		int m9PosKeeper =0;
		int m10PosKeeper=0;
		int m11PosKeeper =0;
		int m12PosKeeper=0;

		ArrayList<Student> studsAtATable = new ArrayList();

		for (int i=0; i<numTables; i++){
			Table newTable = new Table();

			if (m9Studs.size()>m9PosKeeper){
				newTable.studsAtTable.add(m9Studs.get(m9PosKeeper++));
				studsAtATable.add(m9Studs.get(m9PosKeeper-1));
			}
			else if (m9Studs.size()<=m9PosKeeper){
				if (m10Studs.size()>m10PosKeeper){
					newTable.studsAtTable.add(m10Studs.get(m10PosKeeper++));
					studsAtATable.add(m10Studs.get(m10PosKeeper-1));

				}
				else if (m10Studs.size()<=m10PosKeeper){
					if (m11Studs.size()>m11PosKeeper){
						newTable.studsAtTable.add(m11Studs.get(m11PosKeeper++));
						studsAtATable.add(m11Studs.get(m11PosKeeper-1));

					}
					else if (m11Studs.size()<=m11PosKeeper){
						if (m12Studs.size()>m12PosKeeper){
							newTable.studsAtTable.add(m12Studs.get(m12PosKeeper++));
							studsAtATable.add(m12Studs.get(m12PosKeeper-1));
						}

					}
				}
			}
			if (m10Studs.size()>m10PosKeeper){
				newTable.studsAtTable.add(m10Studs.get(m10PosKeeper++));
				studsAtATable.add(m10Studs.get(m10PosKeeper-1));
			}
			else if (m10Studs.size()<=m10PosKeeper){
				if (m11Studs.size()>m11PosKeeper){
					newTable.studsAtTable.add(m11Studs.get(m11PosKeeper++));
					studsAtATable.add(m11Studs.get(m11PosKeeper-1));

				}
				else if (m11Studs.size()<=m11PosKeeper){
					if (m12Studs.size()>m12PosKeeper){
						newTable.studsAtTable.add(m12Studs.get(m12PosKeeper++));
						studsAtATable.add(m12Studs.get(m12PosKeeper-1));

					}
				}
			}
			if (m11Studs.size()>m11PosKeeper){
				newTable.studsAtTable.add(m11Studs.get(m11PosKeeper++));
				studsAtATable.add(m11Studs.get(m11PosKeeper-1));
			}
			else if (m11Studs.size()<=m11PosKeeper){
				if (m12Studs.size()>m12PosKeeper){
					newTable.studsAtTable.add(m12Studs.get(m12PosKeeper++));
					studsAtATable.add(m12Studs.get(m12PosKeeper-1));

				}
			}
			if (m12Studs.size()>m12PosKeeper){
				newTable.studsAtTable.add(m12Studs.get(m12PosKeeper++));
				studsAtATable.add(m12Studs.get(m12PosKeeper-1));

			}

			///////girls////////
			if (f9Studs.size()>i){
				newTable.studsAtTable.add(f9Studs.get(i));
				studsAtATable.add(f9Studs.get(i));
			}

			if (f10Studs.size()>i){
				newTable.studsAtTable.add(f10Studs.get(i));
				studsAtATable.add(f10Studs.get(i));
			}

			if (f11Studs.size()>i){
				newTable.studsAtTable.add(f11Studs.get(i));
				studsAtATable.add(f11Studs.get(i));
			}

			if (f12Studs.size()>i){
				newTable.studsAtTable.add(f12Studs.get(i));
				studsAtATable.add(f12Studs.get(i));
			}
			
			tables.add(newTable);
		}

		ArrayList<Student> remainingGirls = new ArrayList();
		
		remainingGirls.addAll(f9Studs);
		remainingGirls.addAll(f10Studs);
		remainingGirls.addAll(f11Studs);
		remainingGirls.addAll(f12Studs);
		
		remainingGirls.removeAll(studsAtATable);
		
ArrayList<Student> remainingBoys = new ArrayList();
		
		remainingBoys.addAll(m9Studs);
		remainingBoys.addAll(m10Studs);
		remainingBoys.addAll(m11Studs);
		remainingBoys.addAll(m12Studs);
		
		remainingBoys.removeAll(studsAtATable);
		
		
		for (int i=0; i<numTables; i++){
			while (tables.get(i).studsAtTable.size()<8){
				if (remainingGirls.size()>0){
				tables.get(i).studsAtTable.add(remainingGirls.get(0));
				remainingGirls.remove(0);
				}
				else if (remainingBoys.size()>0){
					tables.get(i).studsAtTable.add(remainingBoys.get(0));
					remainingBoys.remove(0);
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
		System.out.println("");
		System.out.println("Students Remaining: ");
		for (int i1=0; i1<remainingBoys.size(); i1++){
			System.out.println(remainingBoys.get(i1).getName());
		}
	}
}


