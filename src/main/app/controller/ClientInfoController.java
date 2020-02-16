package main.app.controller;

import main.app.service.ClientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientInfoController {
    @Autowired
    private ClientInfoService service;
    /**
     * returns all information about this client
     */
    @GetMapping("/client-info")
    public String getClientInfo(){
        return service.getInfo();
    }
}
