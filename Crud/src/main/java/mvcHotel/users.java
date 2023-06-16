package mvcHotel;

import static org.codehaus.plexus.util.IOUtil.close;

public class users {
    private int user_id;
    private String username;
    private String email;
    private String password;
    private String phone_number;

    public users(int user_id, String username, String email, String password, String phone_number) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getPhone_number() {
        return phone_number;
    }



}
