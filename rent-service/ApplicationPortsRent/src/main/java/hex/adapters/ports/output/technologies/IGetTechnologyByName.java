package hex.adapters.ports.output.technologies;

import hex.model.technologies.Technology;

public interface IGetTechnologyByName {
    Technology selectTechnologyByName(String technologyName);
}