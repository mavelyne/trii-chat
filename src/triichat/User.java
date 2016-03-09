package triichat;

import java.util.Set;

/**
 * Created by Margret on 3/8/2016.
 */
public class User {

    private String name;
    private String email;
    private Set<User> contacts;
    private Set<Group> groups;

    private User() {

    }

    public static User createUser() {
        return new User();
    }
}
