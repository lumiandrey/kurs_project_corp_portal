package controller;


import model.entity.PersonPisl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ApplicationController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView main(){
        return new ModelAndView("index", "person", new PersonPisl());
    }




}
