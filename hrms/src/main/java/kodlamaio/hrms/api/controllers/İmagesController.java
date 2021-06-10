package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.Result;

@RestController
@RequestMapping("/api/images")
public class İmagesController {

	private ImageService imageService;

	@Autowired
	public İmagesController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestParam int condidateId, @RequestParam MultipartFile imageFile) {
		return this.imageService.add(condidateId, imageFile);
	}
}
