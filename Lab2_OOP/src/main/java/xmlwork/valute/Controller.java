package xmlwork.valute;

import org.xml.sax.InputSource;
import xmlwork.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;

public class Controller {
    JAXBContext context;
    Unmarshaller unmarshaller;
    {
        try {
            context = JAXBContext.newInstance(ValuteCurs.class);
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public ValuteCurs getValueteCurs(OutputStream o){
        return new ValuteCurs();
    }

    public static void main(String[] args) {
        new Controller();
    }
}
