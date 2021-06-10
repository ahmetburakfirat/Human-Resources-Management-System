package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	DataResult<CoverLetter> findByCondidate_Id(int condidateId);

	Result add(CoverLetter coverLetter);
}
