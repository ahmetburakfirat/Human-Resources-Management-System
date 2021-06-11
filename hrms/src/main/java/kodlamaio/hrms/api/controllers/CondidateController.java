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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.business.abstracts.CondidateService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.entities.concretes.Condidate;
import kodlamaio.hrms.entities.dtos.CondidateWithResumeDto;
import kodlamaio.hrms.core.utilities.ErrorDataResult;

@RestController
@RequestMapping("/api/condidates")
public class CondidateController {
	
	CondidateService condidateService;

	@Autowired
	public CondidateController(CondidateService condidateService) {
		super();
		this.condidateService = condidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Condidate>> getAll(){
		return this.condidateService.getAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Condidate condidate){
		return ResponseEntity.ok(this.condidateService.add(condidate));
	}
	
	@GetMapping("/getCondidateWithResumeDto")
	public DataResult<CondidateWithResumeDto> getCondidateWithResumeDto(@RequestParam int condidateId){
		return this.condidateService.getCondidateWithResumeDto(condidateId);
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
