package by.bsuir.ief.corporativ_portal.model.service;


import by.bsuir.ief.corporativ_portal.model.configue.ServerURL;
import by.bsuir.ief.corporativ_portal.model.entity.City;
import by.bsuir.ief.corporativ_portal.model.entity.Country;
import by.bsuir.ief.corporativ_portal.model.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by andrey on 12.05.2016.
 */
@Component
public class CountryService {

    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate template;


    //--------------------BEGIN URL CONNECTION TO SERVER-------------------------------//

    private static String HOST_URL = ServerURL.getProperty("rest.hostname");
    private static String GET_CITY_BY_ID_COUNTRY = HOST_URL + ServerURL.getProperty("rest.get.cityapi.citybyidcountry");
    private static String GET_COUNTRY = HOST_URL + ServerURL.getProperty("rest.get.countryapi.allcountry");
    private static String GET_DEPARTMENTS = HOST_URL + ServerURL.getProperty("rest.get.departmentapi.departments");


    //--------------------END URL CONNECTION TO SERVER-------------------------------//

    public List<Country> getCounrty(){
        List<Country> list = null;
        try{
            ResponseEntity<Country[]> responseEntity = template.getForEntity(GET_COUNTRY,Country[].class);
            if(responseEntity.getStatusCode() == HttpStatus.OK)
            {
                list = new ArrayList<>();
                Collections.addAll(list,responseEntity.getBody());
            }
        }catch (RuntimeException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    public List<City> getCitiesByCountry(int idCountry){
        List<City> list = null;
        try{
            ResponseEntity<City[]> responseEntity = template.getForEntity(GET_CITY_BY_ID_COUNTRY,City[].class);
            if(responseEntity.getStatusCode() == HttpStatus.OK)
            {
                list = new ArrayList<>();
                Collections.addAll(list,responseEntity.getBody());
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Department> getDepartment(){
        List<Department> list = null;
        try{
            ResponseEntity<Department[]> responseEntity = template.getForEntity(GET_DEPARTMENTS,Department[].class);
            if(responseEntity.getStatusCode() == HttpStatus.OK)
            {
                list = new ArrayList<>();
                Collections.addAll(list,responseEntity.getBody());
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return list;
    }

}
