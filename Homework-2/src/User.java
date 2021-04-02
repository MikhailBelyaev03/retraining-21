import java.util.HashMap;

enum Role {ADMIN, USER, MODERATOR}

public class User {
    private String FullName;
    private Role role;

    public User(String fullName, Role role) {
        FullName = fullName;
        this.role = role;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
