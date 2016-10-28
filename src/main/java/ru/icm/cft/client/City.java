package ru.icm.cft.client;



/**
 * Created by artem on 22.09.2016.
 */
public class City {

    private String name;
    private Country country;


    //@JoinColumn(name = "COUNTRY_ID")
    public Country getCountry(){
        return country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


}
