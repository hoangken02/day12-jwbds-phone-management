package com.codeGym.controller;

import com.codeGym.model.Smartphone;
import com.codeGym.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/smartphones")
public class SmartphoneController {
    @Autowired
    private SmartphoneService smartphoneService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createSmartPhonePage() {
        ModelAndView modelAndView = new ModelAndView("phones/new-phone");
        modelAndView.addObject("smartphone", new Smartphone());
        return modelAndView;
    }

    @RequestMapping(value = "/createNewPhone", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneService.save(smartphone);
    }

    @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Smartphone> allPhones(){
        return smartphoneService.findAll();
    }

    @GetMapping("")
    public ModelAndView allPhonesPage(){
        ModelAndView modelAndView = new ModelAndView("phones/all-phones");
        modelAndView.addObject("allPhones",allPhones());
        return modelAndView;
    }


    @RequestMapping(value = "delete/{id}",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone deleteSmartphone(@PathVariable Integer id){
            return smartphoneService.delete(id);
    }

    @RequestMapping(value = "edit/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private Smartphone editSmartphone(@PathVariable Integer id,@RequestBody Smartphone smartphone){
        smartphone.setId(id);
        return smartphoneService.save(smartphone);
    }
}
