package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ConfirmationCode;

public interface ConfirmationCodeDao extends JpaRepository<ConfirmationCode, Integer>{

}
