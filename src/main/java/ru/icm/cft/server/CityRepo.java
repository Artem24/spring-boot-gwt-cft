package ru.icm.cft.server;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by artem on 22.09.2016.
 */
@RepositoryRestResource
public interface CityRepo extends CrudRepository<City, Long> {

    public List<City> findByCountryId(long id);

}
