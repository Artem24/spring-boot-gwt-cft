/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.icm.cft.client;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

/**
 *
 * @author artem
 */
@Path("cities")
public interface CityService extends RestService { 
    
    @GET
    public void getCities( MethodCallback<List<City>> callback);
    
    @GET
    @Path("{countryname}")
    public void getCitiesByCountryName(@PathParam("countryname") String countryName, MethodCallback<List<City>> callback);
    
}
