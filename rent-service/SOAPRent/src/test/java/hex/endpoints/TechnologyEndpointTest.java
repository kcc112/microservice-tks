package hex.endpoints;

import hex.adapters.ports.input.technologies.ITechnologiesUseCase;
import hex.technology.GetTechnologyRequest;
import hex.technology.Technology;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
class TechnologyEndpointTest {

    hex.model.technologies.Technology technologyDomain = new hex.model.technologies.Technology();
    List<hex.model.technologies.Technology> technologiesDomain = new ArrayList<>();
    List<Technology> technologies = new ArrayList<>();
    ITechnologiesUseCase technologiesUseCase = Mockito.mock(ITechnologiesUseCase.class);
    GetTechnologyRequest getTechnologyRequest = new GetTechnologyRequest();

    @BeforeEach
    public void setup() {
        hex.technology.Technology technology = new hex.technology.Technology();
        technologiesDomain.add(technologyDomain);
        technology.setTechnologyName("React");
        technologies.add(technology);
        technologyDomain.setTechnologyName("React");
        getTechnologyRequest.setTechnologyName("React");
    }

    @InjectMocks
    private TechnologyEndpoint technologyEndpoint = new TechnologyEndpoint(technologiesUseCase);

    @BeforeEach
    void setMockOutput() {
        doReturn(technologyDomain).when(technologiesUseCase).selectByName("React");
        doReturn(technologiesDomain).when(technologiesUseCase).getAll();
        doReturn(technologiesDomain).when(technologiesUseCase).getAllFrontend();
        doReturn(technologiesDomain).when(technologiesUseCase).getAllBackend();
    }

    @DisplayName("Technologies name should be the same")
    @Test
    void getTechnologyRequest() {
        assertEquals("React", technologyEndpoint.getTechnologyRequest(getTechnologyRequest).getTechnology().getTechnologyName());
    }

    @DisplayName("Technologies count should be equal 1")
    @Test
    void getAllTechnologiesRequest() {
        assertEquals(1, technologyEndpoint.getAllTechnologiesRequest().getTechnology().size());
    }

    @DisplayName("Technologies count should be equal 1")
    @Test
    void getAllFrontEndTechnologiesRequest() {
        assertEquals(1, technologyEndpoint.getAllFrontEndTechnologiesRequest().getTechnology().size());
    }

    @DisplayName("Technologies count should be equal 1")
    @Test
    void getAllBackEndTechnologiesRequest() {
        assertEquals(1, technologyEndpoint.getAllBackEndTechnologiesRequest().getTechnology().size());
    }
}