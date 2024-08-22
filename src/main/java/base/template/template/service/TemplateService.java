package base.template.template.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import base.template.template.api.model.Model;


//Entire purpose of service is to consume the data from api
@Service
public class TemplateService {
    
    private final RestTemplate restTemplate;

    //Assign the rest template to this Service
    public TemplateService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    //Make getter method for our model
    public Model getModel(){
       String url = "<Your URL Here>";
       return restTemplate.getForObject(url, Model.class);
    }
}
