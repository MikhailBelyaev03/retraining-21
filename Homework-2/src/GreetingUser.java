import java.util.HashMap;

public class GreetingUser {
    static HashMap<Role, String> map = new HashMap<>();

    static {
        map.put(Role.ADMIN, "Administrator");
        map.put(Role.USER, "Consumer");
        map.put(Role.MODERATOR, "Chairman");
    }

    public static void main(String[] args) {
        User user1 = new User("John Doe", Role.USER);
        greeting(user1);
        User user2 = new User("John Smith", Role.ADMIN);
        greeting(user2);
        User user3 = new User("Rick Black", Role.MODERATOR);
        greeting(user3);
    }

    public static void greeting(User u) {
        System.out.println("Greeting, "+u.getFullName()+"! You're now a "+map.get(u.getRole()));
    }
}
