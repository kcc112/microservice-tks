package hex.technology;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "technology", propOrder = {
    "technologyName"
})
public class Technology {

    @XmlElement(required = true)
    protected String technologyName;

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String value) {
        this.technologyName = value;
    }
}
