package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	DataResult<City> getByName(String cityName);
}
