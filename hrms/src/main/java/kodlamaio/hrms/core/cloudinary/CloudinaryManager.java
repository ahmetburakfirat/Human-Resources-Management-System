package kodlamaio.hrms.core.cloudinary;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.image.PhotoService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.SuccessDataResult;

@Service
public class CloudinaryManager implements PhotoService{
	
	private Cloudinary cloudinary;
	
	public CloudinaryManager() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name","hrms-abf",
				"api_key", "466274123438225",
				"api_secret","H4jkpZRClZ7BiRNWCbL-9WPWwRk"));
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (Exception e) {
			return new ErrorDataResult<Map>("Data kaydedilemedi");
		}
		
	}
}
