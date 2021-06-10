package kodlamaio.hrms.adaptor;

import kodlamaio.hrms.mernis.FakeMernisService;

public class MernisAdaptor {
	public boolean IsValid(String identityNo, String firstName, String lastName, String birthYear ) {
		FakeMernisService fakeMernisService = new FakeMernisService();
		return fakeMernisService.IsValid(identityNo, firstName, lastName, birthYear);
	}
}
