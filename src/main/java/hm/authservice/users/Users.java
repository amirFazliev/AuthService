package hm.authservice.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Users {
    @NotBlank
    @Size(min=2, max = 30)
    private String user;
    @NotBlank
    @Size(min=3, max=30)
    private String password;

    public Users(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Users() {

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(user, users.user) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, password);
    }

    @Override
    public String toString() {
        return "Users{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
