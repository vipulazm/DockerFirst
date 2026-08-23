package org.vipul.dockerfirst.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Data Transfer Object for file operations")
public class FileDto {

    @Schema(description = "The name of the file")
    private String name;

}
