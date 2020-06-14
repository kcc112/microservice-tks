package hex.technology;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public GetTechnologyResponse createGetTechnologyResponse() {
        return new GetTechnologyResponse();
    }

    public Technology createTechnology() {
        return new Technology();
    }

    public GetAllTechnologiesRequest createGetAllTechnologiesRequest() {
        return new GetAllTechnologiesRequest();
    }

    public GetAllTechnologiesResponse createGetAllTechnologiesResponse() {
        return new GetAllTechnologiesResponse();
    }

    public GetTechnologyRequest createGetTechnologyRequest() {
        return new GetTechnologyRequest();
    }

    public GetAllFrontEndTechnologiesRequest createGetAllFrontEndTechnologiesRequest() {
        return new GetAllFrontEndTechnologiesRequest();
    }

    public GetAllFrontEndTechnologiesResponse createGetAllFrontEndTechnologiesResponse() {
        return new GetAllFrontEndTechnologiesResponse();
    }

    public GetAllBackEndTechnologiesRequest createGetAllBackEndTechnologiesRequest() {
        return new GetAllBackEndTechnologiesRequest();
    }

    public GetAllBackEndTechnologiesResponse createGetAllBackEndTechnologiesResponse() {
        return new GetAllBackEndTechnologiesResponse();
    }
}
