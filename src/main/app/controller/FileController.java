package main.app.controller;

import main.app.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {
    @Autowired
    private FileService service;
    /**
     *
     * @return representation of all files on the system
     */
    @GetMapping("/file-system")
    public String getFiles(){
        return service.getFiles();
    }

    @PutMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadFile(@RequestParam("path")String path, @RequestParam("file") MultipartFile file)  {
        service.saveFile(file,path);
    }

    @GetMapping("/download")
    public byte[] getFile(@RequestParam("path")String path){
        return service.getFile(path);
    }

}
