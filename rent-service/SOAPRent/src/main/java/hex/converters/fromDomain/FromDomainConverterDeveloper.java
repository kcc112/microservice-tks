package hex.converters.fromDomain;

import hex.developer.Developer;

import java.util.ArrayList;
import java.util.List;

public class FromDomainConverterDeveloper {
    public static List<Developer> convertDevelopersDomainToDevelopersSOAP(List<hex.model.developers.Developer> developersDomain) {
        List<Developer> developersSOAP = new ArrayList<>();
        for (hex.model.developers.Developer dev : developersDomain) {
            Developer developer = new Developer();
            developer.setDeveloperName(dev.getDeveloperName());
            developer.setDeveloperSurname(dev.getDeveloperSurname());
            developer.setTechnology(FromDomainConverterTechnology.convertTechnologyDomainToTechnologySOAP(dev.getDeveloperTechnology()));
            developersSOAP.add(developer);
        }
        return developersSOAP;
    }
}


