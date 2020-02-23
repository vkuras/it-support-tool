package main.app.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class FileService {
    public String getFiles() {
        return null;
    }

    public void saveFile (MultipartFile file, String path){
        InputStream stream = null;

        try {
        stream = file.getInputStream();
        Files.copy(stream, Path.of(path));
        } catch (IOException exception) {
            System.out.println("Exception");
        }

    }

    public byte[] getFile(String path) {
        try {
            return Files.readAllBytes(Path.of(path));
        } catch (IOException exception) {
            return null;
        }
    }
}

