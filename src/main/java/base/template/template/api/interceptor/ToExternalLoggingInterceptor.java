package base.template.template.api.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStream;




@Component
public class ToExternalLoggingInterceptor implements ClientHttpRequestInterceptor {
    
    private static final Logger log = LoggerFactory.getLogger(ToExternalLoggingInterceptor.class);
    private final ObjectMapper objectMapper = new ObjectMapper(); //Object for JSON Request
    
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequestDetails(request, body);//Log Request of Details
        return execution.execute(request, body); //proceed with request
    }

    private void logRequestDetails(HttpRequest request, byte[] body) throws IOException {
        String requestBody = new String(body, "UTF-8"); //Convert request body to json format

        //Log the Request Details
        log.info("Request URL: {}", request.getURI());
        log.info("Request Method: {}", request.getMethod());
        log.info("Request Headers: {}", request.getHeaders()); //Authentication
        log.info("Request Body: {}", requestBody);
    }






}
