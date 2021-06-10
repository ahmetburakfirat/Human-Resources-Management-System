package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> findByCondidate_IdOrderByEndYearDesc(int condidateId);
	
	Result add(School school);
}
