package springboot.model;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Emp2")
@Data
@SQLDelete(sql = "UPDATE emp2 SET STATUS='IN-ACTIVE' WHERE empno=?")
@Where(clause = "STATUS <> 'IN-ACTIVE'")
public class Employee {
	@Id
	@SequenceGenerator(name = "gen",sequenceName = "eno_gen2",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.SEQUENCE)
	private Integer empno;
	private String ename;
	private String job = "ANALYST";
	private LocalDate hiredate;
	@Column(name = "sal")
	private Double salary;
	private String status="ACTIVE";
}
