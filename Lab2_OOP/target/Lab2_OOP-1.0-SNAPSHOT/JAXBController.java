import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JAXBController {

    public static JAXBController controller = new JAXBController();

    JAXBContext context;
    Marshaller marshaller;
    private final File file = new File("src/main/webapp/data/users.xml");
    {
        try {
            context = JAXBContext.newInstance(User.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public void createUser(User user){
        try {
            System.out.println("Hello world");
            marshaller.marshal(user,file);
            marshaller.marshal(user,System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
