package kodlamaio.hrms.core.image;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.DataResult;

public interface PhotoService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
