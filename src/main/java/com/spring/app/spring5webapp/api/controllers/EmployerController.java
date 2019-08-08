package com.spring.app.spring5webapp.api.controllers;

import com.spring.app.spring5webapp.api.EmployerApi;
import com.spring.app.spring5webapp.api.controllers.exception.EmployerNotFoundException;
import com.spring.app.spring5webapp.common.CsvFile;
import com.spring.app.spring5webapp.model.CreateEmployer;
import com.spring.app.spring5webapp.model.EmployerElement;
import com.spring.app.spring5webapp.services.EmployerService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployerController implements EmployerApi {

    private static final String FILE_NAME = "employer-extraction";
    private final MessageSource messageSource;
    private final EmployerService employerService;

    @Override
    public ResponseEntity<EmployerElement> createEmployer(@ApiParam(value = "Ludo", required = true) @Valid @RequestBody CreateEmployer employerToCreate) {
        EmployerElement employer = employerService.createEmployer(employerToCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(employer);
    }

    public ResponseEntity<List<EmployerElement>> getAllEmployers() throws InterruptedException {
        List<EmployerElement> allEmployer = employerService.getAllEmployer();
        return new ResponseEntity(allEmployer, null, allEmployer.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Resource> downloadCsvExtraction() throws InterruptedException, IOException {

        List<EmployerElement> allEmployer = employerService.getAllEmployer();

        // write csv
        InputStreamResource resource = CsvFile.writeCsv(allEmployer);

        return ResponseEntity.ok()
                             .contentType(MediaType.parseMediaType("application/octet-stream"))
                             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + FILE_NAME + ".csv")
                             .body(resource);
    }

    public ResponseEntity<EmployerElement> getEmployerByName(@RequestParam("name") String name) {
        return new ResponseEntity(employerService.getEmployerByName(name)
                                                 .orElseThrow(() -> {
                                                     String notFoundEmployer = messageSource.getMessage("notFoundEmployer", null, LocaleContextHolder.getLocale());
                                                     return new EmployerNotFoundException(MessageFormat.format(notFoundEmployer, name));
                                                 }), null, HttpStatus.OK);
    }
}
