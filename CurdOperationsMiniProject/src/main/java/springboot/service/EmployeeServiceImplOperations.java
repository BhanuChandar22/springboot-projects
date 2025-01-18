package springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import springboot.model.Employee;
import springboot.repository.IEmployeeRepo;

@Service
public class EmployeeServiceImplOperations implements IEmployeeService {

	@Autowired
	private IEmployeeRepo repo;
	
	@Override
	public List<Employee> fetchAllEmps() {
		return repo.findAll();
	}

	@Override
	public String registerEmp(Employee e) {
		Integer id = repo.save(e).getEmpno();
		return "Employee registered with id "+id;
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee emp = repo.getReferenceById(id);
		return emp;
	}

	@Override
	public String updateEmployeeData(Employee emp) {
		Integer empno = repo.save(emp).getEmpno();
		return "Employee "+empno+" is updated :)";
	}

	@Override
	public String deleteEmployeeData(Integer id) {
		repo.deleteById(id);
		return "Employee "+id+" is deleted :(";
	}

	@Override
	public Page<Employee> getEmployeesDataByPage(Pageable pageable) {
		return repo.findAll(pageable);
	}
	

}
