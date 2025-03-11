package sbapp.service;

import java.util.List;

import jakarta.servlet.http.HttpServletResponse;
import sbapp.binding.CitizenCriteria;
import sbapp.binding.CitizenPlan;

public interface ICitizenPlanService {
	public List<CitizenPlan> getCitizenInfo(CitizenCriteria citizenCriteria);
	public void generateExcel(HttpServletResponse res) throws Exception;
	public void generatePdf(HttpServletResponse res) throws Exception;
}
