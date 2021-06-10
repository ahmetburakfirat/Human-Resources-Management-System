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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinkedinLinkService;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.LinkedinLink;

@RestController
@RequestMapping("/api/linkedinLinks")
public class LinkedinLinksController {

	private LinkedinLinkService linkedinLinkService;

	@Autowired
	public LinkedinLinksController(LinkedinLinkService linkedinLinkService) {
		super();
		this.linkedinLinkService = linkedinLinkService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody LinkedinLink linkedinLink) {
		return ResponseEntity.ok(this.linkedinLinkService.add(linkedinLink));
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
