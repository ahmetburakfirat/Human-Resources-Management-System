package kodlamaio.hrms.business.concretes;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmationCodeService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CondidateConfirmationCodeDao;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmationCodeDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.ConfirmationCode;

@Service
public class ConfirmationCodeManager implements ConfirmationCodeService{

	
	private ConfirmationCodeDao confirmationCodeDao;
	private CondidateConfirmationCodeDao condidateConfirmationCodeDao;
	
	@Autowired
	public ConfirmationCodeManager(ConfirmationCodeDao confirmationCodeDao,
			CondidateConfirmationCodeDao condidateConfirmationCodeDao) {
		super();
		this.confirmationCodeDao = confirmationCodeDao;
		this.condidateConfirmationCodeDao = condidateConfirmationCodeDao;
	}



	public DataResult<List<ConfirmationCode>> getAll() {
		return new SuccessDataResult<List<ConfirmationCode>>
		(this.confirmationCodeDao.findAll(), "Data Listelendi");
	}


	@Override
	public  Result createAndSendCode(int userId) {
		
		//Eksikler var daha tamamlanmadı
		
		int random_num = 1000 + (int) (Math.random() * 10000-1000);
		
		String code  = Integer.toString(random_num);

		Date date = new Date(System.currentTimeMillis());
		
		
			
		
		return new SuccessResult("İşlem başarılı.");
	}
	

}
