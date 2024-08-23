package base.template.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import java.util.Collections;
import java.util.List;

//The entire purpose of the configuration file is to simply configure ther RestTemplate as a bean in the application s it can be autowired
//BEarer tokens require an interceptor to be opresent. We must add the interceptor to the AppConfig.java class


@Configuration
public class AppConfig {

    private static final String BEARER_TOKEN = "<Your Bearer Token Here>";

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        interceptors = (interceptors == null) ? Collections.singletonList(new BearerTokenInterceptor()) : interceptors;
        restTemplate.setInterceptors(interceptors);
        return restTemplate();
    }

    //Now we must define the interceptor for the bearer token
    public class BearerTokenInterceptor implements ClientHttpRequestInterceptor{
        @Override
        public org.springframework.http.client.ClientHttpResponse intercept(
            org.springframework.http.HttpRequest request,
            byte[] body,
            org.springframework.http.client.ClientHttpRequestExecution execution 
        ) throws java.io.IOException {
            request.getHeaders().set("Authorization","Bearer" + BEARER_TOKEN);
            return execution.execute(request, body);
        }
    }
}
