package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.GithubLinkService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.GithubLink;

@RestController
@RequestMapping("/api/githubLinks")
public class GithubLinksController {
	
	private GithubLinkService githubLinkService;

	@Autowired
	public GithubLinksController(GithubLinkService githubLinkService) {
		super();
		this.githubLinkService = githubLinkService;
	}
	@GetMapping("/findByCondidate_Id")
	public DataResult<GithubLink> findByCondidate_Id(int condidateId){
		return this.githubLinkService.findByCondidate_Id(condidateId);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody GithubLink githubLink) {
		return ResponseEntity.ok(this.githubLinkService.add(githubLink));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handlerValidationException
	(MethodArgumentNotValidException exceptions){
		
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = 
		new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;
	}
}
