package com.steve.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    public MyErrorAttributes(){
        super(true);
    }
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","steve");
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("ext",ext);
        return map;

    }
}
