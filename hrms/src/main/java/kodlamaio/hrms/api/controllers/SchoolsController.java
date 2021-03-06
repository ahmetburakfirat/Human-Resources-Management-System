package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
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

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.School;

@RestController
@RequestMapping(value = "/api/schools")
public class SchoolsController {
	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/findByCondidate_IdOrderByEndYearDesc")
	public DataResult<List<School>> findByCondidate_IdOrderByEndYearDesc(int condidateId){
		return this.schoolService.findByCondidate_IdOrderByEndYearDesc(condidateId);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody School school) {
		return ResponseEntity.ok(this.schoolService.add(school));
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
		new ErrorDataResult<Object>(validationErrors, "Do??rulama hatalar??");
		return errors;
	}
}
