package com.spring.app.spring5webapp.common.json.builder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class JsonResponseBuilder facilitates the build of {@link ResponseEntity} object<br>
 * <p>
 * Examples of use : <br>
 * <p>
 * <pre>
 * getJsonResponseBuilder().status(HttpStatus.BAD_REQUEST).error(bindingResult)
 * .build();
 * getJsonResponseBuilder().status(HttpStatus.BAD_REQUEST)
 * .error(anAAAException).build();
 * getJsonResponseBuilder().status(HttpStatus.OK).data(&quot;a message&quot;).build();
 * getJsonResponseBuilder().status(HttpStatus.OK).data(anObject).build();
 * getJsonResponseBuilder().status(HttpStatus.OK).data(aList).build();
 * </pre>
 */
@Component
public class JsonResponseBuilder {
    /**
     * FORM_VALIDATION_ERROR_CODE content in errors.code
     */
    public static final String FORM_VALIDATION_ERROR_CODE = "FORM_VALIDATION_ERROR";

    protected Object jsonBody;
    // Default status set to INTERNAL_SERVER_ERROR
    protected HttpStatus status;

    protected MultiValueMap<String, String> headers;


    /**
     * Automatically built a {@link JsonBodyError} based on {@link BindingResult} object
     * <p>
     * <p>This method sets an error in response content resulting from the form validation {@link org.springframework.validation.BindingResult}<br>
     * Conversion is done using {@link #convertBindingResultToErrorMap()} method</p>
     *
     * @param bindingResult the binding result to parse to construct the {@link JsonBodyError}
     * @return the current builder instance with {@link JsonBodyError} filled :
     * <ul>
     * <li>{@link JsonBodyError#setCode(String)} containing {@value #FORM_VALIDATION_ERROR_CODE} </li>
     * <li>{@link JsonBodyError#setMessage(String)} containing form validation message</li>
     * <li>{@link JsonBodyError#setDetails(Object)} with form validation errors details (used for displaying messages client-side)</li>
     * </ul>
     */
    public JsonResponseBuilder error(BindingResult bindingResult) {
        Map<String, List<String>> errors = new HashMap<>();
        ApiError e = new ApiError();
        e.setMessage(String.format("%s error(s) found while trying to validate form", bindingResult.getErrorCount()));

        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            if (errors.get(fieldName) != null) {
                // Field is already in the list
                errors.get(fieldName).add(errorMessage);
            } else {
                // Field is not yet in the list
                List<String> tempError = new ArrayList<>();
                tempError.add(errorMessage);
                errors.put(fieldName, tempError);
            }
        });

        e.setDetails(errors);
        e.setError(JsonResponseBuilder.FORM_VALIDATION_ERROR_CODE);
        e.setStatus(HttpStatus.BAD_REQUEST.toString());
        jsonBody = e;
        status = HttpStatus.BAD_REQUEST;

        return this;
    }


    /**
     * Call this method to finalize creation of the {@link JsonResponse} object
     * <p>
     * <p> set {@link #status} to {@link HttpStatus#INTERNAL_SERVER_ERROR} in {@link #status} not defined thanks to {@link #status(HttpStatus)} method</p>
     *
     * @return the {@link JsonResponse}
     */
    public <T> ResponseEntity<T> build() {
        if (status == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(jsonBody, headers, status);
    }
}
