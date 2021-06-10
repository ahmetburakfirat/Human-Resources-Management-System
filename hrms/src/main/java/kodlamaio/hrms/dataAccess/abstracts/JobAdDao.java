package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAd;

public interface JobAdDao extends JpaRepository<JobAd, Integer>{
	
	List<JobAd> findByIsActiveTrue();
	
	List<JobAd> findByIsActiveTrue(Sort sort);
	
	List<JobAd> findByEmployer_IdAndIsActiveTrue(int id);
}
