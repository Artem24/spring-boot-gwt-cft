package ru.icm.cft.server;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by artem on 22.09.2016.
 */
@Entity
public class Unit extends AbstractPersistable<Long> {

    private String name;
    private String address;
    private String direction;

    //@ManyToMany(targetEntity = City.class)
    @ManyToOne
    private City city;

//    @ManyToMany(targetEntity = Bank.class)
    @ManyToOne
    private Bank bank;

    
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }

    public Bank getBank() {
        return bank;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    
    
}
