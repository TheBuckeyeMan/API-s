package base.template.template.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import base.template.template.api.model.Model;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


//Entire purpose of service is to consume the data from api
@Service
@RequiredArgsConstructor
@Slf4j
public class TemplateService {
    
    private final RestTemplate restTemplate;

    //Make getter method for our model
    public Model getModel(){
        String url = "<Your URL Here>";

        //Log the request being made to external data source
        log.info("Making request to External API: {}", url);

        Model model = null;
        
        try {
            model = restTemplate.getForObject(url,Model.class);
            //Log the response from the external api. The response is model object
            log.info("Recieved Response from external API: {}", model);
                if (model != null) {
                    saveToFile(model);
                }
                } catch (HttpStatusCodeException e) {
                    //log error if an error status code is returned
                    log.error("Recieved an error response from API: {}", e.getResponseBodyAsString(), e);
                } catch (Exception e) {
                    log.error("An Error Occured while making the reques tto external API: {}", e);
                }
       return model;
    }
    private void saveToFile(Model model) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("<Name Of Your File Here>.<File Extension>"))){
            //ADD IN ALL DATA POINTS TO WRITE TO FILE HERE - FOR BIG API'S WE WILL HAVE MORE HERE
            writer.write("<Identifier of Value>" + model.<Getter for this value found in models> + "\n");
            writer.write("<Identifier of Value>" + model.<Getter for this value found in models> + "\n");
            writer.write("<Identifier of Value>" + model.<Getter for this value found in models> + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
