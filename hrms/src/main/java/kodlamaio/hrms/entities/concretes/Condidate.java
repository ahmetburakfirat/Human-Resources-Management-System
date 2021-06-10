package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "condidates")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Condidate extends User{
	
	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name = "identity_number")
	@NotBlank
	@NotNull
	private String identityNumber;
	
	@Column(name = "birth_year")
	@NotBlank
	@NotNull
	private String birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "condidate")
	private List<School> schools; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "condidate")
	private List<JobExperience> jobExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "condidate")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToOne(mappedBy = "condidate")
	private Image image;
	
	@JsonIgnore
	@OneToOne(mappedBy = "condidate")
	private GithubLink githubLink;
	
	@JsonIgnore
	@OneToOne(mappedBy = "condidate")
	private LinkedinLink linkedinLink;
	
	@JsonIgnore
	@OneToMany(mappedBy = "condidate")
	private List<SoftwareOrTech> softwareOrTechs;
	
	@JsonIgnore
	@OneToOne(mappedBy = "condidate")
	private CoverLetter coverLetter;

}
