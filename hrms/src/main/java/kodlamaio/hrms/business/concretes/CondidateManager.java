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
import kodlamaio.hrms.entities.concretes.Condidate;

@Service
public class CondidateManager implements CondidateService{

	private CondidateDao condidateDao;
	
	@Autowired
	public CondidateManager(CondidateDao condidateDao) {
		super();
		this.condidateDao = condidateDao;
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
	
	

}
