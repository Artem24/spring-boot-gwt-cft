package ru.icm.cft.server;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by artem on 22.09.2016.
 */
@RepositoryRestResource
public interface BankRepo extends CrudRepository<Bank, Long> {
}
