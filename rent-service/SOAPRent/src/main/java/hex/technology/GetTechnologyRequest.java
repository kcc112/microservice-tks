package hex.technology;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "technologyName"
})
@XmlRootElement(name = "getTechnologyRequest")
public class GetTechnologyRequest {

    @XmlElement(required = true)
    protected String technologyName;

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String value) {
        this.technologyName = value;
    }
}
