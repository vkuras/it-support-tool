package main.app.service;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ClientInfoService {
    public String getInfo() {
        Map<String, String> allPairs = new HashMap<>();
        Properties allProps = System.getProperties();
        allProps.forEach((key, value) -> allPairs.put(key.toString(), value.toString()));
        return allPairs.toString();
    }
}
