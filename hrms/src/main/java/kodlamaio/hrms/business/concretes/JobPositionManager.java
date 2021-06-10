package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}



	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(), "Data listelendi");
				
				
	}



	@Override
	public Result add(JobPosition jobPosition) {
		if(!jobPositionDao.findByTitle(jobPosition.getTitle()).isEmpty()) {
			return new ErrorResult("Bu pozisyon zaten kayıtlı.");
		}
		
		try {
			
			jobPositionDao.save(jobPosition);
			
		} catch (Exception e) {
			
			return new ErrorResult("Kayıt başarısız lütfen daha sonra tekrar deneyiniz.");
		}
		return new SuccessResult("İşlem başarılı");
	}

}
