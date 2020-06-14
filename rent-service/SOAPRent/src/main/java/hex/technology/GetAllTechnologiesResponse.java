package hex.technology;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"technology"})
@XmlRootElement(name = "getAllTechnologiesResponse")
public class GetAllTechnologiesResponse {

    protected List<Technology> technology;

    public List<Technology> getTechnology() {
        if (technology == null) {
            technology = new ArrayList<>();
        }
        return this.technology;
    }

    public void setTechnology(List<Technology> val) {
        this.technology = val;
    }
}
