package com.weeloa.lostark.api.util.lostark;

import com.weeloa.lostark.api.util.connect.Http;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class LostArkConnection {
    private final Http http;

    public LostArkConnection(Http http) {
        this.http = http;
    }

    public String getToken() {
        // 세션에서 api_key를 가져옴
        return (String) ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest()
                .getSession()
                .getAttribute("api_key");
    }

    private HttpEntity getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, "application/json");
        headers.set(HttpHeaders.AUTHORIZATION, "bearer " + getToken());
        return new HttpEntity(headers);
    }

    public ResponseEntity getResponse(String url, HttpMethod httpMethod) {
        try {
            return http.rest(url, httpMethod, getHeader());
        } catch (
                HttpClientErrorException.Unauthorized e) {
            throw new IllegalArgumentException();
        } catch (HttpClientErrorException.TooManyRequests et) {
            throw new IllegalArgumentException();
        }
    }
}
