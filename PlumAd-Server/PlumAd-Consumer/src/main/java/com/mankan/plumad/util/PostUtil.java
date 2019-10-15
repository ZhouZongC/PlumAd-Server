package com.mankan.plumad.util;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author：lq
 * @description：
 * @date：15:22 2018/5/18
 */
@Component
public class PostUtil {
    @Autowired
    RestTemplate restTemplate;

    public   String get(JSONObject params, String url ){
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        String jsonStr = JSONObject.toJSONString(params);
        System.out.println("jsonStr: "+jsonStr);
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonStr, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST,formEntity, String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();

        int code = statusCode.value();
        System.out.print(code);
        String list = responseEntity.getBody();


        return  list;
    }
}