package hex.endpoints;

import hex.adapters.ports.input.developers.IDevelopersUseCase;
import hex.developer.Developer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
class DeveloperEndpointTest {

    List<hex.model.developers.Developer> developersDomain = new ArrayList<>();
    List<Developer> developers = new ArrayList<>();
    IDevelopersUseCase iDevelopersUseCase = Mockito.mock(IDevelopersUseCase.class);

    @BeforeEach
    public void setup() {
        Developer developer = new Developer();
        developer.setDeveloperName("Kamil");
        developers.add(developer);

        hex.model.developers.Developer developerDomain = new hex.model.developers.Developer();
        developerDomain.setDeveloperName("Kamil");
        developersDomain.add(developerDomain);
    }

    @InjectMocks
    private DeveloperEndpoint developerEndpoint = new DeveloperEndpoint(iDevelopersUseCase);

    @BeforeEach
    void setMockOutput() {
        doReturn(developersDomain).when(iDevelopersUseCase).getAllDevelopers();
    }

    @DisplayName("Developers name should be the same")
    @Test
    void getAllDevelopersRequest() {
        assertEquals("Kamil", developerEndpoint.getAllDevelopersRequest().getDeveloper().get(0).getDeveloperName());
    }
}