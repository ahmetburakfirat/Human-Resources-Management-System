package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "employers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements"})
public class Employer extends User{
	
	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;
	
	@Column(name = "website")
	@NotBlank
	@NotNull
	private String website;
	
	@Column(name = "phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAd> advertisements;
}
