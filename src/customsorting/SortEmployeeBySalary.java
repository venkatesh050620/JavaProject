package customsorting;

import java.util.Comparator;
import edbms.Employee;

public class SortEmployeeBySalary implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		Double x = e1.getSalary();//2.6
		Double y = e2.getSalary();//2.4
		return x.compareTo(y); //return 2.6.comapreTo(2.4); -->+1
	}
}
//e1 -> object to be inserted
//e2 -> already existing object