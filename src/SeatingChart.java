import java.util.List;

public class SeatingChart {

	private Student[][] seats;
	
	/*  Creates a seating chart with the given number of 
	 *  rows and columns from the students in studentList.
	 *  Empty seats in the seating chart are represented by null.
	 * 
	 *  @param rows - the number of rows of seats in the classroom
	 *  @param cols - the number of columns of seats in the classroom
	 *   
	 *  Precondition: rows > 0; cols > 0;
	 *                rows * cols >= studentList.size()
	 *                
	 *  Postcondition:
	 *    - Students appear in the seating chart in the same order as 
	 *      they appear in studentList, starting at seats[0][0]
	 *    - seats is filled column by column from studentList, followed 
	 *      by any empty seats (represented by null).
	 *    - studentList is unchanged.
	 */
	public SeatingChart(List<Student> studentList, int rows, int cols) {
		
		seats = new Student[rows][cols];
		int count = 0;
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; i++) {
				if (count < studentList.size()) {
				seats [j][i] = studentList.get(count);
				count++;
			}
		}
	}
}	
	
	/*  Removes students who have more then a given number of absences 
	 *  from the seating chart, replacing those entries in the seating 
	 *  chart with null and returns the number of students removed.
	 *  
	 *  @param allowedAbsences an integer >= 0
	 *  @return number of students removed from seats
	 *  Postcondition:
	 *    - All students with allowedAbsences or fewer are in their 
	 *      original positions in seats.
	 *    - No student in seats has more than allowedAbsences absences.
	 *    - Entries without students contain null
	 */
	public int removeAbsentStudent(int allowedAbsences) {
		int numberRemoved = 0;
		
		for (int i = 0; i < seats.length; i++) { //loops row
			for (int j = 0; j < seats[i].length; i++) { //loops col
				if (seats [i][j] != null) { //check for nulls
					//checks for too many absences
				if(seats[i][j].getAbsenceCount() > allowedAbsences) {
					seats[i][j] = null; //remove student
					numberRemoved++; //up removed counter
				}
			}
		}
		}		
		return numberRemoved;
	}
	
	/*
	 * Added for illustration purposes
	 */
	public Student[][] getSeats(){
		return seats;
	}
	
}
