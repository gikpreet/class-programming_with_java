import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
    //     User user1 = new User(1,"User 1",30);
    //     User user2 = new User(2,"User 2",20);
    //     User user3 = new User(3,"User 3",10);
    //     User user4 = new User(4,"User 4",20);
    //     User user5 = new User(5,"User 5",30);

    //     List<User> users = new ArrayList<User>() {
    //         {
    //             add(user1);
    //             add(user2);
    //             add(user3);
    //             add(user4);
    //             add(user5);
    //         }
    //     };

    //     Collections.sort(users);
    //     for (User user: users) {
    //         System.out.println(user);
    //     }
        User user1 = new User(1,"User 1",30);
        User user2 = new User(2,"User 2",20);
        User user3 = new User(3,"User 3",10);
        User user4 = new User(4,"User 4",20);
        User user5 = new User(5,"User 5",30);

        Users users = new Users();
        users.addUser(user1);
        users.addUser(user2);
        users.addUser(user3);
        users.addUser(user4);
        users.addUser(user5);

        for(User user: users) {
            System.out.println(user);
        }
    }
}