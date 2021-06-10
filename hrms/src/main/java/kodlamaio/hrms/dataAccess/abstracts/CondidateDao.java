package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Condidate;

public interface CondidateDao extends JpaRepository<Condidate, Integer>{

	List<Condidate> findByEmail(String email);
	
	List<Condidate> findByİdentityNumber(String identityNumber);
	
	Condidate getById(int condidateId);
}
