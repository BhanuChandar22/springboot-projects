package sbapp.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import sbapp.repository.ICitizenPlanRepo;

//@Component
public class DataLoaderRunner implements CommandLineRunner {

	@SuppressWarnings("unused")
	@Autowired
	private ICitizenPlanRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		/*repo.saveAll( List.of(
				new CitizenPlan("John Doe", "john.doe@example.com", "Male", 1234567890L, LocalDate.of(2025, 01, 01), LocalDate.of(2025,12,31), 111223333L, "Cash", "Approved"),
				new CitizenPlan("Jane Smith", "jane.smith@example.com", "Fe-Male", 9876543210l, LocalDate.parse("2025-01-01") , LocalDate.parse("2025-12-31"), 222334444l, "Cash", "Denied"),
				new CitizenPlan("Alice Brown", "alice.brown@example.com", "Fe-Male", 5551239876l, LocalDate.parse("2025-02-01") , LocalDate.parse("2025-11-30"), 333445555l, "Cash", "Terminated"),
				new CitizenPlan("Ethan Scott", "ethan.scott@example.com", "Male", 1112223334l, LocalDate.parse("2025-06-01"), LocalDate.parse("2025-12-31"), 333445678l, "Cash", "Approved"),
				new CitizenPlan("Grace Hill", "grace.hill@example.com", "Fe-Male", 9874563210l, LocalDate.parse("2025-01-10"), LocalDate.parse("2025-09-15"), 222335567l, "Cash", "Terminated"),
				
				new CitizenPlan("Michael Johnson", "michael.johnson@example.com", "Male", 4449871234l, LocalDate.parse("2025-03-01"), LocalDate.parse("2025-08-31"), 444556666l, "Food", "Approved"),
				new CitizenPlan("Emily Davis", "emily.davis@example.com", "Fe-Male", 3216549870l, LocalDate.parse("2025-04-01"), LocalDate.parse("2025-12-31"), 555667777l, "Food", "Denied"),
				new CitizenPlan("Robert Wilson", "robert.wilson@example.com", "Male", 9998887776l, LocalDate.parse("2025-05-01"), LocalDate.parse("2025-10-31"), 666778888l, "Food", "Terminated"),
				new CitizenPlan("Noah Adams", "noah.adams@example.com", "Male", 1237894560l, LocalDate.parse("2025-02-20"), LocalDate.parse("2025-07-25"), 444556678l, "Food", "Approved"),
				new CitizenPlan("Lily Carter", "lily.carter@example.com", "Fe-Male", 8765432190l, LocalDate.parse("2025-05-15"), LocalDate.parse("2025-11-10"), 555667789l, "Food", "Terminated"),
				
				new CitizenPlan("Chris Martin", "chris.martin@example.com", "Male", 8889997770l, LocalDate.parse("2025-06-01"), LocalDate.parse("2025-09-30"), 777889999l, "Medical", "Approved"),
				new CitizenPlan("Sophia Taylor", "sophia.taylor@example.com", "Fe-Male", 6547893210l, LocalDate.parse("2025-07-01"), LocalDate.parse("2025-12-31"), 888991111l, "Medical", "Denied"),
				new CitizenPlan("David Anderson", "david.anderson@example.com", "Male", 1122334455l, LocalDate.parse("2025-01-15"), LocalDate.parse("2025-07-15"), 999002222l, "Medical", "Terminated"),
				new CitizenPlan("Benjamin Evans", "ben.evans@example.com", "Male", 7654321987l, LocalDate.parse("2025-03-01"), LocalDate.parse("2025-09-01"), 666778899l, "Medical", "Approved"),
				new CitizenPlan("Emma Wright", "emma.wright@example.com", "Fe-Male", 2345678901l, LocalDate.parse("2025-07-01"), LocalDate.parse("2025-12-20"), 777889900l, "Medical", "Denied"),
				
				new CitizenPlan("Olivia Moore", "olivia.moore@example.com", "Fe-Male", 4433221100l, LocalDate.parse("2025-03-15"), LocalDate.parse("2025-10-15"), 000113333l, "Employment", "Approved"),
				new CitizenPlan("James White", "james.white@example.com", "Male", 6677889900l, LocalDate.parse("2025-04-20"), LocalDate.parse("2025-09-20"), 111224444l, "Employment", "Denied"),
				new CitizenPlan("Mia Clark", "mia.clark@example.com", "Fe-Male", 9988776655l, LocalDate.parse("2025-05-25"), LocalDate.parse("2025-12-25"), 222335555l, "Employment", "Terminated"),
				new CitizenPlan("Lucas Phillips", "lucas.phillips@example.com", "Male", 3456789012l, LocalDate.parse("2025-04-15"), LocalDate.parse("2025-10-15"), 888990011l, "Employment", "Approved"),
				new CitizenPlan("Ava Parker", "ava.parker@example.com", "Fe-Male", 4567890123l, LocalDate.parse("2025-06-10"), LocalDate.parse("2025-12-25"), 999001122l, "Employment", "Denied")
		
		
				));
		*/
	}

}
