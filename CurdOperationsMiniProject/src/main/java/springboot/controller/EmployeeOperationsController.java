package springboot.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springboot.model.Employee;
import springboot.service.IEmployeeService;

@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeService ser;
	
	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}
	
	@GetMapping("/report")
	public String getReportPage(Map<String,Object> map) {
		List<Employee> empdata = ser.fetchAllEmps();
		map.put("employees", empdata);
		return "emp_report";
	}
	
	@GetMapping("/register")
	public String getRegisterPage(@ModelAttribute("emp") Employee e) {
		return "emp_register";
	}
	@PostMapping("/register")
	public String registeEmployee(@ModelAttribute("emp") Employee e,RedirectAttributes ra)
	{
		String msg = ser.registerEmp(e);
		ra.addFlashAttribute("empMsg", msg);
		return "redirect:report";
	}
	@GetMapping("/edit")
	public String editEmployee(@ModelAttribute("employee") Employee e,Map<String, Object> map,@RequestParam(name = "eno") Integer empno)
	{
		System.out.println(empno);
		Employee empdata = ser.getEmployeeById(empno);
		BeanUtils.copyProperties(empdata, e);
		map.put("empdata", empdata);
		return "emp_edit";
	}
	@PostMapping("/edit")
	public String processEditEmployee(RedirectAttributes ra,@ModelAttribute("employee") Employee e)
	{
		String msg = ser.updateEmployeeData(e);
		ra.addFlashAttribute("empMsg", msg);
		return "redirect:report";
	}
	@GetMapping("/delete")
	public String processDeleteEmployee(RedirectAttributes ra,@RequestParam Integer eno) {
		String msg = ser.deleteEmployeeData(eno);
		ra.addFlashAttribute("empMsg", msg);
		return "redirect:report";
	} 
	@GetMapping("/reportByPage")
	public String showEmpsReportByPage(@PageableDefault(page = 0,size = 4) Pageable pageable, Map<String, Object> map) {
		Page<Employee> employeesDataByPage = ser.getEmployeesDataByPage(pageable);
		map.put("empsData", employeesDataByPage);		
		return "emp_report_bypage";
	}
	
}
