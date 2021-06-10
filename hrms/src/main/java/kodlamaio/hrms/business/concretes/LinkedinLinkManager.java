package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinkedinLinkService;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkedinLinkDao;
import kodlamaio.hrms.entities.concretes.LinkedinLink;

@Service
public class LinkedinLinkManager implements LinkedinLinkService{

	private LinkedinLinkDao linkedinLinkDao;
	
	@Autowired
	public LinkedinLinkManager(LinkedinLinkDao linkedinLinkDao) {
		super();
		this.linkedinLinkDao = linkedinLinkDao;
	}

	@Override
	public Result add(LinkedinLink linkedinLink) {
		this.linkedinLinkDao.save(linkedinLink);
		return new SuccessResult("Data kaydedildi");
	}

}
