package base.template.template.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import base.template.template.api.model.Model;
import base.template.template.service.TemplateService;


//Entire purpose of the controller is to expose the api endpoints and trigger the api
@RestController
@RequestMapping("/api")
public class Controller {
    //Initialize new instance of the service for the controller
    private final TemplateService templateService;

    public Controller(TemplateService templateService){
        this.templateService = templateService;
    }

    @GetMapping("/model")
    public Model getModel(){
        return templateService.getModel();
    }
    
}
