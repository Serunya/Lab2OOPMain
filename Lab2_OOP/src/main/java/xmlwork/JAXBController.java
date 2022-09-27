package xmlwork;

import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class JAXBController {
    File file;
    JAXBContext context;
    Marshaller marshaller;
    Unmarshaller unmarshaller;
    Users users;
    {
        try {
            context = JAXBContext.newInstance(Users.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public JAXBController(String pathFile) {
        file = new File(pathFile);
        try {
            users = (Users) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            users = new Users();
        }
    }

    public void addUser(User user) {
        try {
            users.add(user);
            marshaller.marshal(users, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserExists(String login, String password){
        return users.userExists(login,password);
    }

}
