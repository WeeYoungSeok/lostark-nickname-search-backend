package com.weeloa.lostark.api.util.lostark;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class LostArkHeader {

    public static HttpEntity getHeader(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, "application/json");
        headers.set(HttpHeaders.AUTHORIZATION, "bearer " + token);
        return new HttpEntity(headers);
    }
}
