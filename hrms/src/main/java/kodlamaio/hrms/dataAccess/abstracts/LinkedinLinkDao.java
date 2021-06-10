package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.LinkedinLink;

public interface LinkedinLinkDao extends JpaRepository<LinkedinLink, Integer>{
	LinkedinLink findByCondidate_Id(int condidateId);
}
