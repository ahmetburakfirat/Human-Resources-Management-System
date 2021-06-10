package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.GithubLink;

public interface GithubLinkService {
	DataResult<GithubLink> findByCondidate_Id(int condidateId);
	
	Result add(GithubLink githubLink);
	
}
