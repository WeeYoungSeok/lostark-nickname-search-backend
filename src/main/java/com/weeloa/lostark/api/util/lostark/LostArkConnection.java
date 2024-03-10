package com.weeloa.lostark.api.util.lostark;

import com.weeloa.lostark.api.util.connect.Http;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class LostArkConnection {
    private final Http http;

    public LostArkConnection(Http http) {
        this.http = http;
    }

    private HttpEntity getHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, "application/json");
        headers.set(HttpHeaders.AUTHORIZATION, "bearer " + token);
        return new HttpEntity(headers);
    }

    public ResponseEntity getResponse(String url, String token, HttpMethod httpMethod, HttpEntity httpEntity) {
        try {
            return http.rest(url, HttpMethod.GET, getHeader(token));
        } catch (
                HttpClientErrorException.Unauthorized e) {
            throw new IllegalArgumentException();
        } catch (HttpClientErrorException.TooManyRequests et) {
            throw new IllegalArgumentException();
        }
    }
}
