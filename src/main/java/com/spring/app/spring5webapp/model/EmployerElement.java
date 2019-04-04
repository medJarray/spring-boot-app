package com.spring.app.spring5webapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EmployerElement {
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("matricule")
    private String matricule;

    @ApiModelProperty(required = true, value = "0")
    @JsonProperty("nbrTicketEnCharge")
    private int nbrTicketEnCharge;
}
