package hex.api.v2;

import hex.adapters.ports.input.technologies.ITechnologiesUseCase;
import hex.model.technologies.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v2/technologies")
@RestController
public class TechnologiesApiHex {

    private final ITechnologiesUseCase technologiesUseCase;

    @Autowired
    public TechnologiesApiHex(ITechnologiesUseCase technologiesUseCase) {
        this.technologiesUseCase = technologiesUseCase;
    }

    @GetMapping
    public Technology getTechnologies(@RequestParam(name = "name", required = false) String name) {
        Technology technology;
        technology = technologiesUseCase.selectByName(name);
        return technology;
    }

    @GetMapping("back-end")
    public List<Technology> getAllTechnologiesBackEnd() {
        List<Technology> technologies;
        technologies = technologiesUseCase.getAllBackend();
        return technologies;
    }

    @GetMapping("front-end")
    public List<Technology> getAllTechnologiesFrontEnd() {
        List<Technology> technologies;
        technologies = technologiesUseCase.getAllFrontend();
        return technologies;
    }
}
