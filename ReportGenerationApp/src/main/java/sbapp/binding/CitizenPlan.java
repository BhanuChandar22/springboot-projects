package sbapp.binding;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "CITIZEN_PLANS_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizenPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NonNull
	@Column(length = 50)
	private String name;
	@Column(length = 50)
	@NonNull
	private String email;
	@NonNull
	@Column(length = 20)
	private String gender;
	@NonNull
	@Column(length = 20)
	private Long mobileNumber;
	@NonNull
	private LocalDate startDate;
	@NonNull
	private LocalDate endDate;
	@NonNull
	@Column(length = 20)
	private Long ssnNumber;
	@NonNull
	@Column(length = 20)
	private String planName;
	@NonNull
	@Column(length = 20)
	private String planStatus;
}
