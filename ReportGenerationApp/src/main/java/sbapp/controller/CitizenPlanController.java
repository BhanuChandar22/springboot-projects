package sbapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletResponse;
import sbapp.binding.CitizenCriteria;
import sbapp.binding.CitizenPlan;
import sbapp.repository.ICitizenPlanRepo;
import sbapp.service.ICitizenPlanService;

@Controller
public class CitizenPlanController {
	
	@Autowired
	private ICitizenPlanService serv;
	
	@Autowired
	private ICitizenPlanRepo repo;
	
	@GetMapping("/")
	public String loadReportPage(@ModelAttribute("report")CitizenPlan obj) {
		return "index";
	} 
	
	@PostMapping("/")
	public String getRecords(@ModelAttribute("report")CitizenCriteria obj, Map<String, Object> map) {
		List<CitizenPlan> records = serv.getCitizenInfo(obj);
		map.put("citizens", records);
		return "index";
	}
	
	@GetMapping("/excel")
	public void downloadExcel(HttpServletResponse resp) throws Exception
	{
		resp.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.xls";
		resp.addHeader(headerKey, headerValue);
		serv.generateExcel(resp);
	}
	@GetMapping("/pdf")
	public void downloadPdf(HttpServletResponse resp) throws Exception
	{
		resp.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment;filename=data.pdf";
		resp.addHeader(headerKey, headerValue);
		serv.generatePdf(resp);
	}
	
	
	@ModelAttribute("names")
	public List<String> getPlanNames(){
		List<String> planNames = repo.getPlanNames();
		planNames.add(0, "--select--");
		return planNames;
	}
	@ModelAttribute("status")
	public List<String> getPlanstatus(){
		List<String> planStatus = repo.getPlanStatus();
		planStatus.add(0, "--select--");
		return planStatus;
	}
}

