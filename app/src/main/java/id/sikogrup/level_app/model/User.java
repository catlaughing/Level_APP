package id.sikogrup.level_app;

public class User {
    private String username,email,name,phone,uID;

    public User() {
    }

    public User(String username, String email, String name, String phone, String uID) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.uID = uID;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }
}
