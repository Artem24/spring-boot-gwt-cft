package ru.icm.cft.server;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

/**
 * Created by artem on 22.09.2016.
 */
@Entity
public class Country extends AbstractPersistable<Long> {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
