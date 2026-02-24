package etss;

public class Session {
    private static Session instance;
    public String uid;
    private String email;

    private Session() {}

    public static int id = 0;
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}