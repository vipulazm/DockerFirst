package org.vipul.dockerfirst.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "UserDto", description = "Data Transfer Object for user information")
public class UserDto {

    @Schema(description = "The name of the user")
    private String name;

    @Schema(description = "The age of the user")
    private Integer age ;
}
