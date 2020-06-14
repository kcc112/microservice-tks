package hex.repository;


import hex.model.technologies.NodeJsEnt;
import hex.model.technologies.ReactEnt;
import hex.model.technologies.RubyOnRailsEnt;
import hex.model.technologies.TechnologyEnt;
import hex.repository.interfaces.ITechnologyRepositoryEnt;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TechnologyRepositoryEnt implements ITechnologyRepositoryEnt {

    private final List<TechnologyEnt> technologies;

    public TechnologyRepositoryEnt() {
        this.technologies = new ArrayList<>();
        technologies.add(new RubyOnRailsEnt());
        technologies.add(new ReactEnt());
        technologies.add(new NodeJsEnt());
    }

    @Override
    public TechnologyEnt selectTechnologyByName(String technologyName) {
        for (TechnologyEnt technology : technologies) {
            if (technology.getTechnologyName().equals(technologyName)) {
                return technology;
            }
        }
        return null;
    }

    @Override
    public List<TechnologyEnt> getAllTechnologies() {
        return technologies;
    }

    @Override
    public List<TechnologyEnt> getAllTechnologiesFrontEnd() {
        List<TechnologyEnt> frontendTechnologies = new ArrayList<>();
        for (TechnologyEnt tech : technologies) {
            if (tech.getClass().equals(ReactEnt.class)) {
                frontendTechnologies.add(tech);
            }
        }
        return frontendTechnologies;
    }

    @Override
    public List<TechnologyEnt> getAllTechnologiesBackEnd() {
        List<TechnologyEnt> backendTechnologies = new ArrayList<>();
        for (TechnologyEnt tech : technologies) {
            if (tech.getClass().equals(RubyOnRailsEnt.class) || tech.getClass().equals(NodeJsEnt.class)) {
                backendTechnologies.add(tech);
            }
        }
        return backendTechnologies;
    }
}
