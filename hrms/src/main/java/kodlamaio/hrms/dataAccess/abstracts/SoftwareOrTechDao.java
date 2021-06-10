package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SoftwareOrTech;

public interface SoftwareOrTechDao extends JpaRepository<SoftwareOrTech, Integer>{
	SoftwareOrTech findByCondidate_Id(int condidateId);
}
