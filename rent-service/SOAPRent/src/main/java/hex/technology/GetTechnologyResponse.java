package hex.technology;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"technology"})
@XmlRootElement(name = "getTechnologyResponse")
public class GetTechnologyResponse {

    @XmlElement(required = true)
    protected Technology technology;

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology value) {
        this.technology = value;
    }
}
