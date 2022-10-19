import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		//create student list
		String[][] data = {{"Karen", "3"},
						   {"Liz", "1"},
						   {"Paul", "4"},
						   {"Lester", "1"},
						   {"Henry", "5"},
						   {"Renee", "9"},
						   {"Glen", "2"},
						   {"Fran", "6"},
						   {"David", "1"},
						   {"Danny", "3"},
						   };
		List<Student> students = new ArrayList<Student>();
		for (int i = 0; i < data.length; i++) {
			students.add(new Student(data[i][0], 
									 Integer.valueOf(data[i][1])
									 ));
		}
		
		
		//create SeatingChart object
		SeatingChart chart = new SeatingChart(students, 3, 4);
		
		//print original chart
		printChart(chart);
		
		
		//remove students with too many absences
		int numRemoved = chart.removeAbsentStudent(4);
		System.out.println("Number Removed = " + numRemoved + "\n");
		
		//print new chart
		printChart(chart);
		
	}
	
	
	public static void printChart(SeatingChart chart) {
		Student[][] seatingChart = chart.getSeats();
		int i = 0;
		
		//print column number and line
		System.out.print("   | ");
		for (int j = 0; j < seatingChart[0].length; j++) {
			System.out.printf("%6d     |", j);
		}
		System.out.print("\n-----");
		for (int j = 0; j < seatingChart[0].length; j++) {
			System.out.print("------------");
		}
		System.out.println();
		
		
		for (Student[] row : seatingChart){
			
			System.out.printf("%2d | ", i); //print row number
			for (Student student : row) {
				if (student != null) {
					System.out.printf("%8s%2d |", student.getName(), student.getAbsenceCount());
				}
				else {
					System.out.print("    null   |");
				}
				
			}
			System.out.println();
			i++;
		}
		
		System.out.println();
		
	}
	
	
	
	
}
