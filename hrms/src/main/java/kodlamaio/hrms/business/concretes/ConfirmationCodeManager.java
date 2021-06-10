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
import kodlamaio.hrms.dataAccess.abstracts.ConfirmationCodeDao;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.ConfirmationCode;

@Service
public class ConfirmationCodeManager implements ConfirmationCodeService{

	
	public ConfirmationCodeDao confirmationCodeDao;
	
	
	
	@Autowired
	public ConfirmationCodeManager(ConfirmationCodeDao confirmationCodeDao) {
		super();
		this.confirmationCodeDao = confirmationCodeDao;
	}


	public DataResult<List<ConfirmationCode>> getAll() {
		return new SuccessDataResult<List<ConfirmationCode>>
		(this.confirmationCodeDao.findAll(), "Data Listelendi");
	}


	
	public  Result createAndSendCode(User user) {
		
		int random_num = 1000 + (int) (Math.random() * 10000-1000);
		
		String code  = Integer.toString(random_num);
//		
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//		LocalDateTime now = LocalDateTime.now();
		//dtf.format(now)
		
//		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
//		System.out.println(formatter.format(date) + date);
		
		confirmationCodeDao.save(new ConfirmationCode(0, user.getId(), code, false, date ));
			
		
		return new SuccessResult("İşlem başarılı.");
	}
	

}
