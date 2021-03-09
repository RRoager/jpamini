package com.eikholm.jpamini.controller;

import com.eikholm.jpamini.model.Person;
import com.eikholm.jpamini.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("persons", personService.findAll());
        return "index";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addPerson(Person person){
        personService.save(person);
        //model.addAttribute("persons", personService.findAll());
        return "redirect:/";
    }
}
