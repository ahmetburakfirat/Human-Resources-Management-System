package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdDao;
import kodlamaio.hrms.entities.concretes.JobAd;

@Service
public class JobAdManager implements JobAdService{
	
	private JobAdDao jobAdDao;

	@Autowired
	public JobAdManager(JobAdDao jobAdDao) {
		super();
		this.jobAdDao = jobAdDao;
	}

	//gerekli değil test amaçlı eklenmiştir.
	@Override
	public DataResult<List<JobAd>> getAll() {
		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findAll(), "Data listelendi");
	}

	@Override
	public DataResult<List<JobAd>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findByIsActiveTrue(), "Data listelendi");
	}

	
	@Override
	public DataResult<List<JobAd>> getByIsActiveTrueByDate() {
		Sort sort = Sort.by(Sort.Direction.DESC, "releaseDate");
		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findByIsActiveTrue(sort), "Data listelendi");
	}
	
	@Override
	public DataResult<List<JobAd>> getByEmployer_IdAndIsActiveTrue(int id) {
		return new SuccessDataResult<List<JobAd>>(this.jobAdDao.findByEmployer_IdAndIsActiveTrue(id), "Data listelendi");
	}

	@Override
	public Result add(JobAd jobAd) {
		try {
			
			this.jobAdDao.save(jobAd);
			
		} catch (Exception e) {
			
			return new ErrorResult("Data kaydedilemedi");
			
		}
		
		return new SuccessResult("Data kaydedildi");
	}

	@Override
	public Result changeState(int jobId, boolean state) {
		JobAd jobAd = this.jobAdDao.findById(jobId).get();
		jobAd.setActive(state);
		try {
			
			this.jobAdDao.save(jobAd);
			
		} catch (Exception e) {
			
			return new ErrorResult( "İşlem başarısız");
			
		}
		
		return new SuccessResult( "İşlem başarılı");
	}

	
	
	
}
