package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CurdOperationsMiniProjectApplication /*implements CommandLineRunner*/ {
	
//	@Autowired
//	private IEmployeeService ser;
	
	public static void main(String[] args) {
		SpringApplication.run(CurdOperationsMiniProjectApplication.class, args);
		
		
	}

	/*@Override
	public void run(String... args) throws Exception {
		
		ser.fetchAllEmps().forEach(System.out::println);
		
	}*/

}
