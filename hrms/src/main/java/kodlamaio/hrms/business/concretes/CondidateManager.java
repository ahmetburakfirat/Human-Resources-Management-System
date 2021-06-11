package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.adaptor.MernisAdaptor;
import kodlamaio.hrms.business.abstracts.CondidateService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CondidateDao;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.dataAccess.abstracts.GithubLinkDao;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.LinkedinLinkDao;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.SoftwareOrTechDao;
import kodlamaio.hrms.entities.concretes.Condidate;
import kodlamaio.hrms.entities.dtos.CondidateWithResumeDto;

@Service
public class CondidateManager implements CondidateService{

	private CondidateDao condidateDao;
	private CoverLetterDao coverLetterDao;
	private GithubLinkDao githubLinkDao;
	private ImageDao imageDao;
	private JobExperienceDao jobExperienceDao;
	private LanguageDao languageDao; 
	private LinkedinLinkDao linkedinLinkDao;
	private SchoolDao schoolDao;
	private SoftwareOrTechDao softwareOrTechDao;
	
	@Autowired
	public CondidateManager(CondidateDao condidateDao, CoverLetterDao coverLetterDao, GithubLinkDao githubLinkDao,
			ImageDao imageDao, JobExperienceDao jobExperienceDao, LanguageDao languageDao,
			LinkedinLinkDao linkedinLinkDao, SchoolDao schoolDao, SoftwareOrTechDao softwareOrTechDao) {
		super();
		this.condidateDao = condidateDao;
		this.coverLetterDao = coverLetterDao;
		this.githubLinkDao = githubLinkDao;
		this.imageDao = imageDao;
		this.jobExperienceDao = jobExperienceDao;
		this.languageDao = languageDao;
		this.linkedinLinkDao = linkedinLinkDao;
		this.schoolDao = schoolDao;
		this.softwareOrTechDao = softwareOrTechDao;
	}

	@Override
	public DataResult<List<Condidate>> getAll() {
		return new SuccessDataResult<List<Condidate>>
		(this.condidateDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Condidate condidate) {
		if(condidate.getFirstName().isEmpty() || condidate.getLastName().isEmpty() ||
				condidate.getBirthYear().isEmpty() || condidate.getPassword().isEmpty() ||
				condidate.getIdentityNumber().isEmpty() || condidate.getEmail().isEmpty()) {
			
			return new ErrorResult("Bütün Alanlar Doldurulmalıdır.");
			
		}
		MernisAdaptor mernisAdaptor = new MernisAdaptor();
		if(!mernisAdaptor.IsValid(condidate.getIdentityNumber(), condidate.getFirstName(),
				condidate.getLastName(), condidate.getBirthYear())) {
			
			return new ErrorResult("Bilgileriniz yanlıştır.");
			
		}
		if(!condidateDao.findByEmail(condidate.getEmail()).isEmpty()) {
			
			return new ErrorResult("E-posta adresi sisteme zaten kayıtlıdır.");
			
		}
		if(!condidateDao.findByİdentityNumber(condidate.getIdentityNumber()).isEmpty()) {
			
			return new ErrorResult("TC kimlik numarası sisteme zaten kayıtlıdır.");
			
		}

		try {
			
			condidateDao.save(condidate);
			
			
		} catch (Exception e) {
			
			return new ErrorResult("Kayıt başarısız lütfen daha sonra tekrar deneyiniz.");
			
		}
		
		
		
		return new SuccessResult("Kayıt başarılı e-posta doğrulama bekleniyor.");
	}

	@Override
	public DataResult<CondidateWithResumeDto> getCondidateWithResumeDto(int condidateId) {
		CondidateWithResumeDto condidateWithResumeDto = new CondidateWithResumeDto();
		condidateWithResumeDto.setId(condidateId);
		condidateWithResumeDto.setCoverLetter(this.coverLetterDao.findByCondidate_Id(condidateId));
		condidateWithResumeDto.setGithubLink(this.githubLinkDao.findByCondidate_Id(condidateId));
		condidateWithResumeDto.setImage(this.imageDao.findByCondidate_Id(condidateId));
		condidateWithResumeDto.setJobExperiences(this.jobExperienceDao.findByCondidate_IdOrderByEndYearDesc(condidateId));
		condidateWithResumeDto.setLanguages(this.languageDao.findByCondidate_Id(condidateId));
		condidateWithResumeDto.setLinkedinLink(this.linkedinLinkDao.findByCondidate_Id(condidateId));
		condidateWithResumeDto.setSchools(this.schoolDao.findByCondidate_IdOrderByEndYearDesc(condidateId));
		condidateWithResumeDto.setSoftwareOrTechs(this.softwareOrTechDao.findByCondidate_Id(condidateId));
		return new SuccessDataResult<CondidateWithResumeDto>(condidateWithResumeDto,"İşlem başarılı");
	}
	
	

}
