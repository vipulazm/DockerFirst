package org.vipul.dockerfirst.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.vipul.dockerfirst.FileService;

import java.util.List;

@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @PostMapping("/addName")
    public String addNames(@RequestBody String name){
       return fileService.addName(name);
    }

    @GetMapping("/names")
    public List<String> getAllNames() {
        return fileService.getAllNames();
    }

    @GetMapping("/deleteName/{name}")
    public String deleteByName(@PathVariable String name){
        return fileService.deleteByName(name);
    }
}
