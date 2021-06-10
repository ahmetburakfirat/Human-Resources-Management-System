package kodlamaio.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.image.PhotoService;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CondidateDao;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Condidate;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private PhotoService photoService;
	private CondidateDao condidateDao;
	
	@Autowired
	public ImageManager(ImageDao imageDao, PhotoService photoService, CondidateDao condidateDao) {
		super();
		this.imageDao = imageDao;
		this.photoService = photoService;
		this.condidateDao = condidateDao;
	}


	@Override
	public Result add(int condidateId, MultipartFile imageFile) {
		
		Condidate condidate = this.condidateDao.getById(condidateId);
		Image image = new Image();
		image.setCondidate(condidate);
		
		@SuppressWarnings("unchecked")
		Map<String,String> uploadImage = this.photoService.uploadImageFile(imageFile).getData();
		image.setUrl(uploadImage.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Data kaydedildi");
	}
	
}
