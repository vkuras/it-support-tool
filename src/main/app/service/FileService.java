package main.app.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Component
public class FileService {

    private BufferedReader inputStream = null;
    private BufferedWriter outputStream = null;

    public String getFiles() {
        StringBuilder sb = new StringBuilder();
        try{
            String path = System.getProperty("user.dir");
            Stream<Path> walk = Files.walk(Paths.get(path));
            walk.forEach(x -> {
                if(Files.isDirectory(x.toAbsolutePath())){
                    sb.append("\t\n+" + x.getFileName());
                    readFilesWithinADir(x.toAbsolutePath().toString());
                }else{
                    sb.append("\t\t\n --"+x.getFileName().getFileName());
                }
            });
            return sb.toString();
        }catch(IOException e){
            return e.toString();
        }
    }

    private String readFilesWithinADir(String path){
        StringBuilder sb = new StringBuilder();
        try{
            Stream<Path> walk = Files.walk(Paths.get(path));
            walk.forEach(x -> {
                if(Files.isDirectory(x.toAbsolutePath())){
                    sb.append("\t\n+" + x.getFileName());
                }else{
                    sb.append("\t\t\n --"+x.getFileName().getFileName());
                }
            });
            return sb.toString();
        }catch(IOException e){
            return e.toString();
        }
    }

    public void saveFile(MultipartFile file, String path) {

    }

    public byte[] getFile(String path) {
        return null;
    }
}
