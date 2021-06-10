package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.Result;

public interface ImageService {
	
	Result add(int condidateId, MultipartFile imageFile);
}
