package hex.api.v2;

import hex.adapters.ports.input.technologies.ITechnologiesUseCase;
import hex.model.technologies.React;
import hex.model.technologies.RubyOnRails;
import hex.model.technologies.Technology;
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
class TechnologiesApiHexTest {

    Technology technology = new Technology();
    React react = new React();
    RubyOnRails rubyOnRails = new RubyOnRails();
    List<Technology> technologies = new ArrayList<>();
    List<RubyOnRails> technologiesBackend = new ArrayList<>();
    List<React> technologiesFrontend = new ArrayList<>();
    ITechnologiesUseCase technologiesUseCase = Mockito.mock(ITechnologiesUseCase.class);

    @BeforeEach
    public void setup() {
        technology.setTechnologyName("React");
        technologies.add(technology);
        technologiesBackend.add(rubyOnRails);
        technologiesFrontend.add(react);
    }

    @InjectMocks
    private TechnologiesApiHex technologiesApiHex = new TechnologiesApiHex(technologiesUseCase);

    @BeforeEach
    void setMockOutput() {
        doReturn(technology).when(technologiesUseCase).selectByName("React");
        doReturn(technologiesFrontend).when(technologiesUseCase).getAllFrontend();
        doReturn(technologiesBackend).when(technologiesUseCase).getAllBackend();
    }

    @DisplayName("Technology name should be React")
    @Test
    void getTechnologies() {
        assertEquals("React", technologiesApiHex.getTechnologies("React").getTechnologyName());
    }

    @DisplayName("Technology should be react")
    @Test
    void getAllTechnologiesFrontEnd() {
        assertEquals(react, technologiesApiHex.getAllTechnologiesFrontEnd().get(0));
    }

    @DisplayName("Technology should be rubyOnRails")
    @Test
    void getAllTechnologiesBackEnd() {
        assertEquals(rubyOnRails, technologiesApiHex.getAllTechnologiesBackEnd().get(0));
    }
}