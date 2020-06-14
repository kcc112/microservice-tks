package hex.converters.fromDomain;


import hex.technology.Technology;

import java.util.ArrayList;
import java.util.List;

public class FromDomainConverterTechnology {

    public static List<Technology> convertTechnologiesDomainToTechnologiesSOAP(List<hex.model.technologies.Technology> technologiesDomain) {
        List<Technology> technologiesSOAP = new ArrayList<>();
        for (hex.model.technologies.Technology tech : technologiesDomain) {
            Technology technology = new Technology();
            technology.setTechnologyName(tech.getTechnologyName());
            technologiesSOAP.add(technology);
        }
        return technologiesSOAP;
    }

    public static Technology convertTechnologyDomainToTechnologySOAP(hex.model.technologies.Technology technologyDomain) {
        Technology technologySOAP = new Technology();
        if (technologyDomain != null) {
            technologySOAP.setTechnologyName(technologyDomain.getTechnologyName());
        }
        return technologySOAP;
    }
}
