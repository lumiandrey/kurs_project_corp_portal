package by.bsuir.ief.corporativ_portal.controller;

import by.bsuir.ief.corporativ_portal.model.configue.ClientURL;
import by.bsuir.ief.corporativ_portal.model.entity.City;
import by.bsuir.ief.corporativ_portal.model.entity.Country;
import by.bsuir.ief.corporativ_portal.model.entity.Department;
import by.bsuir.ief.corporativ_portal.model.entity.Person;
import by.bsuir.ief.corporativ_portal.model.service.CountryService;
import by.bsuir.ief.corporativ_portal.model.service.PersonService;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.Valid;
import javax.ws.rs.GET;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by andrey on 05.05.2016.
 */
@Controller
@RequestMapping("/person-control")
public class PersonController {


    @Qualifier("personService")
    @Autowired
    private PersonService service;
    @Qualifier("countryService")
    @Autowired
    private CountryService countryService;


    @RequestMapping(value = "/show-person", method = RequestMethod.GET)
    public ModelAndView getPerson(HttpSession session)
    {
        return null;
    }

    @RequestMapping(value = "/edit-person", method = RequestMethod.POST)
    public String updatePerson(@Valid @ModelAttribute("person")Person person,
                               BindingResult bindingResult,
                               ModelMap model,
                               HttpSession session,
                               @RequestParam(value="file", required=false) Part file) throws Exception {
        if(!bindingResult.hasErrors()) {
            Person person1 = (Person) session.getAttribute("person");


            //-------begin load photo---------//
            if (file != null) {
                byte[] fileContent = null;
                try {
                    InputStream inputStream = file.getInputStream();
                    fileContent = IOUtils.toByteArray(inputStream);
                    person.setPhoto(fileContent);
                    person1.setPhoto(fileContent);
                }catch(IOException e){
                    person.setPhoto(person1.getPhoto());
                    }
                }
            //---------end load photo---------//


            //--------initialization person model form-----------//
            person.setCity(person1.getCity());
            person.setDepartment(person1.getDepartment());
            person.setIdPerson(person1.getIdPerson());
            person.setPost(person1.getPost());
            //-----initialize person session atribute----------//
            person1.setLastName(person.getLastName());
            person1.setPatronymic(person.getPatronymic());
            person1.setName(person.getName());
            person1.seteMail(person.geteMail());
            person1.setSex(person.getSex());
            //person1.setStatus(person.getStatus());
            person1.setLinkSelfSite(person.getLinkSelfSite());
            //----------------update to service---------------//
            session.setAttribute("person", person1);
            service.update(person);
            model.replace("person", person);
            return ClientURL.getProperty("url.main");
        }else
            return ClientURL.getProperty("url.main");
    }

    @RequestMapping(value = "/showAllPerson",method = RequestMethod.GET)
    public ModelAndView showAllPerson()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("personList",service.getPersons());
        modelAndView.setViewName(ClientURL.getProperty("url.showAllPerson"));
        return modelAndView;
    }

    @RequestMapping(value = "/showAllPersonSort",method = RequestMethod.GET)
    public ModelAndView showAllPersonSort()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listPersonSort",service.getPersonsSorted());
        modelAndView.setViewName(ClientURL.getProperty("url.showAllPersonSort"));
        return modelAndView;
    }



    @RequestMapping(value = "/showDetails/{id}")
    public ModelAndView showDetails(@PathVariable("id")int idPerson, ModelMap modelMap)
    {
        return new ModelAndView(ClientURL.getProperty("url.showAllPerson"),modelMap);
    }

    @RequestMapping(value = "/photo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public byte [] downloadPhoto (@PathVariable ("id") Long id, HttpSession session){
        return ((Person)session.getAttribute("person")).getPhoto();
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.GET)
    public ModelAndView addPerson()
    {
        return new ModelAndView(ClientURL.getProperty("url.addperson"), "createperson", new Person());
    }

    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public List<Country> getCountry(){
        return countryService.getCounrty();
    }

    @RequestMapping(value = "/city-by-id-country")
    public List<City> getCityByCountry(@RequestParam int idCountry)
    {
        return countryService.getCitiesByCountry(idCountry);
    }

    @RequestMapping(value = "/get-department", method = RequestMethod.GET)
    public List<Department> getDepartment()
    {
        return countryService.getDepartment();
    }

}
