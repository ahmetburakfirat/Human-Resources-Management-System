package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.abstracts.User;
import kodlamaio.hrms.entities.concretes.ConfirmationCode;

public interface ConfirmationCodeService {
	DataResult<List<ConfirmationCode>> getAll();
	Result createAndSendCode(User user);
}
