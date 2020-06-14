package hex.endpoints;

import hex.adapters.ports.input.technologies.ITechnologiesUseCase;
import hex.technology.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import static hex.converters.fromDomain.FromDomainConverterTechnology.convertTechnologiesDomainToTechnologiesSOAP;
import static hex.converters.fromDomain.FromDomainConverterTechnology.convertTechnologyDomainToTechnologySOAP;

@Endpoint
public class TechnologyEndpoint {

    private static final String NAMESPACE_URI = "http://www.hex.com/hex/technology";

    private final ITechnologiesUseCase technologiesUseCase;

    @Autowired
    public TechnologyEndpoint(ITechnologiesUseCase technologiesUseCase) {
        this.technologiesUseCase = technologiesUseCase;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTechnologyRequest")
    @ResponsePayload
    public GetTechnologyResponse getTechnologyRequest(@RequestPayload GetTechnologyRequest request) {
        GetTechnologyResponse response = new GetTechnologyResponse();
        response.setTechnology(convertTechnologyDomainToTechnologySOAP(technologiesUseCase.selectByName(request.getTechnologyName())));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllTechnologiesRequest")
    @ResponsePayload
    public GetAllTechnologiesResponse getAllTechnologiesRequest() {
        GetAllTechnologiesResponse response = new GetAllTechnologiesResponse();
        response.setTechnology(convertTechnologiesDomainToTechnologiesSOAP(technologiesUseCase.getAll()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllFrontEndTechnologiesRequest")
    @ResponsePayload
    public GetAllFrontEndTechnologiesResponse getAllFrontEndTechnologiesRequest() {
        GetAllFrontEndTechnologiesResponse response = new GetAllFrontEndTechnologiesResponse();
        response.setTechnology(convertTechnologiesDomainToTechnologiesSOAP(technologiesUseCase.getAllFrontend()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBackEndTechnologiesRequest")
    @ResponsePayload
    public GetAllBackEndTechnologiesResponse getAllBackEndTechnologiesRequest() {
        GetAllBackEndTechnologiesResponse response = new GetAllBackEndTechnologiesResponse();
        response.setTechnology(convertTechnologiesDomainToTechnologiesSOAP(technologiesUseCase.getAllBackend()));
        return response;
    }
}