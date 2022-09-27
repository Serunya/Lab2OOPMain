package xmlwork;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Users {
    @XmlElement(name = "user")

    private ArrayList<User> users = new ArrayList<>();

    public Users() {
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public boolean add(User user) {
        return users.add(user);
    }

    boolean userExists(String login, String password){
        for(User user:users)
            if(user.getLogin().equals(login))
                return user.getPassword().equals(password);
        return false;
    }
}
