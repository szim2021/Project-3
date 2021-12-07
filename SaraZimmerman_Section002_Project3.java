package moreProjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SaraZimmerman_Section002_Project3 {
	
		/* Name: Sara Zimmerman
		   Class and Section: ITSS 3312, Section 002
		   Description: This program, the Student and Course Management System, is designed to allow users to
		   manage students and courses. Among the menu options, users can input student information, assign jobs to them, create courses, assign courses to students, etc.
		*/
	
		public static void main(String[] args) {
			
			// Declare Variables
			int numOfStudents;
			int SMSSelection;
			int mainMenuSelection;
			int CMSSelection;
			String stuFName;
			String stuLName;
			String stuLevel;
			String jobSpec;
			String partOrFull;
			int searchID;
			int j = 0;
			int y = 0;
			String course;
			String courseNum;
			
			// Create Scanner Object for user inputs
			Scanner input = new Scanner(System.in);
			
			// Create Random Object
			Random random = new Random();
						
			// Print Welcome Message to User and Prompt for input of number of students
			System.out.print("Welcome to Student and Course Management System!\n"
				+ "\n"
				+ "This system will allow you to manage students and courses. Let’s start with the number of students this system will have: ");
			numOfStudents = input.nextInt();
			
			// Create Array to hold each student
			Student[] studentObj = new Student[numOfStudents];
			
			// Create Array to hold Student Employee Objects - same amount as students declared
			StudentEmployee[] studentEmpObj = new StudentEmployee[numOfStudents];
			
			do {
			mainMenuSelection = 0;
			// Prints menu options for Student and Course Management System
			System.out.println("\n***Welcome to Student and Course Management System***\n\n"
					+ "Press ‘1’ for Student Management System (SMS)\n"
					+ "Press ‘2’ for Course Management System (CMS)\n"
					+ "Press ‘0’ to exit the system\n");
			// Try-Catch block catches an error if user does not input an integer
			try {
				mainMenuSelection = input.nextInt(); 
	    	   }
	    	   catch(InputMismatchException e) {
	    		   System.out.println("Exception occurred: Must enter an integer."); 
	    	   }
			
			// Switch Statement to select which system to enter
			switch (mainMenuSelection) {
			
			case 1:
			// Beginning of do-while loop **************
			do {
			SMSSelection = 0;
			
			// Print Main Menu for User and prompt for menu input
			System.out.println("\n***Welcome to SMS***\n"
					+ "Press ‘1’ to add a student\n"
					+ "Press ‘2’ to deactivate a student\n"
					+ "Press ‘3’ to display all students\n"
					+ "Press ‘4’ to search for a student by ID\n"
					+ "Press ‘5’ to assign on-campus job\n"
					+ "Press ‘6’ to display all students with on-campus jobs\n"
					+ "Press ‘0’ to exit SMS\n");
			// Try-Catch block catches an error if user does not input an integer
			try {
				SMSSelection = input.nextInt(); 
	    	   }
	    	   catch(InputMismatchException e) {
	    		   System.out.println("Exception occurred: Must enter an integer."); 
	    	   }
			
			// Begin Switch Statement for the user selection
			switch (SMSSelection) {
			
			// Case 1 allows users to add a new student to the management system
			case 1:
				
			// Ensure space needed to enter student details into system via loop
			if (j < studentObj.length) {
			
			// Prompt for user inputs to assign student details
			System.out.print("Enter first name: ");
			stuFName = input.next();
			System.out.print("\nEnter last name: ");
			stuLName = input.next();
			
			// Create Student object with first name and last name
			studentObj[j] = new Student(stuFName, stuLName);
			
			// Invoke setLevel to assign student level
			System.out.print("\nEnter level of the student: ");
			stuLevel = input.next();
			studentObj[j].setLevel(stuLevel);
			
			// Invoke setStudentID to assign random ID between 0 and 99
			studentObj[j].setStudentID(random.nextInt(100));
			
			// Inform users the object is created
			System.out.println("\n" + stuFName + " " + stuLName + " has been added as a " + stuLevel +  " with ID " + studentObj[j].getStudentID() + "\n");
			j++;
			
			}
			break;
			
			// Case 2 allows users to deactivate students given their ID
			case 2:
			// Prompt user input for student ID
			System.out.println("Enter the ID for the student you want to deactivate: ");
			searchID = input.nextInt();
			// Use for loop to locate student ID
			for (int x = 0; x < studentObj.length; x++) {
				if (studentObj[x] == null) continue;
				if (studentObj[x].getStudentID() == searchID) // Invoke getStudentID to access studentID variable
				{
				studentObj[x].stuDeactivate(); // Invoke stuDeactivate to deactivate the student
				}
			}
			
			break;
			
			// Case 3 allows users to print all active students info in alphabetical order
			case 3:
			for (int i = 0; i < studentObj.length; i++) {
			if (studentObj[i] == null) continue;
			studentObj[i].getStudent();
			}
			break;
			
			// Case 4 allows users to search for a student given their ID
			case 4:
			System.out.println("Enter the student ID: ");
			searchID = input.nextInt();
			for (int k = 0; k < studentObj.length; k++) {
				if (studentObj[k] == null) continue;
				if (studentObj[k].getStudentID() == searchID) {
				studentObj[k].getStudent();
				}
			}
			break;
			
			// Case 5 allows user to assign an on-campus job
			case 5:
			System.out.println("Enter student ID: ");
			searchID = input.nextInt();
			// Use for loop to locate student ID
			System.out.println("Enter job: ");
			jobSpec = input.next();
			System.out.println("Enter job type: ");
			partOrFull = input.next();
			// Use for loop to locate student ID
			for (int x = 0; x < studentObj.length; x++) {
				if (studentObj[x] == null) continue;
				if (studentObj[x].getStudentID() == searchID) // Invoke getStudentID to access studentID variable
				{
				// if found, set variables and create a new Student Employee object
				stuFName = studentObj[x].getFName();
				stuLName = studentObj[x].getLName();
					if (y < studentEmpObj.length) {
					studentEmpObj[y] = new StudentEmployee(stuFName, stuLName, partOrFull, jobSpec, searchID);
					y++;
					}
				}
			}
			
			break;
			
			// Case 6 displays all students with on-campus jobs
			case 6:
			for (int i = 0; i < studentEmpObj.length; i++) {
				if (studentEmpObj[i] == null) continue;
				studentEmpObj[i].getStudent();
				}
			break;
			}
			
			} while (SMSSelection != 0); // End of do-while loop *****************
		break;
		
		// Case 2 of the first Switch Statement - Allows user to enter Course Management System
		case 2:
		do {
		CMSSelection = 0;
		//**** Beginning of Course Management System *****
		System.out.println("\n***Welcome to CMS***\n"
				+ "Press ‘1’ to add a new course\n"
				+ "Press ‘2’ to assign student a new course\n"
				+ "Press ‘3’ display student with assigned courses\n"
				+ "Press ‘0’ to exit CMS");
		// Try-Catch block to ensure user inputs an integer
		try {
			CMSSelection = input.nextInt(); 
    	   }
    	   catch(InputMismatchException e) {
    		   System.out.println("Exception occurred: Must enter an integer."); 
    	   }
		
		switch (CMSSelection) // Beginning of the Switch Statement
		{
		
		// Allows user to create new course and add to system
		case 1:
			System.out.println("Enter course ID: ");
			courseNum = input.next();
			System.out.println("Enter course name: ");
			course = input.next();
			Course courseObj = new Course(); // Creates new course object
			courseObj.setCourse(course, courseNum); // Calls setCourse method to write creation to file
		break;
		
		// Allows user to assign course to student
		case 2:
			System.out.println("Enter student ID: ");
			searchID = input.nextInt();
			System.out.println("Enter course ID: ");
			courseNum = input.next();
			// For-Loop searches for a matching student ID from existing Student objects
			for (int x = 0; x < studentObj.length; x++) {
				if (studentObj[x] == null) continue;
				if (studentObj[x].getStudentID() == searchID) // Invoke getStudentID to access studentID variable
				{
				studentObj[x].assignCourse(courseNum);
				}
				}
			break;
			
			// Allows user to display courses student is taking
			case 3:
			Course courseObj2 = new Course();
			courseObj2.getCourse(); // Call the getCourse method to print information from text file
			
			break;
			
						}  // End of the Switch Statement
					} while (CMSSelection != 0);
			
				}
			} while (mainMenuSelection != 0);
			System.out.println("Goodbye!!!");
	} // END OF MAIN METHOD *********************************
} // END OF CLASS **********************************************************

	interface StudentInterface {
		
		public void setLevel(String level);
		public void setStudentID(int num);
		public int getStudentID();
		public void getStudent();
		public void assignCourse(String courseNumber);
		public String getFName();
		public String getLName();
	}

	class Student implements StudentInterface {
		
		// Create File object to store student reports
		File studentReport = new File("d:\\StudentReport.txt");
		
		// Create File object to store information about courses assigned to students
		File courseAssign = new File("d:\\CourseAssignment.txt");
		
		// Create PrintWriter object to write student report
		PrintWriter writer1 = null;

		// declare vars
		private String firstName;
		private String lastName;
		private String studentYear;
		private int studentID;
		private boolean status = true;
		
		// Create Class Constructor
		public Student(String fn, String ln) {
			this.firstName = fn;
			this.lastName = ln;
		}
		
		// Returns the Student First and Last Name
		public void getFullName() {
			System.out.println(firstName + lastName);
		}
		
		// Assign Student Level
		public void setLevel(String level) {
			this.studentYear = level;
		}
		
		// Assign Student ID
		public void setStudentID(int num) {
			this.studentID = num;
		}
		
		// Retrieve the Student ID
		public int getStudentID () {
			return this.studentID;
		}
		
		// Retrieve the Student first name
		public String getFName() {
			return this.firstName;
		}
		// Retrieve the Student last name
		public String getLName() {
			return this.lastName;
		}
		
		// Deactivate a Student
		public void stuDeactivate() {
			System.out.print("\n" + firstName + " " + lastName + " has been deactivated.\n");
			this.status = false;
		}
		
		// Method displays all Student information
		public void getStudent() {
		if (this.status == true) {
		System.out.println("\n\n" + firstName + " " + lastName +
			"\nID: " + studentID +
			"\nLevel: " + studentYear +
			"\nStatus: Active\n");
		// Designate studentReport as destination for text written with PrintWriter
        try {
			writer1 = new PrintWriter(studentReport);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        writer1.write("\n\n" + firstName + " " + lastName +
    			"\nID: " + studentID +
    			"\nLevel: " + studentYear +
    			"\nStatus: Active\n");                                             
        writer1.flush();
        writer1.close();
			}
		}
		
		// Method assigns courses to student and writes the assignment to the created file
		public void assignCourse(String courseNumber) {
			PrintWriter writer2 = null;      
	        try {
				writer2 = new PrintWriter("d:\\CourseAssignment.txt");
				writer2.write("\n\n" + firstName + " " + lastName +
			    		"\nID - " + studentID +
			    		"\nCourses: " + courseNumber);                                             
			    writer2.flush();
			    writer2.close();
			    System.out.println(firstName + " " + lastName + " has been assigned course " + courseNumber);
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
	}
	
	class StudentEmployee extends Student {

		// Declare vars
		private String employmentType;
		private String jobType;
		private String firstName;
		private String lastName;
		private int studentID;
		
		
		// Constructor for subclass, assigns variables given by user inputs
		public StudentEmployee(String fn, String ln, String job, String jobtime, int ID) {
			super(fn, ln);
			this.firstName = fn;
			this.lastName = ln;
			this.studentID = ID;
			this.employmentType = job;
			this.jobType = jobtime;
			System.out.println(fn + " " + ln + " has been assigned" + " " + employmentType + " " + jobType + " job");
		}

		// Displays job information for Student Employee - overridden method
		public void getStudent() {
		System.out.println("\n\n" + firstName + " " + lastName +
			"\nID - " + studentID +
			"\n" + employmentType + " " + jobType);
		}

	}
	
	interface CourseInterface {
		
	// Method creates new course
	public void setCourse(String cName, String cNum);
	
	// Method returns the name of the course
	public String getCourseName();
	
	// Method returns the name of the course
	public String getCourseID(); 
	
	// Method returns the courses taken by students
	public void getCourse();
	}
	
	
	class Course implements CourseInterface {
		String courseName;
		String courseID;
		String cNameMatch;
	    String cNumMatch;
	    
	// Create File object to hold user-created courses
	File courseFile = new File("d:\\Courses.txt");
	
	
	// Create FileWriter object to write to file
	FileWriter writer1 = null;
	
	// Method sets the course name and ID using inputs, then writes the course to a file
	public void setCourse(String cName, String cNum) {
		this.courseID = cNum;
		this.courseName = cName;
		boolean check = false;
		try {
			Scanner sc = new Scanner(courseFile); // Create Scanner Object to read the contents of file
			writer1 = new FileWriter(courseFile, true); // Initialize FileWriter with the file containing courses
			writer1.write("\n\n"); // This allows sc.nextLine() without running into errors
	        writer1.flush();
	        // While-loop will read each line and set each variable to the corresponding line
		    while (sc.hasNextLine()) {
		    	cNameMatch = sc.nextLine();
		    	cNumMatch = sc.nextLine();
		    	// If-statement will verify if the String content of the given line is the same as the user inputs
		    	if (cNum.trim().equals(cNumMatch.trim()) && cName.trim().equals(cNameMatch.trim())) {
		    		check = true;
		    		System.out.println("Course already exists.");
		    		break; // The loop will break out if the course exists
		    	}
		    }
		    // If-statement will create new course if it does not already exist. The variable "check" will still be set as false.
		    if (check != true) {
		    	writer1.write(cName + "\n" + cNum + "\n");                                      
		        writer1.flush();
		        System.out.println("Confirmation: new course " + cNum + " has been added");
		    }
		    writer1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Method displays the courses student is taking
			public void getCourse() {
				BufferedReader br = null; 
				try {
					br = new BufferedReader(new FileReader("d:\\CourseAssignment.txt")); // BufferedReader object created to read each line from text file
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				String line;
				try {
					// While-loop prints each line contained within the text file until a null is found.
					while ((line = br.readLine()) != null) {
					System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				}
	
	// Method returns course name
	public String getCourseName() {
		return courseName;
	}
	
	// Method returns course ID
	public String getCourseID() {
		return courseID;
		}
	}