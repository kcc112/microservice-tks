package hex.api.v2;

import hex.adapters.ports.input.developers.IDevelopersUseCase;
import hex.model.developers.Backend;
import hex.model.developers.Developer;
import hex.model.developers.FrontEnd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
class DevelopersApiHexTest {

    List<Developer> developers = new ArrayList<>();
    FrontEnd frontEnd = new FrontEnd();
    Backend backend = new Backend();
    IDevelopersUseCase developersUseCase = Mockito.mock(IDevelopersUseCase.class);
    BindingResult bindingResult = Mockito.mock(BindingResult.class);
    ResponseEntity<FrontEnd> frontEndResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    ResponseEntity<Backend> backendResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    @BeforeEach
    public void setup() {
        FrontEnd frontEnd = new FrontEnd();
        developers.add(frontEnd);
    }

    @InjectMocks
    private DevelopersApiHex developersApiHex = new DevelopersApiHex(developersUseCase);

    @BeforeEach
    void setMockOutput() {
        doReturn(true).when(bindingResult).hasErrors();
        doReturn(developers).when(developersUseCase).getAllDevelopers();
    }

    @DisplayName("Add developer frontend should return 400")
    @Test
    void addDeveloperFrontEnd() {
        assertEquals(frontEndResponseEntity, developersApiHex.addDeveloperFrontEnd(frontEnd, bindingResult));
    }

    @DisplayName("Add developer back end should return 400")
    @Test
    void addDeveloperBackEnd() {
        assertEquals(backendResponseEntity, developersApiHex.addDeveloperBackEnd(backend, bindingResult));
    }

    @DisplayName("Should return list with one developer")
    @Test
    void getDevelopers() {
        assertEquals(1, developersApiHex.getDevelopers(null, null).size());
    }

    @DisplayName("Update developer frontend should return 400")
    @Test
    void updateDeveloperFrontEnd() {
        assertEquals(frontEndResponseEntity, developersApiHex.updateDeveloperFrontEnd(frontEnd, bindingResult));
    }

    @DisplayName("Update developer backend should return 400")
    @Test
    void updateDeveloperBackEnd() {
        assertEquals(backendResponseEntity, developersApiHex.updateDeveloperBackEnd(backend, bindingResult));
    }

    @DisplayName("Delete developer should called once")
    @Test
    void deleteDeveloper() {
        developersApiHex.deleteDeveloper(null);
        verify(developersUseCase, times(1)).deleteDeveloper(null);
    }
}