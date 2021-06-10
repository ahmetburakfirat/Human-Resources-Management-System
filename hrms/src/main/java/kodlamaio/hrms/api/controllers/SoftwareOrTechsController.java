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

import kodlamaio.hrms.business.abstracts.SoftwareOrTechService;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.SoftwareOrTech;

@RestController
@RequestMapping("/api/softwareOrTechs")
public class SoftwareOrTechsController {

	private SoftwareOrTechService softwareOrTechService;

	@Autowired
	public SoftwareOrTechsController(SoftwareOrTechService softwareOrTechService) {
		super();
		this.softwareOrTechService = softwareOrTechService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody SoftwareOrTech softwareOrTech) {
		return ResponseEntity.ok(this.softwareOrTechService.add(softwareOrTech));
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
