package week3.day1;

public class Student extends Department{
	
	public void studentName() {
		
		System.out.println("Name of the Student - Nithya");
		
	}
	
	public void studentDept() {
		
		System.out.println("Department the student belongs to is CSc");
		
	}
	
	public void studentId() {
		
		System.out.println("Student ID is 53005");
		
	}

	public static void main (String[] args) {
		
		Student ObjStudent = new Student();
		ObjStudent.collegeName();
		ObjStudent.collegeCode();
		ObjStudent.collegeRank();
		ObjStudent.deptName();
		ObjStudent.studentName();
		ObjStudent.studentDept();
		ObjStudent.studentId();
	}
}
