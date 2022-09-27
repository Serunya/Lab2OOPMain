package xmlwork.valute;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Valute")
@XmlAccessorType(XmlAccessType.FIELD)
public class Valute {
    @XmlAttribute
    private String ID;

    @XmlElement
    private String NumCode;
    @XmlElement
    private String CharCode;
    @XmlElement
    private String Nominal;
    @XmlElement
    private String Name;
    @XmlElement
    private String Value;

    public Valute(){};

    public String getID() {
        return ID;
    }

    public String getNumCode() {
        return NumCode;
    }

    public String getCharCode() {
        return CharCode;
    }

    public String getNominal() {
        return Nominal;
    }

    public String getName() {
        return Name;
    }

    public String getValue() {
        return Value;
    }
}
