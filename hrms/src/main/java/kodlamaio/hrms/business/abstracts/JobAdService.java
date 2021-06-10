package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobAd;

public interface JobAdService {
	DataResult<List<JobAd>> getAll();
	
	Result add(JobAd jobAd);
	
	DataResult<List<JobAd>> getByIsActiveTrue();
	
	DataResult<List<JobAd>> getByIsActiveTrueByDate();
	
	DataResult<List<JobAd>> getByEmployer_IdAndIsActiveTrue(int id);
	
	Result changeState(int jobId, boolean state);
}
