package kodlamaio.hrms.business.abstracts;

import java.util.List;


import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Condidate;
import kodlamaio.hrms.entities.dtos.CondidateWithResumeDto;

public interface CondidateService {
	DataResult<List<Condidate>> getAll();
	
	Result add(Condidate condidate);
	
	DataResult<List<CondidateWithResumeDto>> getCondidateWithResumeDto(int condidateId);
}
