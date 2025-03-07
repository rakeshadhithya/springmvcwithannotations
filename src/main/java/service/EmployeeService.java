package service;

import java.util.List;

import entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	Employee findById(Integer id);
	Integer save(String name, String department, String salary);
	Employee update(Integer id, String name, String department, String salary);
	void delete(Integer id);
}
