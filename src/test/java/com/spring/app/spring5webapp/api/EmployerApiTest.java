package com.spring.app.spring5webapp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.app.spring5webapp.common.ApiEndpoints;
import com.spring.app.spring5webapp.model.Employer;
import com.spring.app.spring5webapp.services.EmployerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * See <a href=
 * "http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/integration-testing.html#spring-mvc-test-server">Spring
 * ServerSide test</a> for HowTO manipulate Spring Fwk
 * <p>
 * <p>
 * Tutorial :
 * https://spring.io/guides/tutorials/bookmarks/#_testing_a_rest_service
 *
 * @author Abderraouf Makhlouf
 */


@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployerApi.class)
public class EmployerApiTest {

    @MockBean
    private EmployerService employerService;

    @Autowired(required = false)
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper jsonMapper;


    @Test
    public void shouldReturnAllEmployer() throws Exception {
        List<Employer> employers = new ArrayList<>();

        when(employerService.getAllEmployer()).thenReturn(employers);
        String employerAsJson = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employers);
        mockMvc.perform(
                MockMvcRequestBuilders.get(ApiEndpoints.EMPLOYERS)
                                      .accept(MediaType.APPLICATION_JSON_VALUE)
                                      .contentType(MediaType.APPLICATION_JSON_VALUE))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json;charset=UTF-8"))
               .andExpect(content().json(employerAsJson));
    }


    @Test
    public void shouldReturnContentWhenSearchByNameAndNameExists() throws Exception {
        Optional<Employer> employer = Optional.of(new Employer("Mohamed", "Jarray", "MJA14588", 2));

        when(employerService.getEmployerByName(anyString())).thenReturn(employer);
        String employerAsJson = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employer);
        mockMvc.perform(
                MockMvcRequestBuilders.get(ApiEndpoints.EMPLOYERS_SEARCH_BY_NAME)
                                      .accept(MediaType.APPLICATION_JSON_VALUE)
                                      .contentType(MediaType.APPLICATION_JSON_VALUE)
                                      .param("name", anyString()))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json;charset=UTF-8"))
               .andExpect(content().json(employerAsJson));
    }

    @Test
    public void shouldReturnContentWhenSearchByNameAndNameIsNotExist() throws Exception {

        when(employerService.getEmployerByName(anyString())).thenReturn(Optional.empty());
        mockMvc.perform(
                MockMvcRequestBuilders.get(ApiEndpoints.EMPLOYERS_SEARCH_BY_NAME)
                                      .accept(MediaType.APPLICATION_JSON_VALUE)
                                      .contentType(MediaType.APPLICATION_JSON_VALUE)
                                      .param("name", anyString()))
               .andExpect(status().isNotFound())
               .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void shouldReturnContentWhenSearchByNameAndNameIsNotExistAndSelectedLanguageIsFr() throws Exception {

        String unFoundEmployer = "unFoundEmployer";
        when(employerService.getEmployerByName(anyString())).thenReturn(Optional.empty());
        mockMvc.perform(
                MockMvcRequestBuilders.get(ApiEndpoints.EMPLOYERS_SEARCH_BY_NAME)
                                      .accept(MediaType.APPLICATION_JSON_VALUE)
                                      .header(HttpHeaders.ACCEPT_LANGUAGE, "fr")
                                      .contentType(MediaType.APPLICATION_JSON_VALUE)
                                      .param("name", unFoundEmployer))
               .andDo(print())
               .andExpect(status().isNotFound())
               .andExpect(content().contentType("application/json;charset=UTF-8"))
               .andExpect(jsonPath("$").value("On peut pas trouver l emplyeur unFoundEmployer"));
    }

    @Test
    public void shouldReturnContentWhenSearchByNameAndNameIsNotExistAndSelectedLanguageIsEn() throws Exception {

        String unFoundEmployer = "unFoundEmployer";
        when(employerService.getEmployerByName(anyString())).thenReturn(Optional.empty());
        mockMvc.perform(
                MockMvcRequestBuilders.get(ApiEndpoints.EMPLOYERS_SEARCH_BY_NAME)
                                      .accept(MediaType.APPLICATION_JSON_VALUE)
                                      .header(HttpHeaders.ACCEPT_LANGUAGE, "en")
                                      .contentType(MediaType.APPLICATION_JSON_VALUE)
                                      .param("name", unFoundEmployer))
               .andDo(print())
               .andExpect(status().isNotFound())
               .andExpect(content().contentType("application/json;charset=UTF-8"))
               .andExpect(jsonPath("$").value("Could not find employee unFoundEmployer"));
    }
}
