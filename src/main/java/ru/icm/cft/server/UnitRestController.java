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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author artem
 */
@RestController
public class UnitRestController {
    
    @Autowired
    private UnitRepo unitRepo;
    
    @RequestMapping(value = "/units/{cityname}", method = RequestMethod.GET)
    public List<Unit> getUnits(@PathVariable(name = "cityname") String cityName){

        if(cityName == null){
            Iterable<Unit> allUnits = unitRepo.findAll();
            List list = createList(allUnits);

            return list;
        } else {
            return unitRepo.findByCityNameOrderByBankName(cityName);
        }


    }
    
    private List createList(Iterable it){
        
        ArrayList list = new ArrayList();
        for(Object o : it){
            list.add(o);
        }
        
        return list;
    }
    
}
