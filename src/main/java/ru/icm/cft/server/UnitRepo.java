package ru.icm.cft.server;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by artem on 22.09.2016.
 */
@RepositoryRestResource
public interface UnitRepo extends CrudRepository<Unit, Long> {
    
    public List<Unit> findByCityNameOrderByBankName(String cityName);
    
}
