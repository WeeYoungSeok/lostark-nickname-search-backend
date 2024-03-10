package com.weeloa.lostark.api.util.connect;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Http {

    public ResponseEntity rest(String url, HttpMethod httpMethod, HttpEntity request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                url,
                httpMethod,
                request,
                String.class
        );
    }
}
