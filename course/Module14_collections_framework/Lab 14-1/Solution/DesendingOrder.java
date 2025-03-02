import java.util.Comparator;

public class DesendingOrder implements Comparator<User> {
    public int compare(User o1, User o2) {
        if(o1.getUserAge() > o2.getUserAge()){
            return -1;
        }else if( o1.getUserAge() < o2.getUserAge()){
            return 1;
        }else {
            return 0;
        }
    }
}