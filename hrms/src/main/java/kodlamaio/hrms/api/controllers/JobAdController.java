package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobAd;

@RestController
@RequestMapping("/api/jobads")
public class JobAdController {
	
	private JobAdService jobAdService;

	@Autowired
	public JobAdController(JobAdService jobAdService) {
		super();
		this.jobAdService = jobAdService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAd>> getAll(){
		return this.jobAdService.getAll();
	}
	
	@GetMapping("/getByIsActiveTrue")
	public DataResult<List<JobAd>> getByIsActiveTrue(){
		return this.jobAdService.getByIsActiveTrue();
	}
	
	@GetMapping("/getByIsActiveTrueByDate")
	public DataResult<List<JobAd>> getByIsActiveTrueByDate(){
		return this.jobAdService.getByIsActiveTrueByDate();
	}
	
	@GetMapping("/getByEmployer_IdAndIsActive")
	public DataResult<List<JobAd>> getByEmployer_IdAndIsActive(@RequestParam int id){
		return this.jobAdService.getByEmployer_IdAndIsActiveTrue(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAd jobAd) {
		return this.jobAdService.add(jobAd);
	}
	
	@PostMapping("/changeState")
	Result changeState(@RequestParam int jobId,@RequestParam boolean state) {
		return this.jobAdService.changeState(jobId, state);
	}
	
	
	
	
	
}
