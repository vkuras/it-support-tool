package main.app.service;

import org.springframework.stereotype.Component;

@Component
public class ClientInfoService {
    public String getInfo() {
        return String.valueOf(System.getProperties());
    }
}
