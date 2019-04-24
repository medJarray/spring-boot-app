package com.spring.app.spring5webapp.common.json.builder;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ApiError {
    @ApiModelProperty(value = "")
    @JsonProperty("status")
    private String status = null;
    @ApiModelProperty(value = "")
    @JsonProperty("error")
    private String error = null;
    @ApiModelProperty(value = "")
    @JsonProperty("message")
    private String message = null;
    @ApiModelProperty(value = "")
    @JsonProperty("details")
    private Object details = null;
}

