package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CondidateConfirmationCode;

public interface CondidateConfirmationCodeDao extends JpaRepository<CondidateConfirmationCode, Integer>{
	CondidateConfirmationCode findByCondidate_Id(int condidateId);
}
