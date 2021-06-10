package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.GithubLinkService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.GithubLinkDao;
import kodlamaio.hrms.entities.concretes.GithubLink;

@Service
public class GithubLinkManager implements GithubLinkService{

	private GithubLinkDao githubLinkDao;
	
	@Autowired
	public GithubLinkManager(GithubLinkDao githubLinkDao) {
		super();
		this.githubLinkDao = githubLinkDao;
	}

	@Override
	public DataResult<GithubLink> findByCondidate_Id(int condidateId) {
		return new SuccessDataResult<GithubLink>(this.githubLinkDao.findByCondidate_Id(condidateId), "Data listelendi");
	}

	@Override
	public Result add(GithubLink githubLink) {
		this.githubLinkDao.save(githubLink);
		return new SuccessResult("Data kaydedildi");
	}

}
