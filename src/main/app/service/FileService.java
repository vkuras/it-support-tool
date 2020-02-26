package main.app.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
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
                sb.append("\n");
                if(Files.isDirectory(x.toAbsolutePath())){
                    sb.append("\n");
                    sb.append("+"+ x.getFileName());
                    readFilesWithinADir(x.toAbsolutePath().toString());
                }else{
                    sb.append("\n\t");
                    String fileName = "--"+x.getFileName().getFileName();
                    if(Files.isExecutable(x.toAbsolutePath())){
                        fileName += ("(E)");
                    }
                    sb.append(fileName);
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
                sb.append("\n");
                if(Files.isDirectory(x.toAbsolutePath())){
                    sb.append("+" + x.getFileName());
                }else{
                    sb.append("\n\t");
                    String fileName = "--"+x.getFileName().getFileName();
                    if(Files.isExecutable(x.toAbsolutePath())){
                        fileName += ("(E)");
                    }
                    sb.append(fileName);
                }
            });
            return sb.toString();
        }catch(IOException e){
            return e.toString();
        }
    }

    public void saveFile(MultipartFile file, String path) throws IOException {
        File newFile = new File(path);
        try{
            file.transferTo(newFile);
            outputStream = new BufferedWriter(new FileWriter(path));
            outputStream.write("Created via the upload endpoint @  ===> " + LocalTime.now().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStream != null){
                outputStream.close();
            }
        }
    }

    /**
     * Working path example - /Users/blazej.wielk/Documents/workspace/it-support-tool/src/main/app/controller/FileController.java
     */
    public byte[] getFile(String path){
        byte[] bytes = null;
        try{
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
