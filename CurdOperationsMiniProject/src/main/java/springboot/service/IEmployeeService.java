package springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import springboot.model.Employee;

public interface IEmployeeService {
	public List<Employee> fetchAllEmps();
	public String registerEmp(Employee e);
	public Employee getEmployeeById(Integer id);
	public String updateEmployeeData(Employee emp);
	public String deleteEmployeeData(Integer id);
	public Page<Employee> getEmployeesDataByPage(Pageable pageable);
	
}
