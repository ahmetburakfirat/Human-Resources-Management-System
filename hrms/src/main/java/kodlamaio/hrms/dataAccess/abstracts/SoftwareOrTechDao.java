package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.SoftwareOrTech;

public interface SoftwareOrTechDao extends JpaRepository<SoftwareOrTech, Integer>{
	List<SoftwareOrTech> findByCondidate_Id(int condidateId);
}
