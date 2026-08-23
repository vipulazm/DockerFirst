package org.vipul.dockerfirst.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.vipul.dockerfirst.exception.FileStorageException;
import org.vipul.dockerfirst.exception.NameNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

@Service
public class FileService {

    @Value("${app.file.path}")
    private String filePath;

    public String addName(String name){
        try{
            Files.writeString(
                    Path.of(filePath),
                    name + System.lineSeparator(),
                    StandardOpenOption.CREATE,StandardOpenOption.APPEND
            );
            return name.concat(" : added successfully");

        }catch (IOException e){
            throw new FileStorageException(String.format("Failed to save '%s' name in file system.", name),e);
        }
    }

    public List<String> getAllNames(){
        try {
            Path path = Path.of(filePath);
            if(Files.exists(path)){
                return Files.readAllLines(path);
            }
            return Collections.emptyList();
        } catch (IOException e) {
            throw new FileStorageException("Failed to read names form file system.",e);
        }
    }

    public String deleteByName(String name){
        try{
            Path path = Path.of(filePath);
            if(!Files.exists(path)){
                throw new FileStorageException(String.format("File '%s' does not exist.", filePath));
            }
            List<String> names = Files.readAllLines(path);
            boolean isExist = names.stream().anyMatch(n -> n.equalsIgnoreCase(name));
            if(!isExist){
                throw new NameNotFoundException(String.format("Name '%s' does not exist in file.", name));
            }
            names.remove(name);
            Files.write(path, names, StandardOpenOption.TRUNCATE_EXISTING);
            return name.concat(" : deleted successfully");

        }catch (IOException e){
            throw new FileStorageException(String.format("Failed to delete '%s' name from file system.", name),e);
        }
    }

}
