package sample.model;
import java.io.Serializable;
/**
 *
 * @author sepehr
 */
public class Member implements Serializable {
    String userName;
    String password;
    String name;
    String lastName;
    int validity = 0;

    public Member() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void increaseValidity(int money) {
        this.validity += money;
    }

    public void decreaseValidity(int money) {
        this.validity -= money;
    }

    public int getValidity() {
        return validity;
    }
}

