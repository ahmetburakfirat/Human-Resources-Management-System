package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.GithubLink;

public interface GithubLinkDao extends JpaRepository<GithubLink, Integer>{
	GithubLink findByCondidate_Id(int condidateId);
}
