package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ConfirmationCodeService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.ConfirmationCode;

@RestController
@RequestMapping("/api/confirm")
public class ConfirmationController {

	//test amaçlıdır.
	
	ConfirmationCodeService confirmationCodeService;

	
	@Autowired
	public ConfirmationController(ConfirmationCodeService confirmationCodeService) {
		super();
		this.confirmationCodeService = confirmationCodeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<ConfirmationCode>> getAll(){
		return this.confirmationCodeService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ConfirmationCode confirmationCode) {
		return this.confirmationCodeService.createAndSendCode(new User(0, "asd", "12345"));
	}
	
}
