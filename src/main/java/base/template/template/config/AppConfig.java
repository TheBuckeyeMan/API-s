package base.template.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import java.util.List;
import java.util.ArrayList;

//The entire purpose of the configuration file is to simply configure ther RestTemplate as a bean in the application s it can be autowired
//BEarer tokens require an interceptor to be opresent. We must add the interceptor to the AppConfig.java class


@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();

        //Interceptor to add to the bearer token
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add((request,body,execution) -> {
            //We will add out bearer token here
            String token = "<Your Bearer Token>";
            request.getHeaders().set("Authorization","Bearer" + token);
            return execution.execute(request, body);
        });
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
