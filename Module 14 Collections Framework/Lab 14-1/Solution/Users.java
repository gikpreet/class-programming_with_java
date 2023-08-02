import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Users {
    private List<User> userList = new ArrayList<User>();

    public void addUser(User user) {
        userList.add(user);
    }
}