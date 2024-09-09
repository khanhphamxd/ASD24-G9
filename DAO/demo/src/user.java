public class user {
    private int id;
    private String username;
    private String email;


    public user(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + id +
                ", user_name='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}