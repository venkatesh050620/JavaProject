package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.EmployeeNotFoundException;
import customexception.InvalidChoiceExeception;
import customsorting.SortEmployeeByAge;
import customsorting.SortEmployeeById;
import customsorting.SortEmployeeByName;
import customsorting.SortEmployeeBySalary;

public class EmployeeManagementSystemImpl implements EmployeeManagementSystem{
	Scanner sc = new Scanner(System.in);
	Map<String, Employee> db = new LinkedHashMap<String, Employee>();
	@Override
	public void addEmployee() {
		System.out.println("Enter the Employee Age:");
		int age = sc.nextInt();
		System.out.println("Enter the Employee Name:");
		String name = sc.next();
		System.out.println("Enter the Salary of Employee:");
		double salary = sc.nextDouble();
		Employee emp = new Employee(age, name, salary);
		db.put(emp.getId(), emp);
		System.out.println("Sucessfully Saved Employee Details...");
		System.out.println("Employee Id is "+emp.getId());
	}

	@Override
	public void displayEmployee() {
		System.out.println("Enter the Employee Id:");
		String id = sc.next().toUpperCase();
		if(db.containsKey(id)) {
			Employee emp = db.get(id);
			System.out.println("Id: "+emp.getId()+"\nName: "+emp.getName()+"\nAge: "+emp.getAge()+"\nSalary "+emp.getSalary());
		}
		else {
			try {
				String message = "Employee with Id "+id+" Not Found";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}


	}

	@Override
	public void displayAllEmployee() {
		if(db.size()!=0) {
			System.out.println("Employee Details are Follow...");
			System.out.println("-------------------------------");
			Set<String> keys = db.keySet();
			for(String key : keys) {
				System.out.println(db.get(key));
			}
		}
		else {
			try {
				throw new EmployeeNotFoundException("Employee Records Not Found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeEmployee() {
		System.out.println("Enter the Employee Id:");
		String id = sc.next().toUpperCase();
		if(db.containsKey(id)) {
			System.out.println("Employee Record Found!");
			db.remove(id);
			System.out.println("Employee Records with Id: "+id+" Deleted Sucessfully");
		}
		else {
			try {
				throw new EmployeeNotFoundException("Employee with Id: "+id+" Not Found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllEmployee() {
		if(db.size()!=0) {
			System.out.println("Employee Records Available: "+db.size());
			db.clear();
			System.out.println("Employee Records are Deleted Sucessfully");
			System.out.println("Employee Records Available: "+db.size());
		}
		else {
			try {
				throw new EmployeeNotFoundException("Employee Records Not Found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}


	}

	@Override
	public void updateEmployee() {
		System.out.println("Enter the Employee Id:");
		String id = sc.next().toUpperCase();
		if(db.containsKey(id)) {
			Employee emp = db.get(id);
			System.out.println("1: Update Name\n2: Update Age\n3: Update Salary\nEnter the Choice");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter The Employee Name:");
				String name = sc.next();
				emp.setName(name);
				System.out.println("Updated Sucessfully");
				break;
			case 2:
				System.out.println("Enter The Employee Age:");
				emp.setAge(sc.nextInt());
				System.out.println("Updated Sucessfully");
				break;
			case 3:
				System.out.println("Enter The Employee Salary:");
				emp.setSalary(sc.nextDouble());
				System.out.println("Updated Sucessfully");
				break;
			default:
				try {
					throw new InvalidChoiceExeception("Invalid, Enter Valid Choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new EmployeeNotFoundException("Employee with Id: "+id+" Not Found...!");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void countEmployee() {
		System.out.println("Number of Employees are "+db.size());
	}

	@Override
	public void sortEmployee() {
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for(String key: keys) {
				list.add(db.get(key));
			}
			System.out.println("1: Sort Employee with Id\n2: Sort Employee with Name\n3: Sort Employee with Age\n4: Sort Employee with Salary");
			System.out.println("Enter the Choice");
			switch(sc.nextInt()) {
			case 1:
				Collections.sort(list, new SortEmployeeById());
				display(list);
				break;
			case 2:
				Collections.sort(list, new SortEmployeeByName());
				display(list);
				break;
			case 3:
				Collections.sort(list, new SortEmployeeByAge());
				display(list);
				break;
			case 4:
				Collections.sort(list, new SortEmployeeBySalary());
				display(list);
				break;
			default:
				try {
					throw new InvalidChoiceExeception("Invalid, Enter Valid Choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}

		}
		else {
			try {
				throw new EmployeeNotFoundException("Employee Records Not Found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private static void display(List<Employee> list) {
		for(Employee e : list) {
			System.out.println(e);
		}
	}

	@Override
	public void getEmployeeWithLowestSalary() {
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for(String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(0));
		}
		else {
			try {
				String message = "No Sufficient Student Objects to Compare";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void getEmployeeWithHighestSalary() {
		if(db.size()>=2) {
			Set<String> keys = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for(String key : keys) {
				list.add(db.get(key));
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(list.size()-1));
		}
		else {
			try {
				String message = "No Sufficient Student Objects to Compare";
				throw new EmployeeNotFoundException(message);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
