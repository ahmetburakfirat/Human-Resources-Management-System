package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JobAd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "title")
	@NotBlank
	@NotNull
	private String title;
	
	@Column(name = "description")
	@NotBlank
	@NotNull
	private String description;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "num_of_position")
	@NotBlank
	@NotNull
	private String numOfPosition;
	
	@Column(name = "release_date")
	private Date releaseDate;
	
	@Column(name = "dead_line")
	@NotBlank
	@NotNull
	private Date deadLine;
	
	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
}
