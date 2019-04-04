package com.spring.app.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateEmployer {
    @NotBlank
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("firstName")
    private String firstName;
    @NotBlank
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("lastName")
    private String lastName;

    @NotBlank
    @ApiModelProperty(required = true, value = "")
    @JsonProperty("matricule")
    private String matricule;
}