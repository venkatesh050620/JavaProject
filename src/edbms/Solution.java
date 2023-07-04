package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceExeception;

public interface Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Db Management System...");
		System.out.println("-------------------------------------------");
		EmployeeManagementSystem ems = new EmployeeManagementSystemImpl();
		Scanner sc =new Scanner(System.in);
		while(true) {
			System.out.println("1: Add Employee\n2: Display Employee\n3: Display All Employees\n4: Remove Employee");
			System.out.println("5: Rempove All Employees\n6: Upadate Employee\n7: Count Employees\n8: Sort Employees");
			System.out.println("9: Get Employee with Lowest Salary\n10: Get Employee with Highest Salary");
			System.out.println("11: Exit\nEnter the Choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				ems.addEmployee();
				break;
			case 2:
				ems.displayEmployee();
				break;
			case 3:
				ems.displayAllEmployee();
				break;
			case 4:
				ems.removeEmployee();
				break;
			case 5:
				ems.removeAllEmployee();
				break;
			case 6:
				ems.updateEmployee();
				break;
			case 7:
				ems.countEmployee();
				break;
			case 8:
				ems.sortEmployee();
				break;
			case 9:
				ems.getEmployeeWithLowestSalary();
				break;
			case 10:
				ems.getEmployeeWithHighestSalary();
				break;
			case 11:
				System.out.println("Thank You...!");
				System.exit(0);
			default:
				try {
					String message = "Invalid, Enter Valid Choice";
					throw new InvalidChoiceExeception(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("----------------------------------------------");
		}
	}

}
