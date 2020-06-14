package hex.developer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"developer"})
@XmlRootElement(name = "getAllDevelopersResponse")
public class GetAllDevelopersResponse {

    protected List<Developer> developer;

    public List<Developer> getDeveloper() {
        if (developer == null) {
            developer = new ArrayList<>();
        }
        return this.developer;
    }

    public void setDeveloper(List<Developer> val) {
        this.developer = val;
    }
}
