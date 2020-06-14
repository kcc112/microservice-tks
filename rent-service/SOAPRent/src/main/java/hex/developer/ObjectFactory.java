package hex.developer;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Developer createDeveloper() {
        return new Developer();
    }

    public GetAllDevelopersRequest createGetAllDevelopersRequest() {
        return new GetAllDevelopersRequest();
    }

    public GetAllDevelopersResponse createGetAllDevelopersResponse() {
        return new GetAllDevelopersResponse();
    }
}
