package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SoftwareOrTechService;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SoftwareOrTechDao;
import kodlamaio.hrms.entities.concretes.SoftwareOrTech;

@Service
public class SoftwareOrTechManager implements SoftwareOrTechService{

	private SoftwareOrTechDao sotwareOrTechDao;
	
	@Autowired
	public SoftwareOrTechManager(SoftwareOrTechDao sotwareOrTechDao) {
		super();
		this.sotwareOrTechDao = sotwareOrTechDao;
	}

	@Override
	public Result add(SoftwareOrTech softwareOrTech) {
		this.sotwareOrTechDao.save(softwareOrTech);
		return new SuccessResult("Data kaydedildi");
	}

}
