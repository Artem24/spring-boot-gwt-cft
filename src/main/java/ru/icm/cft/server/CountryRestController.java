/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.icm.cft.server;

//import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author artem
 */
@RestController
public class CountryRestController {
    
    @Autowired
    private CountryRepo countryRepo;
    
    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public List<Country> getCountries(){
        Iterable<Country> allCountries = countryRepo.findAll();
        
//        ArrayList list = new ArrayList();
//        for(Country c : allCountries){
//            list.add(c);
//        }
        
        List list = createList(allCountries);        
        return list;
    }
    
    private List createList(Iterable it){
        
        ArrayList list = new ArrayList();
        for(Object o : it){
            list.add(o);
        }
        
        return list;
    }
    
}
