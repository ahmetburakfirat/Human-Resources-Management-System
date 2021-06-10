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
@Table(name = "schools")
@AllArgsConstructor
@NoArgsConstructor
public class School {
	/*Adayların okudukları okullar mezuniyet yılına 
	göre tersten sıralanabilmelidir. Mezun olunmamışsa 
	yine bu okul en üstte ve "devam ediyor" olarak 
	görüntülenmelidir.*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school")
	@NotBlank
	@NotNull
	private String school;
	
	@Column(name = "start_year")
	@NotBlank
	@NotNull
	private String startYear;
	
	@Column(name = "end_year")
	private String endYear;
	
	@Column(name = "department")
	@NotBlank
	@NotNull
	private String department;
	
	
	@ManyToOne
	@JoinColumn(name = "condidate_id")
	private Condidate condidate;
}
