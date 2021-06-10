package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private String email, domain;
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		
		if(employer.getEmail().isEmpty() || employer.getPhoneNumber().isEmpty() ||
				employer.getWebsite().isEmpty() || employer.getPassword().isEmpty()) {
			
			return new ErrorResult("Bütün Alanlar Doldurulmalıdır.");
			
		}
		if(!employerDao.findByEmail(employer.getEmail()).isEmpty()) {
			
			return new ErrorResult("E-posta adresi sisteme zaten kayıtlıdır.");
			
		}
		try {
			email = (employer.getEmail().split("@")[1]).toLowerCase();
			
		}catch(Exception e){
			
			return new ErrorResult("E-posta adresi geçersizdir.");
			
		}
		
		domain=employer.getWebsite().toLowerCase();
		
		if(!domain.equals(email)) {
			
			return new ErrorResult("web sitesi ile e-posta adresi domain'i uyuşmuyor.");
			
		}
		
		try {
			
			employerDao.save(employer);
			
		} catch (Exception e) {
			
			return new ErrorResult("Kayıt başarısız lütfen daha sonra tekrar deneyiniz.");
			
		}
		
		return new SuccessResult("Kayıt başarılı e-posta doğrulama bekleniyor.");
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
