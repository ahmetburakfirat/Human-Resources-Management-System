package kodlamaio.hrms.core.cloudinary;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.DataResult;

public interface CloudinaryService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
