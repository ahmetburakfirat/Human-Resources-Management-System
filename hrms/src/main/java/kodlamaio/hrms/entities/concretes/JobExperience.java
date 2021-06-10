package kodlamaio.hrms.entities.concretes;

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
@Entity
@Table(name = "job_experiences")
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {
	/*Adayların tecrübeleri yıla göre tersten sıralanabilmelidir.
	Hala çalışıyorsa yine bu tecrübesi en üstte ve "devam"
	+ " ediyor" olarak görüntülenmelidir.*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "work_place")
	@NotBlank
	@NotNull
	private String workPlace;
	
	@Column(name = "position")
	@NotBlank
	@NotNull
	private String position;
	
	@Column(name = "start_year")
	@NotBlank
	@NotNull
	private String startYear;
	
	@Column(name = "end_year")
	private String endYear;
	
	@ManyToOne
	@JoinColumn(name = "condidate_id")
	private Condidate condidate;
	
}
