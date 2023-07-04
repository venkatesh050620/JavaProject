package customsorting;

import java.util.Comparator;
import edbms.Employee;

public class SortEmployeeByName implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		String x = e1.getName();//A
		String y = e2.getName();//B
		return x.compareTo(y); //return "A".comapreTo("B");
		//return e1.getName().compareTo(e2.getName());
	}
}
//e1 -> object to be inserted 
//e2 -> already existing object