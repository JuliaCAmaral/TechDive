package connection;

public class User {

    private String name;
    private String password;

    public User(String user, String password) {
        this.name = user;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
