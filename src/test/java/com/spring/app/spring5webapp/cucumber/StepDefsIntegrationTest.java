package com.spring.app.spring5webapp.cucumber;

import com.spring.app.spring5webapp.model.CreateEmployer;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration
@Import(ConfigIntegrationTest.class)
public class StepDefsIntegrationTest {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ModelMapper mapper;

    private ResponseEntity response;

    private HttpStatus responseStatus;

    private Object responseBody;

    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(HttpStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }


    void execute(String url, HttpMethod method, BiFunction fun) throws IOException {
        //https://stackoverflow.com/questions/19238715/how-to-set-an-accept-header-on-spring-resttemplate-request
        response = (ResponseEntity) fun.apply(url, method);
        setResponseStatus(response.getStatusCode());
        setResponseBody(response.getBody());
    }

    BiFunction<String, HttpMethod, ResponseEntity> getVersion = (url, method) -> restTemplate.exchange(url, method, null, String.class);

    BiFunction<String, HttpMethod, ResponseEntity> getEmployeeList = (url, method) -> restTemplate.exchange(url, method, null, new ParameterizedTypeReference<List<CreateEmployer>>() {
    });

    BiFunction<String, HttpMethod, ResponseEntity> postEmployee = (url, method) -> {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreateEmployer> req = new HttpEntity<>(
                new CreateEmployer("toto", "titi", "12345")
                , headers);
        return restTemplate.exchange(url, HttpMethod.POST, req, CreateEmployer.class);
    };

    @When("^the client calls post /api/employers")
    public void the_client_issues_POST_employers() throws Throwable {
        execute("http://localhost:8090/api/employers", HttpMethod.POST, postEmployee);
    }

    @Given("^the client calls get /api/employers$")
    public void the_client_issues_GET_employers() throws Throwable {
        execute("http://localhost:8090/api/employers", HttpMethod.GET, getEmployeeList);
    }

    @When("^the client calls /api/version$")
    public void the_client_issues_GET_version() throws Throwable {
        execute("http://localhost:8090/api/version", HttpMethod.GET, getVersion);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        assertThat(getResponseStatus().value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(getResponseBody(), is(version));
    }

    @And("^the client receives the created employee :$")
    public void the_client_receives_the_employee_body(DataTable table) throws Throwable {
        final List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        CreateEmployer createdEmployer = mapper.map(rows.get(0), CreateEmployer.class);
        assertTrue(createdEmployer.equals(getResponseBody()));
    }

    //https://stackoverflow.com/questions/31641161/using-java-objects-for-cucumber-testing
    @And("^the client receives all employees :$")
    public void the_client_receives_all_employees_body(DataTable table) throws Throwable {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        List<CreateEmployer> expected = rows.stream().map(r -> mapper.map(r, CreateEmployer.class)).collect(Collectors.toList());
        List<CreateEmployer> actual = (ArrayList) getResponseBody();

        assertThat(actual, is(expected));
    }
}