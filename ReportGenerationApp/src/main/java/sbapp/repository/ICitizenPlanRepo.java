package sbapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sbapp.binding.CitizenPlan;

public interface ICitizenPlanRepo extends JpaRepository<CitizenPlan, Integer> {
	@Query(value = "SELECT DISTINCT planName from CitizenPlan")
	public List<String> getPlanNames();
		
	@Query(value = "SELECT DISTINCT planStatus from CitizenPlan")
	public List<String> getPlanStatus();
}
