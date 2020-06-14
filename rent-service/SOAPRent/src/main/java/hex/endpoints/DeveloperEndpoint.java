package hex.endpoints;

import hex.adapters.ports.input.developers.IDevelopersUseCase;
import hex.developer.GetAllDevelopersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static hex.converters.fromDomain.FromDomainConverterDeveloper.convertDevelopersDomainToDevelopersSOAP;

@Endpoint
public class DeveloperEndpoint {
    private static final String NAMESPACE_URI = "http://www.hex.com/hex/developer";

    private final IDevelopersUseCase developersUseCase;

    @Autowired
    public DeveloperEndpoint(IDevelopersUseCase developersUseCase) {
        this.developersUseCase = developersUseCase;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllDevelopersRequest")
    @ResponsePayload
    public GetAllDevelopersResponse getAllDevelopersRequest() {
        GetAllDevelopersResponse response = new GetAllDevelopersResponse();
        response.setDeveloper(convertDevelopersDomainToDevelopersSOAP(developersUseCase.getAllDevelopers()));
        return response;
    }
}
