package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.GithubLink;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.LinkedinLink;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.SoftwareOrTech;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondidateWithResumeDto {
	private int id;
	private List<School> schools;
	private List<JobExperience> jobExperiences;
	private List<Language> languages;
	private Image image;
	private GithubLink githubLink;
	private LinkedinLink linkedinLink;
	private List<SoftwareOrTech> softwareOrTechs;
	private CoverLetter coverLetter;

}
