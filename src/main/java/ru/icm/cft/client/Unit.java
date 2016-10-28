package ru.icm.cft.client;


/**
 * Created by artem on 22.09.2016.
 */
public class Unit {

    private String name;
    private String address;
    private String direction;

    private City city;
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
