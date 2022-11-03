package xmlwork.valute;

import xmlwork.User;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement(name = "ValCurs")
public class ValuteCurs {

    @XmlAttribute(name = "Date")
    private String Data;
    @XmlAttribute(name = "name")
    private String Name;

    @XmlElement(name = "Valute")
    private ArrayList<Valute> valcurs = new ArrayList<>();

    public ValuteCurs() {
    }

    public void setValcurs(ArrayList<Valute> valcurs) {
        this.valcurs = valcurs;
    }

    public ArrayList<Valute> getValcurs() {
        return valcurs;
    }

    public String getData() {
        return Data;
    }

    public String getName() {
        return Name;
    }
}
