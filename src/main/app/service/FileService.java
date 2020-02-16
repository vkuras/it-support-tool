package main.app.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileService {
    public String getFiles() {
        return null;
    }

    public void saveFile(MultipartFile file, String path) {
    }

    public byte[] getFile(String path) {
        return null;
    }
}
