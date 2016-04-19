package by.bsuir.pisl;

import by.bsuir.pisl.model.pisl.PersonPisl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrey on 18.04.2016.
 */
public class MainApp {

    @Autowired
    private static RestTemplate restTemplate;

    public static void main(String[] args) {
        //GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ctx.load("spring/applicationConfig.xml");
        //ctx.refresh();

        //RestTemplate restTemplate = ctx.getBean("restTemplate", RestTemplate.class);

        String get_all_person = "http://localhost:8080/pislrest/persons";
        List<LinkedHashMap> emps = restTemplate.getForObject(get_all_person, List.class);
        System.out.println(emps.size());
        for(LinkedHashMap map : emps){
            System.out.println(map);
        }

        PersonPisl emp = restTemplate.getForObject("http://localhost:8080/pislrest/person/1", PersonPisl.class);
        System.out.println(emp);

        PersonPisl[] pisls = restTemplate.getForObject("http://localhost:8080/pislrest/persons",PersonPisl[].class);
        for(PersonPisl p: pisls)
            System.out.println(p);
        try {
            ResponseEntity<PersonPisl> entity = restTemplate.getForEntity(new URI("http://localhost:8080/pislrest/person/1"),PersonPisl.class);
            entity = restTemplate.getForEntity(new URI("http://localhost:8080/pislrest/persons"),PersonPisl.class);
            System.out.println(entity);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
