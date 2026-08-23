package org.vipul.dockerfirst.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vipul.dockerfirst.exception.FileStorageException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    @Value("${app.file.path}")
    private String filePath;

    @PostMapping("/addNames")
    public String addNames(@RequestBody String name){

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
}
