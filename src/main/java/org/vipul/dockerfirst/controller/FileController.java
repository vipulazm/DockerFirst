package org.vipul.dockerfirst.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.vipul.dockerfirst.dto.FileDto;
import org.vipul.dockerfirst.service.FileService;

import java.util.List;

@RestController
@RequestMapping("/file")
@Slf4j
@Tag(name="File Management", description = "APIs for managing file names")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @Operation(summary = "Add a name to the file", description = "Adds a new name to the file and returns a confirmation message.")
    @PostMapping("/addName")
    public String addNames(@RequestBody FileDto fileDto){
       return fileService.addName(fileDto.getName());
    }


    @Operation(summary = "Get all names from the file", description = "Retrieves a list of all names from the file.")
    @GetMapping("/names")
    public List<String> getAllNames() {
        return fileService.getAllNames();
    }


    @Operation(summary = "Delete a name from the file", description = "Deletes a name from the file and returns a confirmation message.")
    @GetMapping("/deleteName/{name}")
    public String deleteByName(@Parameter(description = "The name to delete") @PathVariable(name = "name", required = true) String name){
        return fileService.deleteByName(name);
    }
}
